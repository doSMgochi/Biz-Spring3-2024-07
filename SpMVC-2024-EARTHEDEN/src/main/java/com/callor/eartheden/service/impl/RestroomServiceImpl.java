package com.callor.eartheden.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import com.callor.eartheden.models.RestroomVO;
import com.callor.eartheden.service.RestroomService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RestroomServiceImpl implements RestroomService {

    private static final Logger logger = LoggerFactory.getLogger(RestroomServiceImpl.class);
    private final Map<String, List<RestroomVO>> cachedRestrooms = new HashMap<>();
    private final ResourceLoader resourceLoader;
    private final ObjectMapper mapper;

    public RestroomServiceImpl(ResourceLoader resourceLoader) throws IOException {
        this.resourceLoader = resourceLoader;
        this.mapper = new ObjectMapper();
        loadAllRestrooms();
    }

    private void loadAllRestrooms() throws IOException {
        String[] fileNames = { "공중화장실정보강원.json", "공중화장실정보경기.json", "공중화장실정보경남.json", "공중화장실정보경북.json",
                "공중화장실정보광주.json", "공중화장실정보대구.json", "공중화장실정보대전.json", "공중화장실정보부산.json",
                "공중화장실정보서울.json", "공중화장실정보세종.json", "공중화장실정보울산.json", "공중화장실정보인천.json",
                "공중화장실정보전남.json", "공중화장실정보전북.json", "공중화장실정보제주.json", "공중화장실정보충남.json", "공중화장실정보충북.json" };

        for (String fileName : fileNames) {
            List<RestroomVO> restrooms = loadRestroomsFromFile(fileName);
            cachedRestrooms.put(fileName, restrooms);
            logger.info("Loaded {} restrooms from file: {}", restrooms.size(), fileName);
        }
    }

    private List<RestroomVO> loadRestroomsFromFile(String fileName) {
        try {
            String resourcePath = "classpath:/static/json/" + fileName;
            Resource resource = resourceLoader.getResource(resourcePath);
            List<RestroomVO> restrooms = mapper.readValue(resource.getInputStream(),
                    new TypeReference<List<RestroomVO>>() {
                    });
            return restrooms;
        } catch (IOException e) {
            logger.error("Error loading file: {}", fileName, e);
            return List.of();
        }
    }

    @Override
    public List<RestroomVO> getRestroomsByRegion(String region, String rootPath) {
        return cachedRestrooms.values().stream()
                .flatMap(List::stream)
                .filter(restroom -> restroom.getRegion() != null && restroom.getRegion().startsWith(region))
                .collect(Collectors.toList());
    }
}