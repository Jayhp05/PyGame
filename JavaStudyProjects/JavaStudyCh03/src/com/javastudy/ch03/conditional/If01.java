package com.javastudy.ch03.conditional;

// if 문과 나머지 연산자를 이용한 배수와 홀, 짝수 인지 판단하기
public class If01 {
	
	public static void main(String[] args) {
		
		int x = 21;
		int y = 7;
		int score = 79;
		
		/* if 문은 조건식의 결과가 boolean(true 또는 false) 값만 가능하다.
		 * 어떤 수를 특정수로 나누어 나머지가 0이면 어떤 수는 특정수의 배수이다.
		 **/
		System.out.println("배수 구하기");
		if(x % y == 0) {
			System.out.printf("%d은(는) %d의 배수 입니다.\n", x, y);
		} 
		
		// 특정 수를 2로 나누어 나머지가 0이면 짝수 그렇지 않으면 홀수이다.
		System.out.println("홀/짝수 구하기");		
		if(x % 2 != 0) {
			System.out.printf("%d은(는) 홀수 입니다.\n", x);
			
		} else {
			System.out.printf("%d은(는) 짝수 입니다.\n", x);
		}
		
		// 점수가 80점 이상과 미만 일 때 각각 다른 메시지를 출력하기
		if(score >= 80) {
			System.out.println("축하 합니다. 합격 했습니다.");
			
		} else {
			System.out.println("아쉽네요 이번에는 불합격 입니다.");
		}
	}
}
