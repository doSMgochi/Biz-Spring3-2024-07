package com.callor.eartheden.service;

import java.io.IOException;
import java.util.List;
import com.callor.eartheden.models.RestroomVO;

public interface RestroomService {
    List<RestroomVO> getRestroomsByRegion(String region, String rootPath) throws IOException;
}