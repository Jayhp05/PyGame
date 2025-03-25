package com.javastudy.ch05.polymophism3.service;

// 회원 로그아웃 요청을 처리하는 서비스 클래스
public class LogoutService  implements CommandProcess{
	
	public String requestProcess() {		
		return "로그아웃을 처리한다.";
	}
}
