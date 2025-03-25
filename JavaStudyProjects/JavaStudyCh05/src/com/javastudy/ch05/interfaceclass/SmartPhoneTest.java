package com.javastudy.ch05.interfaceclass;

// 인터페이스를 이용한 다중상속 구현
public class SmartPhoneTest {
	
	public static void main(String[] args) {		
		
		SmartPhone sp = new SmartPhone("스마트 폰", true);
		
		sp.sendPhone();
		sp.sendSMS();	
		sp.webSurfing();
		
		/* SmartPhone 클래스는 MyHomePhone 클래스를 상속하고, MobilePhone
		 * 인터페이스를 구현하여 다중 상속을 구현하였기 때문에 SmartPhone 클래스는
		 * MyHomePhone 타입인 동시에 MobilePhone 타입도 되고 MobilePhone
		 * 인터페이스가 상속한 Phone 타입도 되므로 아래와 같이 위의 3가지 타입으로
		 * SmartPhone 클래스의 인스턴스를 참조할 수 있다. 이렇게 하나의 객체가
		 * 여러 개의 타입을 가질 수 있는 성질을 다형성(Polymorphism)이라고 한다.
		 * 
		 * 다형성은 다양한 형식과 기능을 가진다는 의미로 해석될 수 있으며 객체지향에서
		 * 다형성을 구현하는 방법은 상속과 추상화를 통해 다양하게 구현될 수 있다.
		 * 상속과 추상화를 이용해 오버라이딩 기법과 업캐스팅을 활용하면 자식의 객체를
		 * 참조하는 부모 타입의 참조 변수를 통해서 자식의 오버라이딩된 메서드를 호출할
		 * 수 있게 된다. 이는 부모 타입으로 업캐스팅된 참조 변수를 통해서 실제 자식 
		 * 클래스에서 재정의한 메서드를 호출할 수 있게 되므로 하나의 부모타입의 참조
		 * 변수로 각각의 기능을 제공하는 여러 자식 클래스에서 재정의한 메서드를 동일한
		 * 방식으로 호출할 수 있다는 장점이 있다.  
		 **/ 
		Phone p1 = new SmartPhone("스마트 폰1", true);		
		MobilePhone p2 = new SmartPhone("스마트 폰2", true);
		MyHomePhone p3 = new SmartPhone("스마트 폰3", true);		
	}
}
