package com.codestates.demo.service
import com.codestates.demo.dto.memberDto
interface MemberService {
	//회원가입
	fun Join(member:memberDto);
	//로그인
	fun login(member:memberDto);
	//역할주기
	fun giveRole(member:memberDto);
	//권한체크
	fun checkRole(member:memberDto);
}