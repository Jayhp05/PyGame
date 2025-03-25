package com.javastudy.ch05.interfaceclass;

// 인터페이스를 이용한 다중상속 구현
/* 클래스에서 인터페이스를 상속받기 위해서는 implements 키워드를 사용한다.
 *
 * 자바는 원칙적으로 클래스간의 다중 상속은 지원하지 않지만 인터페이스를 통해서
 * 다중 상속을 지원한다. 클래스와 인터페이스 간의 상속은 implements 키워드를 사용해 
 * "클래스 extends 클래스1 implements 인터페이스1, 인터페이스2 ..." 와 같이 상속받을
 * 클래스와 하나 이상의 인터페이스를 지정하여 다중 상속을 정의할 수 있도록 지원하고 있다.
 **/
public class MyHomePhone implements Phone {
	
	protected String name;
	
	public MyHomePhone(String name) {		
		this.name = name;
	}
	
	/* 인터페이스로부터 상속 받은 추상 메소드 구현
	 * MyHomePhone 클래스는 Phone 인터페이스에게 상속받은
	 * 추상 메서드를 자신에 맞게 모두 구현해야 비로소 완성 클래스가 된다.
	 *   
	 * 인터페이스를 상속받은 클래스가 인터페이스가 가지고 있는 추상 메서드를
	 * 모두 구현하지 않으면 이 클래스는 미완성 클래스로 추상 클래스가 된다.
	 * 인터페이스로부터 상속받은 추상 메서드를 자식 클래스에서 모두 구현해야 비로소
	 * 인스턴스를 생성할 수 있기 때문에 인터페이스는 상속을 통해서 완성될 수 있다.
	 **/
	@Override
	public void sendPhone() {	
		System.out.println(this.name + " 전화 걸기...");			
	}
	
	@Override
	public void receivePhone() {
		System.out.println(this.name + " 전화 받기...");				
	}
}
