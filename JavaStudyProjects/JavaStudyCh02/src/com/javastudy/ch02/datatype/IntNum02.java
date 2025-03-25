package com.javastudy.ch02.datatype;

// 정수형 데이터 사용하기 2
public class IntNum02 {
	
	public static void main(String[] args) {
		
		// short형과 int형 변수를 선언하고 동시에 값을 할당
		short s = 65;
		int i = 137;
		
		/* 정수형의 기본형은 int 형이므로 long형 데이터를 사용할 때는
		 * 숫자 뒤에 L 또는 l을 붙여서 long형 데이터임을 표현한다.
		 **/
		long l = 574L;
		
		/* int형 변수에 저장된 데이터를 short형 변수에 저장된 데이터로
		 * 뺄셈하여 그 결과를 콘솔로 출력하기
		 **/
		System.out.println("137 - 65 = " + (i - s));
		
		/* long형 변수에 저장된 데이터를 int형 변수에 저장된 데이터로
		 * 나누어 그 결과를 콘솔로 출력하기 
		 **/		
		System.out.println("574 / 137 = " + l / i);
	}
}