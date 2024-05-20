package com.app.festa.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.festa.main.service.MainService;
import com.app.festa.model.CultureEventInfo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/main")
public class MainController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MainService mainService;
	
	/*
	 * 행사 데이터 조회 API
	 *  -> 기본 메인 화면 조회 
	 * @param CultureEventInfo
	 * @return List<CultureEventInfo>
	 * @throws Exception
	 * 
	 * */
	@Operation(summary = "기본 메인 화면 조회", description = " 사용하는 파라미터 : codeGroup, isFreeCode, guName, thema, title, strtDate, endDate 외의 나머지 파림터는 필요 없음")
	@ApiResponse(responseCode = "200", description = "OK")
	@PostMapping("/cultureEventInfo")
	public List<CultureEventInfo> getCultureEventInfo( @RequestBody CultureEventInfo cultureEventInfo ){
		
		List<CultureEventInfo> cultureEventInfoList = null;
		
		try {
			
			logger.info("행사 데이터 조회 API 시작 ");
			
			cultureEventInfoList = mainService.getCultureEventInfo(cultureEventInfo);
			
			logger.info("행사 데이터 조회 API 종료 ");
		} catch (Exception e) {
			 logger.error("에러발생 : {}", e.getMessage());
		}
		
		return cultureEventInfoList;
	}
}
