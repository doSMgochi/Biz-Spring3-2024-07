package com.callor.eartheden.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.eartheden.models.TrashCanVO;
import com.callor.eartheden.service.TrashCanService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TrashCanServiceImpl implements TrashCanService {

	private final String[] fileNames = { "쓰레기통설치정보서울.json", "쓰레기통설치정보광주.json", "쓰레기통설치정보대구남구.json",
			"쓰레기통설치정보대구달서구.json", "쓰레기통설치정보대구달성군.json", "쓰레기통설치정보대구동구.json", "쓰레기통설치정보대구서구.json", "쓰레기통설치정보대구수성구.json",
			"쓰레기통설치정보대구중구.json", "쓰레기통설치정보대전대덕구.json", "쓰레기통설치정보대전동구.json", "쓰레기통설치정보대전서구.json", "쓰레기통설치정보대전중구.json",
			"쓰레기통설치정보부산금정구.json", "쓰레기통설치정보부산남구.json", "쓰레기통설치정보부산사상구.json", "쓰레기통설치정보부산서구.json", "쓰레기통설치정보부산수영구.json",
			"쓰레기통설치정보부산연제구.json", "쓰레기통설치정보부산해운대구.json", "쓰레기통설치정보인천남동구.json", };

	@Override
	public List<TrashCanVO> getTrashCansByRegion(String region, String rootPath) throws IOException {
		List<TrashCanVO> trashCans = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();

		for (String fileName : fileNames) {
			String filePath = Paths.get(rootPath, "static/json", fileName).toString();
			File file = new File(filePath);

			List<TrashCanVO> regionTrashCans = mapper.readValue(file, new TypeReference<List<TrashCanVO>>() {
			});

			if (fileName.contains(region)) {
				trashCans.addAll(regionTrashCans);
			}
		}

		return trashCans;
	}
}