package com.callor.eartheden.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.callor.eartheden.models.TrashCanVO;
import com.callor.eartheden.service.TrashCanService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TrashCanServiceImpl implements TrashCanService {

	private final Map<String, List<TrashCanVO>> cachedTrashCans = new HashMap<>();
	private final ResourceLoader resourceLoader;
	private final ObjectMapper mapper;
	private final ServletContext servletContext; // ServletContext 추가

	public TrashCanServiceImpl(ResourceLoader resourceLoader, ServletContext servletContext) throws IOException {
		this.resourceLoader = resourceLoader;
		this.mapper = new ObjectMapper();
		this.servletContext = servletContext; // 주입된 ServletContext 저장
		loadAllTrashCans();
		System.out.println("Trash cans loaded: " + cachedTrashCans.size() + " regions.");

		System.out.println("Cached trash cans:");
		cachedTrashCans.forEach((key, value) -> {
			System.out.println("File: " + key + " - Region: " + (value.isEmpty() ? "None" : value.get(0).getRegion()));
		});
	}

	private void loadAllTrashCans() throws IOException {
		String[] fileNames = { "쓰레기통설치정보서울.json", "쓰레기통설치정보광주.json", "쓰레기통설치정보대구남구.json", "쓰레기통설치정보대구달서구.json",
				"쓰레기통설치정보대구달성군.json", "쓰레기통설치정보대구동구.json", "쓰레기통설치정보대구서구.json", "쓰레기통설치정보대구수성구.json",
				"쓰레기통설치정보대구중구.json", "쓰레기통설치정보대전대덕구.json", "쓰레기통설치정보대전동구.json", "쓰레기통설치정보대전서구.json",
				"쓰레기통설치정보대전중구.json", "쓰레기통설치정보부산금정구.json", "쓰레기통설치정보부산남구.json", "쓰레기통설치정보부산사상구.json",
				"쓰레기통설치정보부산서구.json", "쓰레기통설치정보부산수영구.json", "쓰레기통설치정보부산연제구.json", "쓰레기통설치정보부산해운대구.json",
				"쓰레기통설치정보인천남동구.json" };

		for (String fileName : fileNames) {
			List<TrashCanVO> trashCans = loadTrashCansFromFile(fileName);
			cachedTrashCans.put(fileName, trashCans);
			System.out.println("Loaded " + trashCans.size() + " trash cans from file: " + fileName);
		}
	}

	private List<TrashCanVO> loadTrashCansFromFile(String fileName) {
		try {
			// WebApp의 경로에서 리소스를 로드하기 위해 'file:' 접두사를 사용
			String resourcePath = "file:" + servletContext.getRealPath("/static/json/") + fileName;
			System.out.println("Loading resource from path: " + resourcePath);

			// ResourceLoader로 파일 로드
			Resource resource = resourceLoader.getResource(resourcePath);
			List<TrashCanVO> trashCans = mapper.readValue(resource.getInputStream(),
					new TypeReference<List<TrashCanVO>>() {
					});

			// 파일 이름에서 지역명 추출
			String region = fileName.replace("쓰레기통설치정보", "").replace(".json", "").trim();
			System.out.println("Extracted region from file name: " + region);

			// 각 쓰레기통 객체에 지역명을 설정
			trashCans.forEach(trashCan -> trashCan.setRegion(region));

			System.out.println("Successfully parsed file: " + fileName + ", Region: " + region);
			return trashCans;
		} catch (IOException e) {
			System.err.println("Error loading file: " + fileName + " - " + e.getMessage());
			return List.of(); // 빈 리스트를 반환하여 오류 처리
		}
	}

	@Override
	public List<TrashCanVO> getTrashCansByRegion(String region, String rootPath) {
		System.out.println("Filtering by region: " + region);
		cachedTrashCans.values().forEach(list -> {
			list.forEach(trashCan -> System.out.println("Loaded trash can region: " + trashCan.getRegion()));
		});
		List<TrashCanVO> filteredList = cachedTrashCans.values().stream().flatMap(List::stream)
				.filter(trashCan -> trashCan.getRegion() != null && trashCan.getRegion().equalsIgnoreCase(region))
				.collect(Collectors.toList());
		System.out.println("Found " + filteredList.size() + " trash cans for region: " + region);
		return filteredList;
	}

	@Override
	public List<TrashCanVO> searchTrashCans(String query, String rootPath) {
		System.out.println("Searching for query: " + query);
		List<TrashCanVO> filteredList = cachedTrashCans.values().stream().flatMap(List::stream)
				.peek(trashCan -> System.out.println("Checking location: " + trashCan.getLocation()))
				.filter(trashCan -> trashCan.getLocation().contains(query)).collect(Collectors.toList());
		System.out.println("Found " + filteredList.size() + " trash cans matching query: " + query);
		return filteredList;
	}
}
