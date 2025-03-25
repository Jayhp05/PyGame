package com.javastudy.ch05.polymophism2;

/* 음악을 재생하는 기능을 제공하는 클래스
 * Playable 인터페이스를 구현하도록 클래스를 작성  
 **/
public class MP3Player implements Playable {
	
	String name;
	
	public MP3Player(String name) {
		this.name = name;
	}	
	
	/* MP3Player 클래스는 Player 인터페이스를 구현하는 구현체로
	 * 이 인터페이스가 정의한 추상 메소드를 동영상 재생에 맞게 구현하고 있다.
	 **/  
	@Override
	public void play() {
		System.out.println(this.name +  " 재생 중...");
	}
	
	@Override
	public void stop() {		
		System.out.println(this.name + " 정지");		
	}
}
