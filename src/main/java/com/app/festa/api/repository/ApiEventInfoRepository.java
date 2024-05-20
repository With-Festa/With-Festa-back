package com.app.festa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.festa.model.CultureEventInfo;
import com.app.festa.model.CultureEventInfo.CultureEventInfoBuilder;

@Repository
public interface ApiEventInfoRepository extends JpaRepository<CultureEventInfo, Integer>{

	void save(CultureEventInfoBuilder builder);

}
