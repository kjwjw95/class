package com.codestates.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestBody
import com.codestates.demo.dto.boardDto
import com.codestates.demo.service.boardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.http.MediaType
import reactor.core.publisher.Mono
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping

@Controller
class boardController {
	@Autowired
	private lateinit var boardservice: boardService;
	
	var memberClinet:WebClient = WebClient.create("http://localhost:8081");
	//게시판 게시글 작성
	@PostMapping("/write")
	@ResponseBody
	fun write(@RequestBody board:boardDto):Mono<ServerResponse>{
		var role = memberClinet.get().uri("/check/{id}",board.name).retrieve().bodyToMono(Boolean::class.java);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(boardservice.write(board));
	}
	//게시판 게시글 열람
	@GetMapping("/view")
	@ResponseBody
	fun view(@PathVariable board:boardDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(boardservice.view(board));
	}
	//게시판 숨김처리
	@PutMapping("/operate")
	@ResponseBody
	fun operate(@PathVariable board:boardDto):Mono<ServerResponse>{
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(boardservice.operate(board));
	}
}