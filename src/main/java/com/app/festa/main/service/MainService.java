package com.app.festa.main.service;

import java.util.List;

import com.app.festa.model.CultureEventInfo;

public interface MainService {

	List<CultureEventInfo> getCultureEventInfo(CultureEventInfo cultureEventInfo) throws Exception;
 
}
