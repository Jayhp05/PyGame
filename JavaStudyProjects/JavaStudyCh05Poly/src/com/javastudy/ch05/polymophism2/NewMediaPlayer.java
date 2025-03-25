package com.javastudy.ch05.polymophism2;

/* 새로운 미디어를 재생하는 기능을 제공하는 클래스
 * Playable 인터페이스를 구현하도록 클래스를 작성 
 **/
public class NewMediaPlayer implements Playable {
	
	String name;
	
	public NewMediaPlayer(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println(this.name +  " 재생 중...");
	}

	@Override
	public void stop() {		
		System.out.println(this.name + " 정지");
	}
}
