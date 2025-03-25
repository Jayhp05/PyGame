package com.javastudy.ch02.operator;

// 문자열 데이터 비교하기
public class Operator03 {
	
	public static void main(String[] args) {		

		/* 자바에서 문자열은 객체로 다뤄지며 문자열 처리를 위해서 String 클래스를
		 * 제공하고 있다. 문자열은 프로그램에서 숫자만큼이나 많이 사용되는 데이터로
		 * 아래와 같이 문자열 리터럴을 통해 String 객체를 생성할 수 있도록 지원한다.
		 *
		 * 아래는 "Hello Java"라는 문자열 리터럴로 String 객체를 생성하여
		 * 객체가 생성된 메모리 주소의 참조 값을 String 타입의 str1 변수에 저장한다.
		 * str1에 객체가 생성된 메모리 주소의 참조 값이 저장되므로 변수 str1을
		 * 참조형 변수라고 부른다. 
		 *  
		 * 자바에서 변수는 8개의 기본 형 데이터를 저장하는 기본형 변수와 객체가 저장된
		 * 메모리 주소의 참조 값이 저장되는 참조형 변수로 나눌 수 있으며 기본형 변수의
		 * 크기는 기본형 데이터의 크기와 동일하고 모든 참조형 변수는 객체가 생성된 
		 * 메모리 주소의 참조 값을 4Byte 크기로 저장한다.
		 **/
		String str1 = "Hello Java";
		
		/* 프로그램에서 null 값은 자주 사용되는데 null이 의미하는 것은 현재 값이 정해져
		 * 있지 않은 미정의 값 또는 값이 없음을 의미하기도 한다. null 값은 참조형 변수에만
		 * 사용할 있고 기본형 변수에는 null 값을 사용할 수 없다. 참조형 변수에 null 값을
		 * 할당 하면 그 변수가 어떠한 객체도 참조하고 있지 않음을 의미하며 아래는 String
		 * 타입의 참조형 변수 str2를 선언하고 null로 초기화 하는 예이다.
		 **/ 
		String str2 = null;				
				
		/* 문자열 리터럴 비교하기
		 * 앞에서도 언급했듯이 리터럴은 상수의 개념으로 문자열 리터럴 또한 상수이며
		 * JVM에서 상수를 저장하고 관리하는 Constant Pool이라는 메모리 공간에
		 * 저장된다. String 타입의 변수에 문자열 리터럴을 할당하게 되면 Constant Pool에
		 * 동일한 문자열이 존재하는지를 먼저 검사한 후 동일한 문자열이 존재하면
		 * 그 문자열을 참조하게 되고 동일한 문자열이 존재하지 않으면 지정한 문자열을
		 * Constant Pool에 새로 등록하고 그 주소의 참조 값을 변수에 저장 한다.
		 **/		
		str2 = "Hello Java";		
		System.out.println("str1 == str2 : " + (str1 == str2));
		
		/* String은 참조타입으로 데이터가 저장된 주소의 참조 값을 변수에 저장 한다.
		 * 참조타입 변수의 "==" 연산은 변수에 저장된 참조 값이 같은지를 비교한다.
		 **/
		String str3 = new String("Hello Java");
		System.out.println("str1 == str3 : " + (str1 == str3));
		
		/* 두 String 객체의 내용이 같은지를 비교하려면 String 클래스가
		 * 제공하는 equals() 메서드를 사용해 아래와 같이 비교하면 된다.
		 **/
		System.out.println("str.equals(str3) : " + str1.equals(str3));
	}
}
