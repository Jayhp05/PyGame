package com.javastudy.ch06.exception;


// 예외 발생시  try-catch 문의 실행 흐름
public class TryCathFlow02 {

	public static void main(String[] args) {
		
		System.out.println("1번");
		
		try {			
			System.out.println("2번");
			
			// 강제로 ArithmeticException 발생			
			System.out.println(0 / 0);
			
			/* Exception이 발생하면 바로 catch 구문으로 이동
			 * 아래 3번은 출력되지 않는다.
			 **/			
			System.out.println("3번");
			
		} catch(Exception e) {			
			// try 블럭에서 Exception이 발생하여 4번이 출력됨	
			System.out.println("4번");
			
		} finally { // finally 블록은 필요하지 않으면 생략할 수 있다.			
			// 예외가 발생되거나 정상 흐름 모두 항상 finally 블럭이 실행된다.
			System.out.println("5번");
		}		
		System.out.println("6번");
	}
}
