package com.javastudy.ch03.conditional;

import java.util.Scanner;

// 키보드로 입력받은 값이 5의 배수인지 판단하기
public class If02 {
	
	public static void main(String[] args) {
		
		// Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		System.out.print("5의 배수를 입력해 주세요 : ");
		
		// 키보드로 입력된 값을 정수로 읽어온다. 
		int input = sc.nextInt();
		
		// 입력된 값이 0이 아니고 5로 나누어 나머지가 0 이면 5의 배수		
		if(input != 0 && input % 5 == 0) {
			System.out.printf("입력한 수 %d는(은) 5배수 입니다.", input);
			
		} else {			
			System.out.printf("입력한 수 %d는(은) 5의 배수가 아닙니다.", input);
		}
	}
}
