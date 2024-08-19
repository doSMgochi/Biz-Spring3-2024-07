package com.callor.eartheden.service;

import java.io.IOException;
import java.util.List;
import com.callor.eartheden.models.WifiVO;

public interface WifiService {
    List<WifiVO> getWifisByRegion(String region, String rootPath) throws IOException;
}