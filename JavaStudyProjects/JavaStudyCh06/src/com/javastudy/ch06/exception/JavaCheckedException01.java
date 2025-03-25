package com.javastudy.ch06.exception;

import java.io.IOException;

// 컴파일러가 체크하는 익셉션과 체크하지 않는 익셉션
public class JavaCheckedException01 {
	
	public static void main(String[] args) {
		
		try {			
			/* 모든 예외 클래스는 Exception 클래스를 상속해 구현되었지만 크게
			 * RuntimeException과 그 외의 Exception 들로 나눌 수 있다.
			 * RuntimeException 클래스 또한 Exception을 상속해 구현되었지만
			 * 이 계열의 예외는 컴파일러가 체크해 주지 않는 UncheckedException으로
			 * try-catch 문을 사용해 예외를 처리하지 않아도 컴파일은 가능하다.
			 * IOException은 Exception을 상속한 클래스로 컴파일러가 체크해
			 * 주는 CheckedException에 속하기 때문에 try-catch 문을 사용해
			 * 반드시 예외를 처리해야 컴파일이 가능하다.
			 * CheckedException은 주로 프로그램 실행시 외부의 영향에 의해 발생할 수
			 * 있는 예외로 FileNotFoundException, ClassNotFoundException, 
			 * InstantiationException 등이 여기에 속한다.
			 * 아래에서 IOException을 생성하여 던졌으므로 IOException이 발생한다.
			 **/
			throw new IOException("컴파일시 체크되는 익셉션");
			
		} catch(IOException e) {			
			System.out.println("IOException : " + e.getMessage());	
			
		} catch(Exception e) {			
			/* 위쪽의 catch 블록에 정의한 IOException의 catch 블록에
			 * 캐치되어 Exception이 처리되고 이 catch 블럭은 실행되지 않는다.
			 **/
			System.out.println("Exception : " + e.getMessage());
		}
		
		/* RuntimeException도 Exception을 상속한 클래스이지만
		 * UncheckedException으로 컴파일시 체크되지 않아 try-catch
		 * 문을 사용하지 않아도 컴파일은 가능하나 실행 타임에 에러가 발생한다.
		 * RuntimeException은 주로 프로그래머의 실수로 인해 발생하는 예외이다.
		 * IndexOutOfBoundException, NullPointerException, 
		 * ClassCastException, ArithmeticException 등이 
		 * RuntimeException을 상속해 구현된 예외 클래스 들이다.
		 * 아래에서 RuntimeException을 생성하여 던졌으므로 예외가 발생한다.
		 **/
		throw new RuntimeException("컴파일시 체크되지 않는 익셉션");
	}
}
