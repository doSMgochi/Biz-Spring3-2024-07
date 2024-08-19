package com.callor.eartheden.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static final Logger logger = LoggerFactory.getLogger(TrashCanServiceImpl.class);
	private final Map<String, List<TrashCanVO>> cachedTrashCans = new HashMap<>();
	private final ResourceLoader resourceLoader;
	private final ObjectMapper mapper;
	private final ServletContext servletContext;

	public TrashCanServiceImpl(ResourceLoader resourceLoader, ServletContext servletContext) throws IOException {
		this.resourceLoader = resourceLoader;
		this.mapper = new ObjectMapper();
		this.servletContext = servletContext;
		loadAllTrashCans();
		System.out.println("Trash cans loaded: " + cachedTrashCans.size() + " regions.");
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
			String resourcePath = "file:" + servletContext.getRealPath("/static/json/") + fileName;
			System.out.println("Loading resource from path: " + resourcePath);

			Resource resource = resourceLoader.getResource(resourcePath);
			List<TrashCanVO> trashCans = mapper.readValue(resource.getInputStream(),
					new TypeReference<List<TrashCanVO>>() {
					});

			System.out.println("Successfully parsed file: " + fileName);
			return trashCans;
		} catch (IOException e) {
			System.err.println("Error loading file: " + fileName + " - " + e.getMessage());
			return List.of(); // 빈 리스트를 반환하여 오류 처리
		}
	}

	@Override
	public List<TrashCanVO> getTrashCansByRegion(String region, String rootPath) {
	    logger.info("getTrashCansByRegion called with region: {}", region);

	    List<TrashCanVO> filteredList;
	    
	    if ("서울 전체".equalsIgnoreCase(region) || "광주 전체".equalsIgnoreCase(region)) {
	        // 서울 또는 광주의 전체 데이터를 반환 (모든 관련 파일 로드)
	        filteredList = cachedTrashCans.values().stream()
	                                      .flatMap(List::stream)
	                                      .filter(trashCan -> trashCan.getRegion() != null && trashCan.getRegion().startsWith(region.replace(" 전체", "")))
	                                      .collect(Collectors.toList());
	        logger.info("Returning all trash cans for region: {}", region);
	    } else if (region.endsWith("전체")) {
	        // 예: 대구 전체 -> 대구로 시작하는 모든 데이터를 반환
	        String city = region.replace(" 전체", "");
	        filteredList = cachedTrashCans.values().stream()
	                                      .flatMap(List::stream)
	                                      .filter(trashCan -> trashCan.getRegion() != null && trashCan.getRegion().startsWith(city))
	                                      .collect(Collectors.toList());
	        logger.info("Returning all trash cans for city: {}", city);
	    } else {
	        // 특정 지역 (구) 선택 시 해당 지역 데이터만 반환
	        filteredList = cachedTrashCans.values().stream()
	                                      .flatMap(List::stream)
	                                      .filter(trashCan -> trashCan.getRegion() != null && trashCan.getRegion().equalsIgnoreCase(region))
	                                      .collect(Collectors.toList());
	        logger.info("Found {} trash cans for region: {}", filteredList.size(), region);
	    }

	    return filteredList;
	}

	@Override
	public List<TrashCanVO> searchTrashCans(String query, String rootPath) {
		logger.info("searchTrashCans called with query: {}", query);
		List<TrashCanVO> filteredList = cachedTrashCans.values().stream().flatMap(List::stream).filter(trashCan -> {
			boolean matches = trashCan.getLocation().contains(query);
			logger.debug("Checking location: {}, matches: {}", trashCan.getLocation(), matches);
			return matches;
		}).collect(Collectors.toList());
		logger.info("Found {} trash cans matching query: {}", filteredList.size(), query);
		return filteredList;
	}
}
