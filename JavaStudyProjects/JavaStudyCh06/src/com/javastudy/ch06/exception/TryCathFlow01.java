package com.javastudy.ch06.exception;

// 정상적인 프로그램 흐름에서 try-catch 문의 실행 흐름
public class TryCathFlow01 {

	public static void main(String[] args) {
		
		System.out.println("1번");
		
		try {			
			System.out.println("2번");
			System.out.println("3번");
			
		} catch(Exception e) {			
			// try 블럭에서 Exception이 발생하지 않아 4번이 출력되지 않음			
			System.out.println("4번");
			
		} finally { // finally 블럭은 필요하지 않으면 생략할 수 있다.			
			// 예외가 발생되거나 정상 흐름 모두 항상 finally 블럭이 실행된다.
			System.out.println("5번");
		}		
		System.out.println("6번");
	}
}
