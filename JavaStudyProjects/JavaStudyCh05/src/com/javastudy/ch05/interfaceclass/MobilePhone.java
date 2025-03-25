package com.javastudy.ch05.interfaceclass;

// 인터페이스를 이용한 다중상속 구현
/* 자바는 원칙적으로 클래스간의 다중 상속은 지원하지 않지만 인터페이스를 통해서
 * 다중 상속을 지원한다. 인터페이스와 인터페이스 간의 상속은 extends 키워드를 사용해 
 * "인터페이스 extends 인터페이스1, 인터페이스2 ..." 와 같이 하나 이상의 인터페이스를
 * 지정할 수 있도록 하여 인터페이스 간의 다중 상속을 정의할 수 있도록 지원하고 있다.
 **/
public interface MobilePhone extends Phone {

	// 문자 전송 기능을 추상 메소드로 정의
	public abstract void sendSMS();
	
	/* 문자 받는 기능을 추상 메소드로 정의
	 * 인터페이스는 추상 메서드와 상수로만 구성되기 때문에 예약어 없이 아래와 같이
	 * 메서드를 선언해도 컴파일러에 의해 public abstract가 적용되어 추상 메서드가 된다.
	 * 인터페이스의 모든 메서드는 public abstract이어야 하므로 이 부분은 생략할 수 있다.
	 **/ 
	void receiveSMS();
	
	/* 기지국을 다시 연결해주는 static 메소드
	 * Java8부터는 인터페이스에 default 메소드와 static 메서드를 정의해 사용할 수 있다.
	 * 인터페이스의 모든 멤버는 모두 public 접근 지정자를 가지게 된다.
	 **/
	static boolean resetEnabled() {
		return true;
	}
}
