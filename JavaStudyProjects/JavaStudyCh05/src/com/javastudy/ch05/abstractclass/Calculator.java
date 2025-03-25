package com.javastudy.ch05.abstractclass;

import java.awt.event.MouseAdapter;

// 추상 클래스와 오버라이딩
/* 추상 클래스(Abstract Class)란 미완성 클래스를 의미하며 추상 클래스 내부에 미완성
 * 메서드(추상 메서드)를 가지고 있다. 추상 메서드는 메서드 선언부만 있고 구현부가 없는
 * 메서드를 말한다. 추상 클래스는 아래와 같이 클래스 선언부에 abstract 예약어를 사용해
 * 정의할 수 있으며 추상 클래스로 정의되면 미완성 클래스이므로 자체적으로 객체를 생성할
 * 수 없고 상속을 통해서 완성될 수 있다. 또한 추상 클래스는 미완성 메서드인 추상 메서드를
 * 가지고 있지 않아도 abstract 예약어를 사용해 추상 클래스로 선언할 수 있으며 이때도
 * 미완성 클래스가 되므로 자체적으로 객체를 생성할 수 없고 상속을 통해서 완성될 수 있다.
 **/
public abstract class Calculator {	
	
	// 추상 클래스는 인스턴스 맴버 변수를 가질 수 있다.
	int x;
	int y;
	
	// 추상 클래스는 생성자를 가질 수 있다.
	public Calculator() { 
		this(10, 20);
	}	

	public Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 추상 클래스는 완성된 메서드를 가질 수 있다.
	public int add(int x, int y) {
		return x + y;
	}
	
	/* 추상 메서드는 아래와 같이 메서드의 특징을 정의하는 선언부만 있고
	 * 메서드의 기능을 구체적으로 작성하는 구현부(몸통)가 없는 메서드 이다.
	 **/
	public abstract double add(double x, double y);
}

/* 마우스 이벤트를 처리하는 MouseAdapter 클래스는 추상 클래스로 선어되어 있다.
 * 이 클래스는 추상 메서드를 가지고 있지 않지만 추상 클래스로 선언되어 있다.
 * 이 클래스는 MouseListener, MouseWheelListener, MouseMotionListener 3개의
 * 인터페이스에 정의된 추상 메서드를 모두 빈 구현으로 구현하였으므로 이 추상 클래스를
 * 상속받아 필요한 메서드만 오버라이딩 하여 사용할 수 있도록 설계되어 있다.
 **/ 
class MyMouseAdapter extends MouseAdapter {}
