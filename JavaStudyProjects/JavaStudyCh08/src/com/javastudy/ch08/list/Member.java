package com.javastudy.ch08.list;

// 회원 한 명의 정보를 저장하는 클래스
public class Member {
	
	private String id;
	private String name;
	private int age;
	
	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
