package com.app.festa.main.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.festa.api.repository.CultureEventInfoRepository;
import com.app.festa.model.CultureEventInfo;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	CultureEventInfoRepository cultureEventInfoRepository;
	
	@Override
	public List<CultureEventInfo> getCultureEventInfo( CultureEventInfo cultureEventInfo) throws Exception {
		
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		List<CultureEventInfo> cultureEventInfoList = null;
		
		String codeGroup = cultureEventInfo.getCodeGroup();
		String isFreeCode = cultureEventInfo.getIsFreeCode();
		String guName = cultureEventInfo.getGuName();
		String thema = cultureEventInfo.getThema();
		Date strtDate = cultureEventInfo.getStrtDate();
		Date endDate = cultureEventInfo.getEndDate();
		String title = cultureEventInfo.getTitle();
		String strtDateS ="";
		String endDateS = "";
		 
		
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 
			// 날짜가 null 일 경우 현재시간 넣기 
			 if(strtDate == null || endDate == null) {
				Date now = new Date();
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				
				cal.add(Calendar.MONTH, -1);
				strtDate = cal.getTime();
				strtDateS = dateFormat.format(cal.getTime());
				
				cal.add(Calendar.MONTH, 3);
				endDate = cal.getTime();
				endDateS = dateFormat.format(cal.getTime());
			 }else {
				 strtDateS = dateFormat.format(strtDate);
				 endDateS = dateFormat.format(endDate);
			 }
			
			cultureEventInfoList = cultureEventInfoRepository.findEventInfo(codeGroup, isFreeCode, guName, thema, title, strtDateS, endDateS);
			
		}catch (Exception e) {
			 logger.error("에러발생 : {}", e.getMessage());
		}
		
		return cultureEventInfoList;
	}

}
