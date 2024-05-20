package com.app.festa.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cultureeventinfo" )
public class CultureEventInfo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "cultureEventInfo_Seq", allocationSize = 1)
	private int EventSeq;
	
	
	private	String codeName;    // 분류
	private	String guName;		// 자치구
	private	String title;		// 공연/행사명
	private	String date;		// 날짜/시간
	private	String place;		// 장소
	private	String orgName;		// 기관명
	private	String useTrgt;		// 이용대상
	private	String useFee;		// 이용요금
	private	String player;		// 출연자정보
	private	String program;		// 프로그램소개
	private	String etcDesc;		// 기타내용
	private	String orgLink;		// 홈페이지 주소
	private	String mainImg;		// 대표이미지
	private	String rgstDate;	// 신청일
	private	String ticket;		// 시민/기관
	private	Date   strtDate;	// 시작일
	private	Date   endDate;		// 종료일
	private	String theMeCode;	// 테마분류
	private	String lot;			// 위도(X좌표)
	private	String lat;			// 경도(Y좌표)
	private	String isFree;		// 유무료
	private	String hmpgAddr;	// 문화포털상세URL
	private String codeGroup;	// 코드 그룹 
	private String isFreeCode;  // 무료 유쿠 
	private String thema;		// 테마 
	
	
}

