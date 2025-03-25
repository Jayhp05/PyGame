package com.javastudy.ch04.overloading;

// 덧셈 계산기의 생성자와 메서드 오버로딩
public class CalculatorTest {

	public static void main(String[] args) {
		
		// 생성자 오버로딩이 되어 있기 때문에 두 가지 방법으로 객체를 생성할 수 있다.
		Calculator cal1 = new Calculator();
		Calculator cal2 = new Calculator(100, 200);
		
		System.out.println("cal2.add() 결과 : " + cal2.add());
		System.out.println("add() 결과 : " + cal1.add());
		System.out.println("add(5, 10) 결과 : " + cal1.add(5, 10));
		System.out.println("add(5, 10, 15) 결과 : " + cal1.add(5, 10, 15));
		System.out.println("add(10.4, 1.7) 결과 : " + cal1.add(10.4, 1.7));
		System.out.println("add(5.7, 1.3, 3.5) 결과 : " + cal1.add(5.7, 1.3, 3.5));
		
		/* Calculator 클래스에 add() 메서드의 매개변수가 2개와 3개짜리가 이미 선언되어
		 * 있기 때문에 가변 인수를 가진 add(int... nums) 메서드가 호출되게 하려면
		 * 이 메서드를 호출할 때 1개 또는 4개 이상의 인수를 지정하여 호출하면 된다.
		 **/  
		System.out.println("add(1, 2, 3...) 결과 : " 
				+ cal1.add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));		
	}
}
