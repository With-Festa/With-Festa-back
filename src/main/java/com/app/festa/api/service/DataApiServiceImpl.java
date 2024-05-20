package com.app.festa.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.festa.api.repository.ApiEventInfoRepository;
import com.app.festa.model.CultureEventInfo;

import jakarta.transaction.Transactional;

@Service
public class DataApiServiceImpl implements DataApiService{

//	@Autowired
//	DataApiProcess dataApiProcess;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ApiEventInfoRepository apiEventInfoRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public HashMap<String, Object> getEventInfoData(HashMap<String, Object> resultMap) {
		HashMap<String,Object> messageMap = new HashMap<String,Object>();
		
		if(resultMap == null) {
			messageMap.put("code", "999999");
			messageMap.put("message", "통신오류");
			return messageMap;
		}
		
		logger.info("행사정보 API 행사정보 매핑 및 테이블 저장 ");
		
		
		HashMap<String, Object> result = new HashMap<>(); // 응답결과
		HashMap<String,Object> culturalEventInfo = (HashMap<String, Object>) resultMap.get("culturalEventInfo");
		
		if(!culturalEventInfo.isEmpty()) {
			result = (HashMap<String, Object>) culturalEventInfo.get("RESULT");
		}
		
		List<HashMap<String,Object>> row = (List<HashMap<String, Object>>) culturalEventInfo.get("row");
		
		try {
			
			for(HashMap<String,Object> map : row) {
				
				CultureEventInfoOrganize(map);
				
				apiEventInfoRepository.save(CultureEventInfo.builder()
																.codeName(map.get("CODENAME").toString())
																.guName(map.get("GUNAME").toString())
																.title(map.get("TITLE").toString())
																.date(map.get("DATE").toString())
																.place(map.get("PLACE").toString())
																.orgName(map.get("ORG_NAME").toString())
																.useTrgt(map.get("USE_TRGT").toString())
																.useFee(map.get("USE_FEE").toString())
																.player(map.get("PLAYER").toString())
																.program(map.get("PROGRAM").toString())
																.etcDesc(map.get("ETC_DESC").toString())
																.orgLink(map.get("ORG_LINK").toString())
																.mainImg(map.get("MAIN_IMG").toString())
																.rgstDate(map.get("RGSTDATE").toString())
																.ticket(map.get("TICKET").toString())
																.strtDate((Date)map.get("STRTDATE"))
																.endDate((Date)map.get("END_DATE"))
																.theMeCode(map.get("THEMECODE").toString())
																.lot(map.get("LOT").toString())
																.lat(map.get("LAT").toString())
																.isFree(map.get("IS_FREE").toString())
																.hmpgAddr(map.get("HMPG_ADDR").toString())
																.codeGroup(map.get("CODEGROUP").toString())
																.isFreeCode(map.get("IS_FREE_CODE").toString())
																.thema(map.get("THEMA").toString())
																.build());
																
			}
			
			messageMap.put("code", result.get("CODE").toString());
			messageMap.put("message",  result.get("MESSAGE").toString());
			
		} catch (Exception e) {
			 logger.error("에러발생 : {}", e.getMessage());
			 messageMap.put("code", "999999");
			 messageMap.put("message ", e.getMessage());
		}
		return messageMap;
	}
	
	public HashMap<String, Object> CultureEventInfoOrganize(HashMap<String,Object> map) throws ParseException{
		
		// 시작시간 종료시간 DATE 형으로 변경 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date strtdate = formatter.parse(map.get("STRTDATE").toString());
		Date end_date = formatter.parse(map.get("END_DATE").toString());
		map.put("STRTDATE", strtdate);
		map.put("END_DATE", end_date);
		
		
		// 1. code_group : 문화행사 분류  
		if(map.get("CODENAME") != null) {
			switch(map.get("CODENAME").toString()) {
			case "뮤지컬/오페라" : 
				map.put("CODEGROUP", "01");
				break;
			case "클래식" : 
				map.put("CODEGROUP", "02");
				break;
			case "전시/미술" : 
				map.put("CODEGROUP", "03");
				break;
			case "국악" : 
				map.put("CODEGROUP", "04");
				break;
			case "연극" : 
				map.put("CODEGROUP", "05");
				break;
			case "무용" : 
				map.put("CODEGROUP", "06");
				break;
			case "콘서트" : 
				map.put("CODEGROUP", "07");
				break;
			case "영화" : 
				map.put("CODEGROUP", "08");
				break;
			case "교육/체험" : 
				map.put("CODEGROUP", "09");
				break;
			case "독주/독창회" : 
				map.put("CODEGROUP", "10");
				break;
			case "축제-문화/예술" : 
				map.put("CODEGROUP", "11");
				break;
			case "축제-/기타" : 
				map.put("CODEGROUP", "12");
				break;
			case "축제-자연/경관" : 
				map.put("CODEGROUP", "13");
				break;
			case "기타" : 
				map.put("CODEGROUP", "14");
				break;
			default : 
				map.put("CODEGROUP", "14");
				break;
			
			}
		}
		
		// 1.IS_FREE_CODE :  무료 분류 
		if(map.get("IS_FREE") != null) {
			switch(map.get("IS_FREE").toString()) {
			case "무료" : 
				map.put("IS_FREE_CODE", "01");
			break;
			case "유료":
				map.put("IS_FREE_CODE", "02");
			break;
			}
		}
		
		// THEMA : 테마 분류 
		if(map.get("THEMECODE") != null) {
			switch(map.get("THEMECODE").toString()) {
			case "어린이/청소년 문화행사" : 
				map.put("THEMA", "01");
				break;
			case "문화가 있는 날" : 
				map.put("THEMA", "02");
				break;
			case "가족 문화행사" : 
				map.put("THEMA", "03");
				break;
			case "어르신 문화행사" : 
				map.put("THEMA", "04");
				break;
			case "여성 문화행사" : 
				map.put("THEMA", "05");
				break;
			case "기타" : 
				map.put("THEMA", "06");
				break;
			default : 
				map.put("THEMA", "06");
				break;
			}
		}
	
		return map;
	}
	
}
