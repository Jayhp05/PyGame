package com.javastudy.ch07.stringclass;

// valueOf() 메서드로 기본형 데이터를 문자열 데이터로 변환하기
public class StringValueOf01 {
	
	public static void main(String[] args) {
		
		int i = 30;		
		boolean b = true;
		char c = 's';
		
		/* 기본 형 데이터를 문자열로 변환하는 메서드
		 * String 클래스의 valueOf() 메서드는 static으로 정의되어 있어 객체를 생성할
		 * 필요 없이 클래스 이름을 사용해 기본형 데이터를 문자열로 변환할 수 있다.
		 * String 클래스에 valueOf() 메서드는 byte와 short 형을 제외한 기본 형 데이터
		 * 6개를 문자열로 변환할 수 있도록 9개의 메소드로 오버로딩 되어있다.
		 **/		
		String iStr = String.valueOf(i);		
		String bStr = String.valueOf(b);
		String cStr = String.valueOf(c);
		
		/* 문자열을 기본형 데이터로 변환하기
		 * 자바 기본형 8개에 대응하는 Wrapper 클래스가 존재하며 각 Wrapper
		 * 클래스에는 각각 대응되는 기본형으로 변환하는 메소드를 가지고 있다.	
		 **/
		i = Integer.parseInt(iStr);		
		b = Boolean.getBoolean(bStr);
		c = cStr.charAt(0);		
	}
}
