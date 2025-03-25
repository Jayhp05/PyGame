package com.javastudy.ch02.datatype;

// 기본 타입의 자동 형 변환과 강제 형 변환
public class PrimitiveCasting01 {

	public static void main(String[] args) {
		
		byte b = 6;
		int i = 100;		
		float f = 6.0f;
		double d = 6.0;
		
		/* byte 타입과 int 타입의 연산은 연산하기 전에 두 변수의 타입을 맞추기 위해
		 * byte 타입의 변수 b의 값을 큰 쪽인 int 타입으로 자동으로 형 변환 한 후
		 * 두 변수 b와 i의 값을 연산하게 되며 그 결과 값 또한 int 형이 된다.
		 *  
		 **/
		System.out.println("i x b = " + i * b);
		System.out.println();
		
		/* 정수형과 실수형 연산은 정수형 변수를 자동으로 실수형 타입으로 형 변환
		 * 한 후 두 변수 i와 f의 값을 연산하게 되며 그 결과 값 또한 실수형이 된다.
		 **/					
		System.out.println("i / d = " + i / d);
		System.out.println();
		
		/* long 형의 크기는 8Byte 이고 float 형의 크기는 4Byte 이지만
		 * float 형이 수의 표현 범위가 넓기 때문에 float 형을 long 형의
		 * 변수에 담기 위해서는 강제 형 변환이 필요하다. 그 반대의 경우는 float 형이 
		 * long 형보다 수의 표현 범위가 넓기 때문에 자동 형 변환이 이루어진다.
		 * 기본형의 수의 표현 범위를 작은 것부터 큰 순으로 나열하면 아래와 같다.
		 * byte -> short/char -> int -> long -> float -> double 
		 **/
		long l = (long) f;
		f = l;
	}
}
