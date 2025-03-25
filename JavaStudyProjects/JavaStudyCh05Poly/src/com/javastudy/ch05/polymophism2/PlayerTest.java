package com.javastudy.ch05.polymophism2;


public class PlayerTest {
	
	public static void main(String[] args) {
		
		MP3Player p1 = new MP3Player("MP3Player");
		MoviePlayer p2 = new MoviePlayer("MoviePlayer");
		
		p1.play();		
		p2.play();
		System.out.println();
		
		/* 매개변수가 Playable 타입이므로 업 캐스팅 되어 메서드에 전달된다.
		 * 오버라이딩과 업캐스팅을 통해 Playable 하나의 타입으로 이 인터페이스를
		 * 구현한 3개의 하위 타입의 객체를 다음과 같이 동일한 방식으로 처리할 수 있다. 
		 **/
		Player p = new Player();
		p.play(p1);
		p.play(p2);
		
		// 새롭게 나온 미디어 플레이어 또한 동일한 방식으로 처리할 수 있다.
		NewMediaPlayer p3 = new NewMediaPlayer("NewMediaPlayer");
		p.play(p3);		
	}
}

