package com.javastudy.ch07.usefulclass;

import java.util.Calendar;

// 출력 포맷을 지정해 문자열을 생성하고 출력하기
public class StringFormatMethod01 {
	public static void main(String[] args) {
		
		/* String.format() 메서드의 첫 번째 인수로 문자열과 함께 format 형식을 
		 * 지정하고 format 형식의 순서에 맞춰 데이터를 지정하면 String 객체로 반환된다.
		 * 
		 * %s : 문자열,  %b : 논리값, %c : char, %t : 날짜 및 시간 출력 형식을 지정
		 * %d : 10진 정수, %o : 8진 정수, %x : 16진 정수
		 * %f : 실수, %e : 지수와 가수부 표기, %g : 반올림이 적용된 십진수 또는 지수
		 * 
		 * 자세한 내용 format() 메서드 API 문서에서 format A format string 부분 참고
		 * 이외에도 java.util.Formatter 클래스의 API 문서를 참고
		 **/				
		String name = "홍길동";
		int age = 33;
		float weight = 83.53f;
		int money = 10000000;
		
		String memberInfo1 = String.format("%s의 나이 %d세", name, age);
		String memberInfo2 = String.format("몸무게 %.2fKg, 자산 %,d원", weight, money);				
		System.out.println(memberInfo1);
		System.out.println(memberInfo2);
		
		/* printf() 메서드의 첫 번째 인수로 문자열과 함께 format 형식을 지정하고
		 * 순서에 맞춰 데이터를 지정하면 지정한 포맷에 맞는 문자열을 출력할 수 있다.
		 **/	
		System.out.printf("%s의 나이 %d세", name, age);
		System.out.println();
		System.out.printf("몸무게 %.2fKg, 자산 %,d원", weight, money);
		System.out.println();		
				
		/* 날짜 포맷 형식은 날짜 및 시간 데이터를 다양한 문자열로 표현할 수 있도록 많은
		 * 포맷 형식을 가지고 있으며 자세한 내용은 printf() 메서드의 API 문서에서 
		 * format A format string as described in Format string syntax 부분 참고
		 * 이외에도 java.util.Formatter 클래스의 API 문서를 참고
		 **/
		Calendar cal = Calendar.getInstance();
		System.out.printf("오늘은 %tY년 %tm월 %te일 입니다.", cal, cal, cal);	
		System.out.println();
		
		// 아래와 같이 인수의 위치를 1$로 지정하여 첫 번째 cal 변수 하나만 참조할 수도 있다. 
		System.out.printf("현재 시간은 %1$tH시 %1$tM분 %1$tS초 입니다.", cal);
		System.out.println();		
	}
}
