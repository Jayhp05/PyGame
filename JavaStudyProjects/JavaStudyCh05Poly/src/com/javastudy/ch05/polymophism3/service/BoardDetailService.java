package com.javastudy.ch05.polymophism3.service;

// 게시 글 상세보기 요청을 처리하는 서비스 클래스
public class BoardDetailService implements CommandProcess{
	
	public String requestProcess() {		
		return "게시 글 상세보기를 화면에 띄운다.";		
	}
}
