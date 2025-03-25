package com.javastudy.ch05.nopolymophism2;

// 새로운 미디어를 재생하는 기능을 제공하는 클래스
public class NewMediaPlayer {
	
	String name;
	
	public NewMediaPlayer(String name) {
		this.name = name;
	}
	
	public void play() {
		System.out.println(this.name +  " 재생 중...");
	}

	public void stop() {		
		System.out.println(this.name + " 정지");
	}
}
