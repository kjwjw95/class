package com.codestates.demo.service

import com.codestates.demo.dto.classDto
interface classService {
	//강의생성
	fun makeClass(classdto:classDto);
	//강의운영
	fun operateClass(classdto:classDto);
	//컨텐츠관리
	fun operateContents(classdto:classDto);
	//열람
	fun viewClass(classdto:classDto);
	//별점
	fun evaluateClass(classdto:classDto);
	//수강신청
	fun enrolment(classdto:classDto);
	//리플 작성
	fun reply(classdto:classDto);
}