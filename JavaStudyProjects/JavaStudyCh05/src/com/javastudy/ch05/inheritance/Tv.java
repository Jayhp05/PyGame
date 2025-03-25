package com.javastudy.ch05.inheritance;

//클래스 상속하기 - 상속하는 부모 클래스
public class Tv {
	
	protected String name;
	protected boolean power;
	protected int channel;
	
	public Tv(String name) {
		this.name = name;
	}
	
	// Tv 전원을 On/Off 하는 메서드
	public void power() {
		power = !power;
	}
	
	// Tv 채널을 1씩 증가시키는 메서드
	public int channelUp() {
		return ++channel;
	}
	
	// Tv 채널을 1씩 감소시키는 메서드
	public int channelDown() {
		return --channel;
	}
}
