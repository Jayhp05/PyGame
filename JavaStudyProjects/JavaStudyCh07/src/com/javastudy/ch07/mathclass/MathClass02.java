package com.javastudy.ch07.mathclass;


// Math 클래스의 메소드 2
// round(), ceil(), floor(), min(), max()
public class MathClass02 {

	public static void main(String[] args) {

		// 소수 점 반올림 하기
		System.out.println("10.24567 소수 첫째자리 반올림: " + Math.round(10.24567));
		System.out.println("10.24567 소수 셋째자리 반올림 : " 
					+ Math.round(10.24567 * 1000) / 1000.0f);
		
		// 지정한 인수보다 크거나 같은 가장 작은 정수 구하기
		System.out.println("10.2 보다 크거나 같은 가장 작은 정수 : " + Math.ceil(10.2));
		System.out.println("-10.2 보다 크거나 같은 가장 작은 정수 : " + Math.ceil(-10.2));
		
		// 지정한 인수보다 작거나 같은 가장 큰 정수 구하기 
		System.out.println("10.2 보다 작거나 같은 가장 큰 정수 : " + Math.floor(10.2));
		System.out.println("-10.2 보다 작거나 같은 가장 큰 정수 : " + Math.floor(-10.2));
		
		// 인수로 지정한 두 수 중에서 큰 수와 작은 수 구하기
		System.out.println("10과 20중 큰 수 : " + Math.max(10, 20));
		System.out.println("10.7과 10.3중 작은 수 : " + Math.min(10.7, 10.3));
	}
}
