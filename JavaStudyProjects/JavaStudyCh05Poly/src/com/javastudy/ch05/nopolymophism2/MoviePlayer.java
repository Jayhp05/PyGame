package com.javastudy.ch05.nopolymophism2;

// 동영상을 재생하는 기능을 제공하는 클래스
public class MoviePlayer {
	
	String name;	
	
	public MoviePlayer(String name) {		
		this.name = name;
	}
	
	public void play() {
		System.out.println(this.name + " 재생 중...");
	}	
	
	public void stop() {			
		System.out.println(this.name + " 정지");		
	}
}
