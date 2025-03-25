package com.javastudy.ch05.abstractclass;

// 추상 클래스와 오버라이딩
// 추상 클래스를 상속받을 때도 일반 클래스 상속과 마찬가지로 extends 예약어를 사용한다.
public class EngineeringCalculator extends Calculator {	

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	/* 추상 클래스로부터 상속 받은 추상 메소드 구현
	 * EngineeringCalculator 클래스는 Calculator 추상 클래스를 상속받아
	 * 상속받은 추상 메서드를 자신에 맞게 모두 구현해야 완성 클래스가 된다.
	 *  
	 * 추상 클래스를 상속받아 부모 클래스의 추상 메서드를 모두 구현하지 않으면
	 * 추상 클래스를 상속받은 클래스 또한 미완성 클래스인 추상 클래스가 된다.
	 * 자식 클래스에서 상속받은 추상 클래스의 메서드를 모두 구현해야 비로소
	 * 인스턴스를 생성할 수 있기 때문에 추상 클래스는 상속을 통해서 완성될 수 있다.
	 **/  
	@Override
	public double add(double x, double y) {		
		return x + y;
	}
}
