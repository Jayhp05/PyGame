package com.javastudy.ch06.exception;

// 예외 던지기와 예외를 선언하여 호출자에게 예외처리를 미루기
public class JavaExceptionThrows01 {
	
	public static void main(String[] args) {
		
		/* 메소드 선언부에 throws IllegalArgumentException을 기술해
		 * add(byte, byte) 메소드를 사용하는 호출자에게 예외처리를 미루고
		 * 있지만 IllegalArgumentException은 UncheckedException으로
		 * try-catch 문을 사용해 예외 처리를 하지 않아도 컴파일은 가능하나 
		 * 아래 코드가 실행되면 IllegalArgumentException이 발생한다.
		 **/
		byte b = add((byte) 100, (byte) 120);
		System.out.println("연산결과 : " + b);
		
		/* 메소드 선언부에 throws Exception을 기술해 add(short, short) 
		 * 메소드를 사용하는 호출자에게 예외처리를 미루고 있기 때문에
		 * CheckedException에 대한 예외 처리가 되지 않아 컴파일을 할 수 없다.
		 * try-catch 문으로 반드시 예외 처리를 해야 컴파일이 가능하다.
		 **/
		//short s = add((short) 32765, (short) 200);
		
	}
	
	/* UncheckedException - RuntimeException을 상속한 Exception
	 * UncheckedException은 컴파일시 체크되지 않는 Exception으로
	 * 프로그램이 실행되는 과정에서 예외가 발생하게 된다. 
	 * 아래 메소드는 파라미터로 넘어오는 값 a와 b를 더해서 byte형의 범위 보다
	 * 크면 if문 안에서 throw를 사용해 IllegalArgumentException을 던지고
	 * throws를 이용해 예외를 선언하여 호출자에게 예외처리를 미루고 있다.
	 * 이 메소드에서 던지는 예외가 UncheckedException 이므로 throws로 예외를 
	 * 미루지 않고 try-catch 문을 사용해 예외를 처리하지 않아도 컴파일이 가능하다.
	 **/
	static byte add(byte a, byte b) throws IllegalArgumentException {		
		if((a + b) > 127) {			
			throw new IllegalArgumentException(
					"숫자 범위를 초과한 수가 입력됨 : " + (a + b));
		}
		return (byte) (a + b);
	}
	
	/* CheckedException - 그외 Exception 들
	 * CheckedException은 컴파일시 체크되기 때문에 Exception 처리를 반드시 해야 한다.
	 * 아래 메소드는 파라미터로 넘어오는 값 a와 b를 더해서 short형의 범위 보다
	 * 크면 if문 안에서 throw를 사용해 Exception을 던지고 throws를 이용해
	 * 예외를 선언하여 호출자에게 예외처리를 미루고 있다.
	 * 이 메소드에서 던지는 예외가 CheckedException 이므로 throws를 사용해 예외처리를
	 * 미루지 않는다면 try-catch 문을 사용해 반드시 예외를 처리해야 컴파일 할 수 있다. 
	 **/
	static short add(short a, short b) throws Exception {		
		if((a + b) > 32767) {
			throw new Exception("숫자 범위를 초과한 수가 입력됨 : " + (a + b));
		}
		return (short) (a + b);
	}
}
