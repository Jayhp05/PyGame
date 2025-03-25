package com.javastudy.ch05.polymophism3.service;

// 로그인 폼 요청을 처리하는 서비스 클래스
public class LoginFormService  implements CommandProcess{
	
	public String requestProcess() {
		return "로그인 폼을 화면에 띄운다.";
	}
}