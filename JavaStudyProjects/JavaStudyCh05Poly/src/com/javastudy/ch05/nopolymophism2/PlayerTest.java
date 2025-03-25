package com.javastudy.ch05.nopolymophism2;


public class PlayerTest {
	
	public static void main(String[] args) {
		
		MP3Player p1 = new MP3Player("MP3Player");
		MoviePlayer p2 = new MoviePlayer("MoviePlayer");
		NewMediaPlayer p3 = new NewMediaPlayer("NewMediaPlayer");
		
		p1.play();		
		p2.play();
		p3.play();
		System.out.println();
				
		// Player 클래스를 이용해 각각의 미디어를 재생하는 메소드 호출 
		Player p = new Player();
		p.play(p1);
		p.play(p2);
		p.play(p3);
		System.out.println();
		
		
	}
}

