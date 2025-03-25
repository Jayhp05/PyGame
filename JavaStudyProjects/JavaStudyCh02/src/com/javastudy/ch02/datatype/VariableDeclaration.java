package com.javastudy.ch02.datatype;

//  변수 선언과 주석문 사용하기
public class VariableDeclaration {
	public static void main(String[] args) {		

		// 여기는 자바의 한 줄 주석으로 주석은 프로그램으로 해석되지 않는다.
		// 변수만 선언하는 경우
		int a, b;
		float f;		
		
		/* 여기는 자바의 여러 줄 주석
		 * 아래는 변수 선언과 초기화를 동시에 하는 경우이다. 
		 * char 형은 자바 기본형 8개 중 하나로 한 문자를 저장할 수 있는 데이터 형이다.
		 **/
		char ch = '한';		
		
		// 변수에 처음 데이터를 할당(저장)하는 것을 변수의 초기화라 한다.
		a = 10;
		b = 100;
		f = 10.532F;		
		
		// 각 변수에 저장된 데이터를 콘솔로 출력하고 있다.
		System.out.println(a + " : " + b);
		System.out.println(f);		
		System.out.println(ch);
		
		/* 위에서 a에 10을 할당한 후 아래와 같이 변수 b를 할당하면 기존 a에
		 * 있던 값 10은 지워지고 최종적으로 할당한 b의 값 100이 저장된다. 
		 * 이렇게 변수에는 최종적으로 할당된 값만 저장된다.
		 **/
		a = b;
		System.out.println("a : " + a);
		
		// 변수 b가 보유한 값 100에 10을 더하여 110이 최종적으로 b에 저장된다.
		b = b + 10;
		System.out.println("b : " + b);
	}
}
