package com.javastudy.ch07.mathclass;

// Math 클래스의 메소드 1
// abs(), sqrt(), pow(), log(), random()
public class MathClass01 {

	public static void main(String[] args) {
		
		/* Math 클래스는 수학과 관련된 기능을 제공하는 클래스로 절대값, 난수 발생,
		 * 삼각함수, 제곱근, 거듭제곱, 로그, 오일러 상수 등을 구해주는 다양한 메서드를
		 * 제공하고 있다. Math 클래스는 외부에서 인스턴스를 생성할 수 없도록 기본 
		 * 생성자를 private으로 정의하고 있기 때문에 클래스 이름으로 바로 접근할 수
		 * 있도록 모든 메서드를 static으로 정의하고 있다.
		 **/		
		// 절대값 구하기
		System.out.println("-7의 절댓값 : " + Math.abs(-7));
		
		// 제곱근과 거듭제곱 구하기
		System.out.println("2의 제곱근 : " + Math.sqrt(2));
		System.out.println("2의 제곱 : " + Math.pow(2, 2));
		
		// 로그 구하기		
		System.out.println("log(10) : " + Math.log(10));
		
		/* 1 ~ 10까지 난수 구하기
		 * random() 메서드는 0 ~ 1사이의 난수를 double 형으로 
		 * 구해주는 메서드로 0은 포함되고 1은 포함되지 않는다.
		 **/
		int num = (int) (Math.random() * 10) + 1;
		System.out.println(num);
	}
}
