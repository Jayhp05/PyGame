package com.javastudy.ch02.operator;

// 비교 연산자와 논리 연산자 사용하기
public class Operator02 {
	
	public static void main(String[] args) {
		
		int x = 10;
		int y = 30;
		int z = 10;		
		
		// 피연산자에 저장된 값의 크기를 비교하는 연산자를 대소 비교 연산자라고 한다.
		System.out.println("10 > 30 : " + (x > y));		
		System.out.println("10 <= 30 : " + (x <= y));
		System.out.println();
		
		// 피연산자에 저장된 값이 같은지 다른지를 비교하는 연산자를 등가 비교 연산자라 한다.		
		System.out.println("10 == 10 : " + (x == z));
		System.out.println("10 != 10 : " + (x != z));
		System.out.println();

		/* 논리 연산자는 양쪽의 피연산자 모두가 boolean(true, flase) 값이어야 한다.
		 * &&(AND) 연산자는 양쪽의 값이 모두 true일 때 true를 반환 
		 **/
		System.out.println("10 > 30 && 30 > 10 : " + ((x > y) && (y > z)));
		
		// ||(OR) 연산자는 한 쪽의 값이 true 이거나 양쪽 모두 true일 때 true를 반환   
		System.out.println("10 < 30 || 30 > 10 : " + ((x < y) || (y > z)));
		System.out.println();
		
		// ^(Exclusive OR) 연산자는 양쪽의 값이 서로 다르면 true를 반환
		System.out.println("10 > 30 ^ 30 > 10 : " + ((x > y) ^ (y > z)));		
		System.out.println("10 < 30 ^ 30 > 10 : " + (x < y ^ y > z));
		System.out.println();
		
		// 논리 부정 연산자는 논리 값을 반전시킴 - boolean 형에만 사용할 수 있는 연산자
		boolean isChecked = false;
		System.out.println("!isChecked : " + !isChecked);
	}
}
