package com.javastudy.ch02.operator;

// 조건 연산자(삼 항 연산자) 사용하기
public class Operator05 {
	
	public static void main(String[] args) {
		
		/* 조건 연산자는 연상 대상이 되는 피연산자가 3개라 삼 항 연산자라고도 한다.
		 * 조건식 ? 조건식이 true일 때 실행 : 조건식이 false일 때 실행
		 **/
		int x = 3;		
		System.out.println("x는 : " + (x % 2 == 1 ? "홀수" : "짝수"));
		System.out.println();
		
		/* 삼 항 연산자는 아래와 같이 중첩하여 연속적으로 사용할 수 있다.
		 * x의 값에 따라서 조건식이 참이면 "양수", 거짓이면 다시 한 번 조건식을
		 * 사용해 x의 값을 비교하여 x가 음수면 "음수"가 거짓이면 "0"이 출력된다.
		 **/
		x = -3;		
		System.out.println("x는 : " + (x > 0 ?  "양수" : x < 0 ? "음수" : "0"));
	}
}
