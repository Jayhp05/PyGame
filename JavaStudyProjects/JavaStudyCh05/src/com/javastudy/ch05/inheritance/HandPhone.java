package com.javastudy.ch05.inheritance;

// 메소드 오버라이딩
public class HandPhone extends Phone {	

	protected boolean isEnabled;	
	
	public HandPhone(String name, boolean isEnabled) {		

		/* HandPhone 클래스가 상속받은 Phone 클래스에는 기본 생성자가 없으므로 
		 * Phone 클래스에 정의된 생성자를 아래와 같이 명시적으로 호출해야 한다. 
		 * 그렇지 않으면 컴파일러에 의해서 부모의 기본 생성자를 호출하는 super()
		 * 코드가 자동으로 추가되기 때문에 부모 클래스인 Phone 클래스에 존재하는
		 * 생성자를 아래와 같이 명시적으로 호출해야 컴파일 오류가 발생하지 않는다.
		 * 이렇게 부모 클래스의 생성자 호출은 현재 클래스와 상속 관계에 있는 모든
		 * 부모 클래스의 생성자가 호출될 수 있도록 자바의 최상위 조상인 Object
		 * 클래스의 생성자가 호출될 때 까지 거슬러 올라간다.
		 **/		
		super(name);		
		this.isEnabled = isEnabled;
		System.out.println("HandPhone(name, isEnabled) 생성자 호출됨");
	}
	
	/* Phone 클래스로부터 상속받은 sendPhone() 메서드를 자식인 HandPhone 클래스에서
	 * 수정하고 있다. 이렇게 부모로부터 상속 받은 부모의 인스턴스 메서드를 자식 클래스에서 
	 * 수정하여 다시 정의하는 것을 메서드 오버라이딩(Method Overriding) 이라고 한다.
	 * 
	 * 부모로부터 상속받은 메서드 이름과 동일하고 메서드의 반환타입과 매개변수가 동일해야
	 * 메서드 오버라이딩이 성립된다. 오버라이딩은 부모로부터 물려받은 메서드를 자식 대에서
	 * 필요한 기능을 추가 하거나 수정하는 것을 의미하며 이는 부모로부터 상속 받은 메서드를
	 * 자식이 필요에 의해서 메서드의 기능을 다시 정의하는 것이므로 메서드 재정의라고도 한다.
	 **/
	@Override
	public void sendPhone() {
		System.out.println("HandPhone.sendPhone() 호출됨");
		
		if(! isEnabled) {
			System.out.println("기지국 연결을 확인 하세요");
			return;			
		}
			
		/* 부모 참조 변수인 super를 사용해 부모 인스턴스의 sendPhone()
		 * 메서드를 호출하고 있다. 이렇게 자식 클래스에서 자신의 인스턴스 멤버
		 * (인스턴스 멤버 변수, 인스턴스 멤버 메서드)와 동일한 이름을 가진 부모
		 * 클래스의 인스턴스 멤버에 접근하기 위해서 부모의 인스턴스를 참조하는
		 * 부모 참조 변수인 super를 사용해 부모의 인스턴스 멤버에 접근할 수 있다.
		 * 모든 인스턴스 메서드에서 자기 자신의 인스턴스를 참조하는 자기 참조
		 * 변수 this와 부모의 인스턴스를 참조하는 부모 참조 변수 super를
		 * 사용할 수 있다. this와 super는 인스턴스와 관련된 변수 이므로
		 * static 메소드 안에서는 사용할 수 없다.
		 **/			 
		super.sendPhone();
	}	
	
	@Override
	public void receivePhone() {
		System.out.println("HandPhone.receivePhone() 호출됨");				
		super.receivePhone();		
	}
	
	public void game() {		
		System.out.println("게임을 시작 합니다.");
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
}
