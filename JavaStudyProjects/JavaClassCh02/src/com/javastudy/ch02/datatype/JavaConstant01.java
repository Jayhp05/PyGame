package com.javastudy.ch02.datatype;

// 상수 사용하기
public class JavaConstant01 {
	
	/* 상수도 변수와 마찬가지로 데이터가 저장되는 메모리 공간의 이름으로
	 * 상수에 저장할 데이터 타입과 함께 선언해야 하며 아래 코드와 같이
	 * 데이터 타입 앞에 final이라는 예약어를 사용해 상수를 선언할 수 있다. 
	 * 변수는 프로그램 중에 값이 변경될 수 있지만 상수는 한번 값이 지정되면
	 * 프로그램이 실행되는 동안 그 값을 변경할 수 없다.
	 **/	
	
	// 상수는 초기화 이후 값을 변경할 수 없다.
	private static final int DEFAULT_NUM = 10;
	private static final String DEFAULT_NAME = "홍길동";

	public static void main(String[] args) {
		
		// 상수에 새로운 값을 할당 하면 에러 발생
		//DEFAULT_COUNT = 10;		
		
		System.out.println(DEFAULT_NUM);
		System.out.println(DEFAULT_NAME);
	}
}
