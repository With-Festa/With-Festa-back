package com.app.festa.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.festa.model.CultureEventInfo;
@Repository
public interface CultureEventInfoRepository extends JpaRepository<CultureEventInfo, Integer>{

	/*
	@Query(value = "SELECT C.EVENT_SEQ ,C.CODE_NAME, C.TITLE, C.DATE, C.PLACE, C.ORG_NAME, C.USE_TRGT, C.USE_FEE, C.PLAYER, C.PROGRAM, C.ETC_DESC, C.ORG_LINK, C.MAIN_IMG, "
			+ "C.RGST_DATE, C.TICKET, C.STRT_DATE, C.END_DATE, C.LOT, C.LAT, C.HMPG_ADDR, C.GU_NAME, C.THE_ME_CODE, C.IS_FREE, C.CODE_GROUP, C.IS_FREE_CODE, C.THEMA "
			+ "FROM CULTUREEVENTINFO C " 
			+ "WHERE 1 = 1 " 
			+ "AND C.STRT_DATE >= CAST(:strtDate AS DATE) "
			+ "AND C.END_DATE <= CAST(:endDate AS DATE) " 
			+ "AND (:codeGroup IS NULL OR C.CODE_GROUP = :codeGroup ) " 
            + "AND (:isFreeCode IS NULL OR C.IS_FREE_CODE = :isFreeCode ) " 
            + "AND (:thema IS NULL OR C.THEMA = :thema ) "  
            + "AND (:guName IS NULL OR C.GU_NAME = :guName )", nativeQuery = true)
	List<CultureEventInfo> findEventInfo(@Param("codeGroup") String codeGroup
									   , @Param("isFreeCode") String isFreeCode
									   , @Param("thema") String thema
									   , @Param("guName") String guName
									   , @Param("strtDate") String strtDate
									   , @Param("endDate") String endDate);
	*/
	
	@Query(value = "SELECT C.EVENT_SEQ ,C.CODE_NAME, C.TITLE, C.DATE, C.PLACE, C.ORG_NAME, C.USE_TRGT, C.USE_FEE, C.PLAYER, C.PROGRAM, C.ETC_DESC, C.ORG_LINK, C.MAIN_IMG, "
			+ "C.RGST_DATE, C.TICKET, C.STRT_DATE, C.END_DATE, C.LOT, C.LAT, C.HMPG_ADDR, C.GU_NAME, C.THE_ME_CODE, C.IS_FREE, C.CODE_GROUP, C.IS_FREE_CODE, C.THEMA "
			+ "FROM CULTUREEVENTINFO C " 
			+ "WHERE 1 = 1 " 
			+ "AND C.STRT_DATE >= CAST(:strtDate AS DATE) "
			+ "AND C.END_DATE <= CAST(:endDate AS DATE) "
			+ "AND (COALESCE(:codeGroup, '')  = '' OR C.CODE_GROUP = :codeGroup)"
			+ "AND (COALESCE(:isFreeCode, '') = '' OR C.IS_FREE_CODE = :isFreeCode)"
			+ "AND (COALESCE(:thema, '') = '' OR C.THEMA = :thema)"
			+ "AND (COALESCE(:guName, '')  = '' OR C.GU_NAME = :guName)"
			+ "AND (COALESCE(:title, '')  = '' OR C.TITLE LIKE CONCAT('%', :title, '%'))" 
			, nativeQuery = true)
	List<CultureEventInfo> findEventInfo(@Param("codeGroup") String codeGroup
									   , @Param("isFreeCode") String isFreeCode
									   , @Param("guName") String guName
									   , @Param("thema") String thema
									   , @Param("title") String title
									   , @Param("strtDate") String strtDate
									   , @Param("endDate") String endDate );
}
