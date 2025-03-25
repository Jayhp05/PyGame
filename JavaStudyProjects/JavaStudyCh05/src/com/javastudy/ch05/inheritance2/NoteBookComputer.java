package com.javastudy.ch05.inheritance2;

import com.javastudy.ch05.inheritance.Computer;

// 접근 제어자와 super() 생성자
/* 자바에서 다른 클래스를 상속받기 위해서는 아래와 같이 클래스 이름 뒤에 extends 
 * 예약어를 이용해 상속받을 클래스를 지정하면 된다. 아래와 같이 Computer 클래스를
 * 상속받게 되면 Computer 클래스가 정의한 모든 속성(필드)과 모든 기능(메서드)을 
 * 상속받아 자기 자신의 것과 마찬가지로 자유롭게 사용할 수 있게 된다.
 **/
public class NoteBookComputer extends Computer {
	
	/* 자식 클래스에서 부모 클래스의 멤버 변수 이름과 동일한 이름의 변수를 선언할 수 있다. 
	 * 변수의 타입이 달라도 하나의 클래스에는 동일한 이름을 가진 멤버 변수를 
	 * 선언할 수 없다. 하지만 자식 클래스에서 부모의 멤버 변수와 동일한 이름을
	 * 가진 멤버 변수를 중복해서 선언할 수 있다. 
	 **/ 
	protected String spec;
	
	public NoteBookComputer(String name, int price, String spec) {
		
		/* Object 클래스를 제외하고 자바의 모든 클래스의 생성자는 첫 줄에 자신의
		 * 다른 생성자 또는 부모의 생성자를 명시적으로 호출해야 한다. 그렇지 않으면
		 * 컴파일러에 의해서 생성자의 첫 줄에 부모 클래스의 기본 생성자를 호출하는
		 * super() 코드가 자동으로 추가된다. 이렇게 묵시적인 부모 클래스의 기본
		 * 생성자 호출은 자바의 최상위 조상인 Object 클래스까지 거슬러 올라간다.
		 * super()는 자식의 생성자 안에서만 호출 할 수 있으며 항상 생성자의 첫 줄에
		 * 작성되어야 한다. 이 클래스는 Computer 클래스를 상속 받았으므로 아래와
		 * 같이 super(name, price) 생성자를 호출하면 부모인 Computer 클래스의
		 * super(name, price) 생성자가 호출된다.
		 * 만약 아래에서 명시적으로 super(name, price) 생성자를 호출하지 않는다면
		 * 컴파일러에 의해서 부모 클래스의 기본 생성자를 호출하는 super() 코드가 
		 * 자동으로 추가되기 때문에 컴파일 오류가 발생한다. 그 이유는 부모 클래스인 
		 * Computer 클래스에는 기본 생성자가 정의되어 있지 않기 때문이다. 
		 * 그러므로 아래와 같이 Computer 클래스에 존재하는 생성자를 호출해야 한다.
		 **/
		super(name, price);
		this.spec = spec;
		System.out.println("NoteBookComputer(name, price, spec) 생성자 호출됨");
	}		
	
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public String toString() {
		System.out.println("NoteBookComputer.toString 메소드 호출됨");
		return name + "\t" + spec + "\t" + price;
	}
	
	public void info() {
		
		/* 자식 클래스에서 자신의 인스턴스 멤버 변수와 동일한 이름을 가진 부모 클래스의 
		 * 인스턴스 멤버 변수에 접근하기 위해서 부모의 인스턴스를 참조하는 부모 참조 변수인
		 * super를 사용해 부모의 인스턴스 변수에 접근할 수 있다. 모든 인스턴스 메서드에서
		 * 자기 자신의 인스턴스를 참조하는 자기 참조 변수 this와 부모의 인스턴스를 참조하는
		 * 부모 참조 변수 super를 사용할 수 있다. this와 super는 인스턴스와 관련된 변수
		 * 이므로 static 메소드에서는 사용할 수 없다.
		 **/ 
		System.out.println("Super Info : " + super.spec + ", Sub Info : " + spec);
	}
}
