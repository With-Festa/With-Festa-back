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

import io.swagger.v3.oas.annotations.Operation;

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
	@Operation(summary = "행사 데이터 조회 API", description = "statrIndex : 시작 인덱스, endIndex : 종료 인덱스 // 행사 정보를 인덱스로 불러오는 API, 1번 호출시 최대 1000개씩 조회 가능 ")
	@GetMapping("/eventInfo")
	public String getEventInfoData(@RequestParam String startIndex, @RequestParam String endIndex) {
		
		HashMap<String,Object> paramMap = new HashMap<>();
		
		paramMap.put("startIndex", startIndex);
		paramMap.put("endIndex", endIndex);
		
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