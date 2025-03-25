package com.javastudy.ch04.overloading;

// 자신의 다른 생성자를 호출하는 this()와 생성자 오버로딩
public class Player {
	
	// Player 클래스는 인스턴스 변수(Property - 속성) 4개를 가지고 있다.
	private String name;
	private int age;
	private String gender;
	private String nationality;

	/* 생성자를 정의할 때 생성자의 이름은 클래스 이름과 동일해야 하며
	 * 생성자도 메서드에 일종으로 여러 개 정의할 수 있는 생성자 오버로딩이 가능하다.
	 * 생성자는 객체가 생성된 후 그 객체의 속성을 초기화 할 목적으로 주로 사용된다. 
	 **/
	public Player(String name, int age, String gender) {
		
		/* this() 생성자는 같은 클래스 내의 다른 생성자를 호출 한다.
		 * this() 생성자는 항상 생성자의 맨 첫줄에 기술해야 한다.
		 * this() 생성자를 이용해 매개변수가 4개인 생성자를 호출하고 있다.
		 **/
		this(name, age, gender, "대한민국");
	}
	
	public Player(String name, String gender, String nationality) {
		
		// this() 생성자를 이용해 매개변수가 4개인 생성자를 호출하고 있다.
		this(name, 20, gender, nationality);
	}
	
	public Player(String name, int age, String gender, String nationality) {
		
		// 매개변수로 받은 데이터를 인스턴스 변수에 대입하고 있다.
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
	}	
	
	public static void main(String[] args) {		
				
		Player p1 = new Player("크리스", "여성", "미국");
		Player p2 = new Player("마이클", 25, "남성", "호주");		
		
		System.out.println("\t\t\t## 출전 선수 ##");
		System.out.println("\t국가명\t\t이름\t\t나이\t\t성별");	
		System.out.printf("\t%s\t\t%s\t\t%s\t\t%s\n", p1.nationality, 
				p1.name, p1.age, p1.gender);
		System.out.printf("\t%s\t\t%s\t\t%s\t\t%s\n", p2.nationality, 
				p2.name, p2.age, p2.gender);
	}
}
