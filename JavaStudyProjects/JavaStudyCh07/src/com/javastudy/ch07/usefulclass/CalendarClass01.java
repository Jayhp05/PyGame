package com.javastudy.ch07.usefulclass;

import java.util.Calendar;

// Calendar 클래스를 이용해 날짜와 시간데이터 다루기 1
public class CalendarClass01 {

	public static void main(String[] args) {
		
		/* Calendar 클래스는 날짜와 시간 정보를 GMT(Greenwich Mean Time) 시간을
		 * 기준으로 제공하는 클래스 이다. 이 클래스는 1970년 01월 01일 0시를 기준으로
		 * 1000 분의 1초 단위로 시간 정보를 처리할 수 있는 기능을 제공하는 클래스 이다.
		 * Date 클래스와는 다르게 오로지 1970년 01월 01일 0시를 기준으로 한다.
		 * 
		 * Calendar 클래스는 추상 클래스로 new 연산자를 이용해 객체를 생성할 수 없으며
		 * 아래와 같이 getInstance() 메서드를 사용해 Calendar 클래스의 인스턴스를
		 * 생성할 수 있다. 이 메서드는 외부에서 new 연산자를 이용해 인스턴스를 생성할 수
		 * 없으므로 클래스 이름으로 바로 접근할 수 있도록 static 메서드로 정의되어 있다.
		 * 
		 * 아래는 시스템의 오늘 날짜를 기준으로 Calendar 클래스의 인스턴스를 생성한다.
		 **/
		Calendar cal = Calendar.getInstance();
		
		/* 아래와 같이 get() 메서드를 이용해 각각의 날짜와 시간 데이터를 구할 수 있다.
		 * 월 데이터는 0 베이스이므로 실제 월을 표현할 때는 1을 더하면 된다.
		 **/
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR); 
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		// 아래는 Calendar 인스턴스의 요일 SUNDAY(1) ~ SATURDAY(7)을 반환한다.
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String strWeek = "";
		switch(week) {
		case 1 :
			strWeek = "일요일";
			break;
		case 2 :
			strWeek = "월요일";
			break;
		case 3 :
			strWeek = "화요일";
			break;
		case 4 :
			strWeek = "수요일";
			break;
		case 5 :
			strWeek = "목요일";
			break;
		case 6 :
			strWeek = "금요일";
			break;
		case 7 :
			strWeek = "토요일";
			break;
		}
		
		System.out.println("오늘은 " + year + "년 " + month + "월 " 
				+ day + "일(" + strWeek + ")이며 현재 시간은 " + hour + "시 " 
				+ minute + "분 " + second + "초 입니다.");
	}
}
