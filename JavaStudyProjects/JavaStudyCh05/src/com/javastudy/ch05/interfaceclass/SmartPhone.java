package com.javastudy.ch05.interfaceclass;

// 인터페이스를 이용한 다중상속 구현
/* 클래스에서 아래와 같이 클래스와 인터페이스를 동시에 상속해 다중 상속을 구현할 수 있다.
 * 
 * 자바는 원칙적으로 클래스간의 다중 상속은 지원하지 않지만 인터페이스를 통해서
 * 다중 상속을 지원한다. 추상 클래스와 클래스, 클래스와 클래스 그리고 인터페이스와
 * 인터페이스 간의 상속은 extends 예약어를 사용하고 인터페이스와 추상 클래스, 
 * 인터페이스와 클래스 간의 상속은 implements 예약어를 사용해 상속을 정의한다. 
 * 
 * 어떤 클래스에서 다중 상속을 받으려면 다음과 같이 클래스와 하나 이상의 인터페이스를
 * 지정하여 다중 상속을 정의할 수 있도록 지원하고 있다.
 *
 * "클래스 extends 클래스1 implements 인터페이스1, 인터페이스2 ..."
 *
 * SmartPhone 클래스는 MyHomePhone 클래스를 상속받고 MobilePhone 인터페이스를
 * 구현하여 다중 상속을 하고 있다. 이렇게 상속이 이루어지면 SmartPhone 클래스는
 * MyHomePhone 타입인 동시에 MobilePhone 타입도 되고 MobilePhone 인터페이스가
 * 상속한 Phone 타입도 되므로 이 3가지 클래스나 인터페이스 타입으로 업 캐스팅 할 수 있다. 
 **/
public class SmartPhone extends MyHomePhone implements MobilePhone {	

	protected boolean isEnabled;
	
	public SmartPhone(String name, boolean isEnabled) {
		
		/* SmartPhone 클래스가 상속 받은 MyHomePhone 클래스에는 기본 생성자가 
		 * 정의되어 있지 않으므로 MyHomePhone 클래스에 정의된 생성자를 아래와 같이
		 * 명시적으로 호출해야 한다. 그렇지 않으면 컴파일러에 의해서 기본 생성자를 호출하는
		 * this() 코드가 첫 줄에 추가되기 때문에 컴파일 오류가 발생한다.
		 **/
		super(name);		
		this.isEnabled = isEnabled;
		
		// 생성자 안에서 상위 인터페이스에 정의된 default 메소드 호출
		this.power(name);
	}
	
	@Override
	public void sendPhone() {		
		if(! isEnabled) {			
			// 상위 인터페이스에 정의된 static 메서드 호출
			MobilePhone.resetEnabled();
			System.out.println(this.name + " 기지국 다시 연결함");
		}			
		super.sendPhone();				
	}
	
	@Override
	public void receivePhone() {
		super.receivePhone();				
	}	
	
	/* 인터페이스로부터 상속 받은 추상 메소드 구현
	 * SmartPhone 클래스는 MobilePhone 인터페이스에게 상속받은
	 * 추상 메서드를 자신에 맞게 모두 구현해야 비로소 완성 클래스가 된다.
	 *   
	 * 인터페이스를 상속받은 클래스가 인터페이스가 가지고 있는 추상 메서드를
	 * 모두 구현하지 않으면 이 클래스는 미완성 클래스로 추상 클래스가 된다.
	 * 인터페이스로부터 상속받은 추상 메서드를 자식 클래스에서 모두 구현해야 비로소
	 * 인스턴스를 생성할 수 있기 때문에 인터페이스는 상속을 통해서 완성될 수 있다.
	 **/
	@Override
	public void sendSMS() {	
		System.out.println(this.name + " 문자 메시지 보내기...");
	}
	
	@Override
	public void receiveSMS() {		
		System.out.println(this.name + " 문자 메시지 받기...");		
	}
	
	public void webSurfing() {
		System.out.println(this.name + " 브라우저를 화면에 띄운다.");
	}	
}
