package com.codestates.demo.controller

import org.springframework.stereotype.Controller
import com.codestates.demo.dto.classDto
import com.codestates.demo.service.classService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping

@Controller
class classController {
	@Autowired
	private lateinit var classservice: classService;
	//강의 목록 조회
	@GetMapping("/view")
	fun viewClass(@PathVariable classdto:classDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(classservice.viewClass(classdto));
	}
	//강의 업로드(강사)
	@PostMapping("/make")
	fun make(@PathVariable classdto:classDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(classservice.makeClass(classdto));
	}
	//강의올리기(강사)
	@PutMapping("/make")
	fun operate(@PathVariable classdto:classDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(classservice.operateClass(classdto));
	}
	//강의에 콘텐츠 추가(강사)
	@PutMapping("/contents")
	fun contents(@PathVariable classdto:classDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(classservice.operateContents(classdto));
	}
	//강의 별점남기기(학생)
	@PutMapping("/evaluate")
	fun evaluate(@PathVariable classdto:classDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(classservice.evaluateClass(classdto));
	}
	//수강신청
	@PutMapping("/enrolment")
	fun enrolment(@PathVariable classdto:classDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(classservice.enrolment(classdto));
	}
	//수강신청
	@PutMapping("/reply")
	fun reply(@PathVariable classdto:classDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(classservice.reply(classdto));
	}
}