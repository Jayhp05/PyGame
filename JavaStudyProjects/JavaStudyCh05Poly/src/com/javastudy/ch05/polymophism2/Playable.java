package com.javastudy.ch05.polymophism2;

public interface Playable {

	/* 여러 종류의 플레이어가 공통으로 가지는 기능을 추상 메서드로 정의
	 * 
	 * 재생을 시작하는 추상 메서드	 
	 * 아래와 같이 메서드 선언부만 존재하고 구현부가 없는 메서드를 추상 메서드라고 한다. 
	 **/
	public abstract void play();
	
	/* 재생을 멈추는 추상 메서드
	 * 인터페이스의 모든 메서드는 추상 메서드로 아래와 같이 메서드 선언부 앞부분에 
	 * public abstract를 생략하면 컴파일러가 자동으로 public abstract를 붙여 준다.
	 **/
	void stop();
}


