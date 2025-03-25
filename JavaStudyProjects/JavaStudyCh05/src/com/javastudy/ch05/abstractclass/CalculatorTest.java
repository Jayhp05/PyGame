package com.javastudy.ch05.abstractclass;

// 추상 클래스와 오버라이딩
public class CalculatorTest {
	
	public static void main(String[] args) {
		
		// 추상 클래스는 직접 인스턴스를 생성 할 수 없다. - 주석을 풀면 에러가 발생한다.
		//Calculator cal = new Calculator();
		
		Calculator engCal1 = new EngineeringCalculator();
		EngineeringCalculator engCal2 = new EngineeringCalculator();
		
		// Calculator 클래스로부터 상속받은 add() 메소드가 호출된다.
		System.out.println("engCal1.add(int, int) : " + engCal1.add(30, 50));
		System.out.println("engCal2.add(int, int) : " + engCal2.add(50, 70));
		System.out.println();
		
		/* 아래의 engCal1.add(30.0, 50.0) 메서드 호출은 참조 변수의 타입이 부모인
		 * Calculator 타입이지만 실제 인스턴스가 EngineeringCalculator 타입이므로
		 * EngineeringCalculator 클래스에서 Override한 메서드가 실행된다. 
		 **/
		System.out.println("engCal1.add(double, double) : " + engCal1.add(30.0, 50.0));
		System.out.println("engCal2.add(double, double) : " + engCal2.add(50.0, 70.0));
	}
}
