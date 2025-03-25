package com.javastudy.ch02.operator;

// 정수와 실수를 0으로 나눌 때의 결과
public class Operator07 {
	
	public static void main(String[] args) {
		
		int x = 376;
		float y = 123.456f;		
		
		// 정수를 0으로 나누면 컴파일은 가능하나 실행시 ArithmeticException 발생
		try {
			System.out.println("x / 0 = " + x / 0 + ", " + "x % 0 = " + x % 0);	
			
		} catch(ArithmeticException e) {
			System.out.println("정수를 0으로 나눌 수 없습니다.");
		}
		
		// 실수를 0.0으로 나누면 Infinity(무한수)의 결과를 얻는다.
		System.out.println("y / 0 = " + y / 0 + ", " + "y % 0 = " + y % 0);		
		
		// 0을 0.0으로 나누면 NaN(Not a Number - 숫자 아님)의 결과를 얻는다. 
		System.out.println("0 / 0.0 = " + 0 / 0.0 + "0 % 0.0 = " + 0 % 0.0);			
	}
}
