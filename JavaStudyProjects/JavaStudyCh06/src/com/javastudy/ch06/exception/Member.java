package com.javastudy.ch06.exception;

public class Member {
	
	String name;
	int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override	
	public String toString() {
		return name + "(" + age + ")";
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
