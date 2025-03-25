package com.javastudy.ch07.usefulclass;

import java.util.Calendar;
import java.util.Date;

// Calendar 클래스를 이용해 날짜와 시간데이터 다루기 2
public class CalendarClass02 {
	
	public static void main(String[] args) {
		
		// 시스템의 오늘 날짜를 기준으로 Calendar 클래스의 인스턴스를 생성한다.
		Calendar cal = Calendar.getInstance();
		
		/* getTime() 메서드는 Calendar 객체를 Date 객체로 변환해 반환한다.
		 **/
		Date d1 = cal.getTime();		
		
		// Calendar 객체의 밀리 초 정보를 이용해 Date 객체를 생성
		Date d2 = new Date(cal.getTimeInMillis());
		
		/* Date 클래스의 getYear() 메서드는 1900년 이후의 년도를
		 * 반환하기 때문에 정확한 년도를 표현하려면 추가적인 보정이 필요하다.
		 **/
		System.out.println("올해는 : " + d1.getYear() + "년");
		System.out.println("올해는 : " + (d2.getYear() + 1900) + "년");
		
		// Date 객체의 밀리 초 정보를 이용해 Calendar 객체의 시간을 설정할 수 있다.
		cal.setTimeInMillis(d1.getTime());

		// Date 객체를 아래와 같이 Calendar 객체의 시간 정보로 설정할 수 있다. 
		cal.setTime(d2);
		
		/* Calendar 객체에 set() 메서드를 이용해 새로운 시간 데이터를 설정할 수 있다.
		 * 다양한 시간 설정을 위해서 set() 메서드는 4개로 오버로딩 되어 있다.
		 **/
		cal.set(2021, 11, 23, 14, 35, 55);		
		System.out.println(cal.get(Calendar.YEAR) + "년 " 
				+ (cal.get(Calendar.MONTH) + 1) + "월 " 
				+ cal.get(Calendar.DAY_OF_MONTH) + "일 " 
				+ cal.get(Calendar.HOUR_OF_DAY) + "시 " 
				+ cal.get(Calendar.MINUTE) + "분 " 
				+ cal.get(Calendar.SECOND) + "초 입니다.");
	}
}
