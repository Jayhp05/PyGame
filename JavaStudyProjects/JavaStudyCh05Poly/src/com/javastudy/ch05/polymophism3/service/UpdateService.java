package com.javastudy.ch05.polymophism3.service;

// 게시 글 수정 완료 요청을 처리하는 서비스 클래스
public class UpdateService  implements CommandProcess{
	
	public String requestProcess() {
		return "게시 글 수정을 완료한다.";
	}
}