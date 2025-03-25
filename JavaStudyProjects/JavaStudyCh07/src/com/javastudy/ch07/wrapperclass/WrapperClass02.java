package com.javastudy.ch07.wrapperclass;

// Wrapper 클래스의 메소드 사용하기
public class WrapperClass02 {
	
	public static void main(String[] args) {
		
		// 숫자 형태의 문자열을 Wrapper 클래스인 Integer 타입으로 변환		 
		System.out.println(Integer.valueOf("100"));

		/* 숫자 형태의 문자열을 int 형으로 변환
		 * 자바 1.5 이상에서는 오토박싱/언박싱이 적용되므로
		 * 반환 값이 기본형 일 때와  Wrapper 타입 일 때의 차이가 없어졌다.
		 **/
		System.out.println(Integer.parseInt("200"));
		
		// Integer 타입의 숫자 5를 int 형으로 변환하여 반환한다.		 
		System.out.println(new Integer(5).intValue());
		System.out.println();
		
		// 16진수 FF를 10진수로 변환
		System.out.println("16진수 FF : " + Integer.parseInt("FF", 16));
		
		/* Wrapper 클래스도 new 연산자를 사용해 각각의 인스턴스를 생성할 수 있다. 
		 * 모든 Wrapper 클래스는 내부의 값을 String으로 반환해 주는 toString() 
		 * 메소드가 오버라이딩 되어 각 Wrapper 클래스의 toString() 메소드가 호출된다.
		 **/
		System.out.println("new Boolean(String) : " + new Boolean("true"));		
		System.out.println("new Double(String) : " + new Double("3.141592"));
		System.out.println("new Character(char) : " + new Character('c'));		
		System.out.println();
		
		/* 모든 Wrapper 클래스에는 인수로 지정하는 기본형 데이터를 String으로
		 * 변환해 반환하는 static 메서드인 toString() 메서드가 정의되어 있다.
		 **/
		System.out.println("Character.toString(char) : " + Character.toString('한'));
		System.out.println("Integer.toString(int) : " + Integer.toString(38));		
		System.out.println("Double.toString(double) :" + Double.toString(3.141592));
		
		/* String 클래스에는 int, long, float, double, char, boolean 등의 
		 * 데이터를 문자열로 변환해 주는 valueOf() 메서드가 오버로드 되어 있다.
		 **/
		System.out.println("String.valueOf(double) : " + String.valueOf(3.14));
	}
}
