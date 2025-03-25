package com.javastudy.ch03.forwhile;

// for 반복문을 이용해 1 ~ 100까지의 합 구하기
public class For01 {
	
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		
		System.out.println("1 ~ 100까지 합 : " + sum);
	}
}
