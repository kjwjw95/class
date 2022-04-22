package com.codestates.demo.controller

import org.springframework.stereotype.Controller
import com.codestates.demo.dto.memberDto
import com.codestates.demo.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestParam
import reactor.core.publisher.Mono
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping

@Controller
class memberController {
	@Autowired
	private lateinit var memberservice: MemberService;
	//로그인
	@GetMapping("/login")
	fun login(@PathVariable member:memberDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(memberservice.login(member));
	}
	//회원가입
	@PostMapping("/join")
	fun join(@RequestBody member:memberDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(memberservice.Join(member));
	}
	//권한부여(운영자)
	@PutMapping("/role")
	fun role(@RequestBody member:memberDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(memberservice.giveRole(member));
	}
	//권한체크
	@GetMapping("/check")
	fun check(@PathVariable member:memberDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(memberservice.checkRole(member));
	}
}