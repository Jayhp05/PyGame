package com.javastudy.ch06.exception;

// 문자열을 숫자로 변경할 때 발생 할 수 있는 NumberFormatException 예외 처리하기
public class JavaNumberFormatException01 {
	
	public static void main(String[] args) {
		
		String num1 = "110";
		String num2 = "110a";	
		
		try {				
			/* Integer.parseInt() 메서드는 지정한 문자열을 숫자로 변환해 주는 메서드로
			 * 숫자 형식이 아닌 문자열을 지정하면 NumberFormatException이 발생한다.
			 **/
			//int i = Integer.parseInt(num1);
			int i = Integer.parseInt(num2);
			System.out.println(i + 10);
						
		} catch(NumberFormatException e) {
			System.out.println("유효한 숫자가 아닙니다 : " + e.getMessage());			
		}		
	}
}
