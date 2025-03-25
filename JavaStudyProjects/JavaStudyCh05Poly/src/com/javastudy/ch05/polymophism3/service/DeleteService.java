package com.javastudy.ch05.polymophism3.service;

// 게시 글 삭제 요청을 처리하는 서비스 클래스
public class DeleteService  implements CommandProcess{
	public String requestProcess() {		
		return "게시 글 삭제를 완료한다.";
	}
}
