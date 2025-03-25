package com.javastudy.ch05.inheritance;

// 접근 제어자와 super() 생성자
/* 자바에서 다른 클래스를 상속받기 위해서는 클래스 이름 뒤에 extends 예약어를 
 * 사용해 상속받을 클래스를 지정하면 된다. 아래 Computer 클래스는 별도로 상속받는
 * 클래스를 지정하지 않았기 때문에 컴파일러가 클래스 이름 뒤에 extends Object를
 * 붙여서 자바에서 최상위 조상인 Object 클래스를 자동으로 상속받게 만들어 준다.   
 **/
public class Computer {
	
	/* 접근 제어자(Access Modifier, 접근 지정자, 한정자라고도 한다.)는 클래스 또는
	 * 생성자와 메소드 그리고 멤버 변수에 사용할 수 있으며 4가지 종류의 제어자가 있다.
	 * 
	 * private : 같은 클래스 내에서만 접근이 가능하다.
	 * default : 같은 패키지 내에서만 접근이 가능하다. 
	 * protected : 같은 패키지와 다른 패키지의 상속관계에서 접근이 가능하다.
	 * public : 접근 제한이 없어 어디서든 접근이 가능하다.
	 *  
	 * default 접근 제어자는 따로 접근 제어자를 붙이지 않는다. 다시 말해 접근 제어자가
	 * 붙지 않은 변수, 메서드, 클래스는 default 접근 제어자가 지정된 것이다.
	 * 단, 클래스는 default와 public 접근 제어자만 지정할 수 있다.  
	 **/
	protected String name;
	protected int price;
	protected String spec;
	
	public Computer(String name, int price) {		
		
		/* Object 클래스를 제외하고 자바의 모든 클래스의 생성자는 첫 줄에 자신의
		 * 다른 생성자 또는 부모의 생성자를 명시적으로 호출해야 한다. 그렇지 않으면
		 * 컴파일러에 의해서 생성자의 첫 줄에 부모 클래스의 기본 생성자를 호출하는
		 * super() 코드가 자동으로 추가된다. 이렇게 묵시적인 부모 클래스의 기본
		 * 생성자 호출은 자바의 최상위 조상인 Object 클래스까지 거슬러 올라간다.
		 * super()는 자식의 생성자 안에서만 호출 할 수 있으며 항상 생성자의 첫 줄에
		 * 작성되어야 한다. 이 클래스는 컴파일러에 의해서 자동으로 Object 클래스를
		 * 상속 받았기 때문에 super()는 Object 클래스의 기본 생성자를 호출한다.
		 * 만약 부모 클래스에 기본 생성자가 존재하지 않으면 컴파일 오류가 발생하므로
		 * 부모 클래스에 존재하는 생성자가 호출될 수 있도록 코드를 작성해야 한다. 
		 **/		
		this.name = name;
		this.price = price;
		System.out.println("Computer(name, price) 생성자 호출됨");
	}
	
	public Computer(String name, int price, String spec) {
		this.name = name;
		this.price = price;
		this.spec = spec;
		System.out.println("Computer(name, price, spec) 생성자 호출됨");
	}

	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public String toString() {
		System.out.println("Computer.toString 메소드 호출됨");
		return name + "\t" + spec + "\t" + price;
	}
}
