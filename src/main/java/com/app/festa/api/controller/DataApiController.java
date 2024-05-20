package com.app.festa.api.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.festa.api.service.DataApiService;
import com.app.festa.module.ConnectionModule;

@RestController
@RequestMapping("/data")
public class DataApiController {
	
	
	ConnectionModule connectionModule = new ConnectionModule();
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataApiService dataApiService;
	
	/**
	 * 행사 데이터 조회 API 
	 * -> 정부가 제공하는 행사정보를 받아오기 위한 API  
	 * @param startData
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/eventInfo")
	public String getEventInfoData(@RequestParam String startData, @RequestParam String endData) {
		
		HashMap<String,Object> paramMap = new HashMap<>();
		
		paramMap.put("startData", startData);
		paramMap.put("endData", endData);
		
		logger.info("행사정보 API 행사정보 동기화 시작");
		try {
			//통신 모듈
			HashMap<String, Object> resultMap = connectionModule.connectionModule_EventInfo(paramMap);
			
			paramMap = dataApiService.getEventInfoData(resultMap);
			
		} catch (Exception e) {
			return e.getMessage();
		}
		
		logger.info("행사정보 API 행사정보 동기화 완료");
		
		return "";
	}
	
}