package com.javastudy.ch05.polymophism3.service;

// 요청을 동일한 방식으로 처리하기 위해서 모든 Service 클래스가 구현하는 슈퍼 인터페이스
public interface CommandProcess {	
	public abstract String requestProcess();
}
