package com.javastudy.ch05.inheritance;

// 클래스 상속하기 - 클래스간 상속을 테스트 하는 메인 클래스
public class SmartTvTest {
	
	public static void main(String[] args) {
		
		SmartTv tv = new SmartTv("우리집 TV");
		tv.power();
		tv.channel = 11;
		System.out.println("현재 채널 : " + tv.channelDown());		
		tv.internet();
	}
}