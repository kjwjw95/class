package com.codestates.demo.service
import com.codestates.demo.dto.boardDto
interface boardService {
	//작성
	fun write(board:boardDto);
	//열람
	fun view(board:boardDto);
	//관리
	fun operate(board:boardDto);
	//리플 작성
	fun reply(board:boardDto);
}