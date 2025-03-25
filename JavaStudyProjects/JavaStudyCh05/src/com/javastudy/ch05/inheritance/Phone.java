package com.javastudy.ch05.inheritance;

// 메소드 오버라이딩
public class Phone {

	protected String name;
		
	public Phone(String name) {	
		
		/* 현재 이 클래스는 다른 클래스를 명시적으로 상속받지 않기 때문에 컴파일러에
		 * 의해서 extends Object가 클래스 선언부에 추가되어 Object 클래스를 직접
		 * 상속받게 된다. 또한 이 생성자의 첫 줄에 부모 클래스의 기본 생성자를 호출하는
		 * super() 코드가 자동으로 추가되어 Object 클래스의 기본 생성자가 호출된다. 
		 * 이렇게 부모 클래스의 생성자 호출은 현재 클래스와 상속 관계에 있는 모든 부모 
		 * 클래스의 생성자가 호출될 수 있도록 자바의 최상위 조상인 Object 클래스의
		 * 생성자가 호출될 때 까지 거슬러 올라간다.  
		 **/
		this.name = name;	
		System.out.println("Phone(name) 생성자 호출됨");
	}
	
	public void sendPhone() {
		System.out.println("Phone.sendPhone() - 전화를 건다.");
	}
	
	public void receivePhone() {
		System.out.println("Phone.receivePhone() - 전화를 받는다.");
	}
}
