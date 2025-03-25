package com.javastudy.ch03.forwhile;

// for 문을 이용한 1 ~ 100까지 짝수와 홀수의 합 구하기 
public class For03 {
	public static void main(String[] args) {
			
		int oddSum = 0;
		int evenSum = 0;
		
		// 반복문을 돌면서 짝수의 합과 홀수의 합을 구한다.
		for(int i = 1; i <= 100; i++) {
			
			// 현재 i를 2로 나누어 나머지가 0이면 짝수
			if(i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		
		System.out.println("1 ~ 100까지 짝수의 합 : " + evenSum);
		System.out.println("1 ~ 100까지 홀수의 합 : " + oddSum);
	}
}
