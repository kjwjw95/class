package com.codestates.demo.dto

data class boardDto (
	val title:String="",
	val name:String="",
	val contents:String="",
	val date:String="",
	val number:Int=0,
	val reply:Array<String>,
	val hide:Boolean=false
)