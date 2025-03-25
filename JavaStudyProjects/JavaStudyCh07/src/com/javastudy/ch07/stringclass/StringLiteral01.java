package com.javastudy.ch07.stringclass;

// String 리터럴과 new 연산자를 이용해 생성한 String 인스턴스의 차이
public class StringLiteral01 {
	
	public static void main(String[] args) {	
		
		/* String Literal은 상수 풀에 저장되며 같은 문자열이 존재하면
		 * 새로 생성하지 않고 기존에 존재하는 문자열을 참조하게 된다.
		 * 자바에서 문자열은 한번 생성되면 변하지 않는 특성을 가지고 있다.
		 **/		 
		String str1 = "Java Study";
		String str2 = "Java Study";
		
		// str1과 str2의 문자열을 연결하여 새로운 문자열을 생성한다.
		System.out.println(str1 + str2);		
		
		/* new 연산자를 이용해 String 객체를 생성하면 heap 영역에 각각의
		 * 인스턴스가 생성되고 각각의 인스턴스에 문자열이 저장된다.
		 **/
		String str3 = new String("Java Study");
		String str4 = new String("Java Study");		
		
		/* 상수 풀에 존재하는 하나의 문자열을 2개의 변수가 참조하므로 
		 * str1과 str2의 참조 값은 같다. 그러므로 true가 반환된다.
		 **/
		System.out.println("str1 == str2 : " + (str1 == str2));
		
		/* String 클래스에서 오버라이딩한 equals() 메소드로 문자열의 내용을 한다. 
		 * 그러므로 str1과 str2의 문자열 내용이 같기 때문에 true가 반환된다.
		 **/
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		
		/* 상수 풀에 존재하는 문자열과 heap 영역의 인스턴스를 비교 - false
		 * 참조변수 str1에 저장된 값은 상수 풀에 생성된 String 인스턴스의 참조 값이며 
		 * str3에 저장된 값은 heap 영역에 생성된 String 인스턴스의 참조 값이므로
		 * 두 참조변수의 값을 비교하는 동등연산(==)의 결과는 false가 된다.  
		 **/
		System.out.println("str1 == str3 : " + (str1 == str3));
		
		/* 오버라이딩된 String 클래스의 equals() 메소드를 사용해 비교 - true
		 * str1은 상수 풀에 생성된 인스턴스의 참조 값을 str3은 heap 영역에 생성된
		 * 인스턴스를 참조하므로 동등연산자(==)를 이용하면 참조 값을 비교하게 되어
		 * false가 반환되지만 String 클래스에서 오버라이딩한 equals() 메서드를
		 * 이용하면 참조 값이 다른 String 인스턴스의 내용이 동일한지 비교할 수 있다.
		 **/
		System.out.println("str1.equals(str3) : " + str1.equals(str3));
		
		// new 연산자로 생성된 다른 영역에 존재하는 String 인스턴스를 비교 - false
		System.out.println("str3 == str4 : " + (str3 == str4));
		
		// String 클래스의 equals() 메소드를 사용해 문자열 내용을 비교 - true
		System.out.println("str3.equals(str4) : " + str3.equals(str4));
	}
}
