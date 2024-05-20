package com.app.festa.api.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.festa.model.CultureEventInfo;

public class DataApiProcessImpl implements DataApiProcess{


	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getEventInfoData(HashMap<String, Object> resultMap) {
		logger.info("행사정보 API 행사정보 매핑 및 테이블 저장 ");
		
		HashMap<String, Object> result = new HashMap<>(); // 응답결과
		HashMap<String,Object> culturalEventInfo = (HashMap<String, Object>) resultMap.get("culturalEventInfo");
		
		if(!culturalEventInfo.isEmpty()) {
			result = (HashMap<String, Object>) culturalEventInfo.get("RESULT");
		}
		
		ArrayList<CultureEventInfo> cultureEventInfoList =  cultureEventInfoSetting(culturalEventInfo);
		
		
		
		if(!"INFO-000".equals(result.get("CODE").toString())) {
			 logger.error("에러발생 : {}", result.get("MESSAGE"));
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CultureEventInfo> cultureEventInfoSetting(HashMap<String,Object> resultMap) {
		
		ArrayList<CultureEventInfo> cultureInfoList = new ArrayList<>();
		
		List<HashMap<String,Object>> row = (List<HashMap<String, Object>>) resultMap.get("row");

		for(HashMap<String,Object> map : row) {
			
		//	CultureEventInfo cultureEventInfo = new CultureEventInfo();
			/*
			cultureEventInfo.setCodeName(map.get("CODENAME").toString());
			cultureEventInfo.setGuName(map.get("GUNAME").toString());
			cultureEventInfo.setTitle(map.get("TITLE").toString());
			cultureEventInfo.setDate(map.get("DATE").toString());
			cultureEventInfo.setPlace(map.get("PLACE").toString());
			cultureEventInfo.setOrgName(map.get("ORG_NAME").toString());
			cultureEventInfo.setUseTrgt(map.get("USE_TRGT").toString());
			cultureEventInfo.setUseFee(map.get("USE_FEE").toString());
			cultureEventInfo.setPlayer(map.get("PLAYER").toString());
			cultureEventInfo.setProgram(map.get("PROGRAM").toString());
			cultureEventInfo.setEtcDesc(map.get("ETC_DESC").toString());
			cultureEventInfo.setOrgLink(map.get("ORG_LINK").toString());
			cultureEventInfo.setMainImg(map.get("MAIN_IMG").toString());
			cultureEventInfo.setRgstDate(map.get("RGSTDATE").toString());
			cultureEventInfo.setTicket(map.get("TICKET").toString());
			cultureEventInfo.setStrtDate(map.get("STRTDATE").toString());
			cultureEventInfo.setEndDate(map.get("END_DATE").toString());
			cultureEventInfo.setTheMeCode(map.get("THEMECODE").toString());
			cultureEventInfo.setLot(map.get("LOT").toString());
			cultureEventInfo.setLat(map.get("LAT").toString());
			cultureEventInfo.setIsFree(map.get("IS_FREE").toString());
			cultureEventInfo.setHmpgAddr(map.get("HMPG_ADDR").toString());
			*/
			//cultureInfoList.add(cultureEventInfo);
		}
		
		return cultureInfoList;
	}	
}
