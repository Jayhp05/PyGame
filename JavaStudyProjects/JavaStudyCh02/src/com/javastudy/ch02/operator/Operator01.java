package com.javastudy.ch02.operator;

// 나머지 연산자 사용하기
public class Operator01 {
	
	public static void main(String[] args) {
					
		// 정수형 나눗셈 연산과 나머지 연산의 결과는 정수형이 된다.
		int x = 10;
		int y = 3;	
		System.out.println("10 / 3의 몫 : " + x / y);
		System.out.println("10 / 3의 나머지 : " + x % y);
		System.out.println();

			
		// 실수형 나눗셈 연산과 나머지 연산의 결과는 실수형이 된다.
		float f1 = 10.0f;
		float f2 = 3.0f;	
		System.out.println("10.0 / 3.0의 몫 : " + f1 / f2);
		System.out.println("10.0 / 3.0의 나머지 : " + f1 % f2);		
		System.out.println();		
		
		// char형 나눗셈 연산과 나머지 연산의 결과는 int 형이 된다.
		char chA = 'A';
		char cha = 'a';
		System.out.println("a / A의 몫 : " + cha / chA);
		System.out.println("a / A의 나머지 : " + cha % chA);
	}
}
