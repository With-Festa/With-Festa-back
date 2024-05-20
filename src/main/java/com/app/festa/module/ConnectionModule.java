package com.app.festa.module;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConnectionModule {

	protected final ObjectMapper objectMapper = new ObjectMapper();
	 
	@SuppressWarnings("unchecked")
	public HashMap<String,Object> connectionModule_EventInfo(HashMap<String,Object> paramMap) throws Exception{
		
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		HashMap<String,Object> resultMap = null;
		
		String apiKey = "43716950626d616736324153517043";
		
		String connection_url = "http://openapi.seoul.go.kr:8088/" + apiKey + "/json/culturalEventInfo/"+paramMap.get("startData") + "/" + paramMap.get("endData");
        
		try {
			 URL url = new URL(connection_url);
	         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         
	         BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         StringBuilder response = new StringBuilder();
	         
	         String line ;
	         while((line = reader.readLine()) != null) {
	        	 response.append(line);
	         }
	         
			resultMap = objectMapper.readValue(response.toString(), HashMap.class);
			
		} catch (Exception e) {
			 logger.error("에러 발생: {}", e.getMessage(), e);
			 throw new Exception(e.getMessage());
		}
		
		return resultMap;
	}
}
