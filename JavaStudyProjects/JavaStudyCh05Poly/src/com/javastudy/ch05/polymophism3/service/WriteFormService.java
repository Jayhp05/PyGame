package com.javastudy.ch05.polymophism3.service;

// 게시 글쓰기 폼 요청을 처리하는 서비스 클래스
public class WriteFormService  implements CommandProcess{
	
	public String requestProcess() {
		return "게시 글 쓰기 폼을 화면에 띄운다.";
	}
}