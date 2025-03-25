package com.javastudy.ch03.forwhile;

// for문을 이용해 구구단 7단 출력하기 
public class For02 {
	
	public static void main(String[] args) {
		
		int x = 7;
		
		for(int i = 1; i < 10; i++) {			
			System.out.printf("%d x %d = %d\n", x, i, x * i);
		}
	}
}
