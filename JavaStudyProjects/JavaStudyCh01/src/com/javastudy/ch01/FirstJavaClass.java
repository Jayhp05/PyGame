package com.javastudy.ch01;

/* 첫 번째 자바 클래스
 * 자바의 모든 실행 코드는 클래스 안(클래스의 { } 블록 안에)에 작성해야 한다.
 **/
public class FirstJavaClass {
	
	public static void main(String[] args) {
		
		/* 자바에서 변수를 만들기 위해서는 그 변수에 담을 데이터 타입을 먼저
		 * 변수 앞에 지정하고 변수를 만들어야 하는데 이를 변수의 선언이라고 한다. 
		 * 정수형 변수 x, y를 선언하고 30과 50의 정수를 대입(저장)하고 있다.
		 **/
		int x = 30;
		int y = 50;
		
		// 문자형 변수 ch를 선언하고 A를 대입하고 있다.
		char ch = 'A';
		
		// 문자열형 변수 hello를 선언하고 Hello Java를 대입하고 있다.
		String hello = "Hello Java";
		
		/* ch 변수에 저장된 데이터를 콘솔(화면)에 출력
		 * System.out.println() 메서드는 인수로 지정한 데이터를 콘솔에 출력하는 메서드 이다.
		 **/ 
		System.out.println(ch);
		
		// hello 변수의 내용을 콘솔로 출력하기
		System.out.println(hello);	
		
		// 정수형 변수에 저장된 x의 값과 y의 값을 더해서 콘솔에 출력하고 있다.
		System.out.println("30 + 50 = " + (x + y));
	}
}
