package com.javastudy.ch05.nopolymophism2;

/* 메소드 오버로딩(Method Overloading) 기법을 이용한 다형성
 * 여러 타입의 다양한 Player 객체를 받아 재생하는 기능을 제공하는 클래스
 **/
public class Player {
	
	public void play(MoviePlayer p) {
		p.play();			
	}
	
	public void play(MP3Player p) {
		p.play();			
	}
	
	/* 새로운 미디어가 나올 때 마다 계속해서 새로운 메소드가 추가되어야 한다.
	 **/
	public void play(NewMediaPlayer p) {
		p.play();			
	}
}
