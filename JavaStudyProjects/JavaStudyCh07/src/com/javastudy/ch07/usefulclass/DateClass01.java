package com.javastudy.ch07.usefulclass;

import java.util.Date;

// Date 클래스를 이용해 날짜와 시간 데이터를 다루기
public class DateClass01 {

	public static void main(String[] args) {
		
		/* Date 클래스는 날짜와 시간 정보를 GMT(Greenwich Mean Time) 시간을
		 * 기준으로 제공하는 클래스 이다. 이 클래스는 1970년 01월 01일 0시를 기준으로
		 * 1000 분의 1초 단위로 시간 정보를 관리하는 유용한 클래스 이지만 일부 메서드는
		 * 1900년(getYear() 등)을 기준으로하기 때문에 사용하는데 주의가 필요하다. 실제로
		 * Date 클래스의 메서드 대부분은 Deprecated(사용을 권장 하지 않음) 되어 있다.
		 * 그러므로 다음 예제에서 다룰 Calendar 클래스를 사용하는 것이 좋다.
		 * 
		 * 아래는 시스템의 오늘 날짜를 기준으로 Date 클래스의 인스턴스를 생성한다.
		 **/
		Date d = new Date();
		int year = d.getYear();
		int month = d.getMonth();
		int day = d.getDate();
		int week = d.getDay();
		
		/* Date 클래스의 getYear() 메서드는 1900년 이후의 년도를 반환하기
		 * 때문에 정확한 년도를 구하기 위해서는 추가적인 보정 작업이 필요하다.
		 **/
		System.out.println("오늘은 " + year + "년 " + (month + 1) + "월 "
				+ day + "일(" + week + ")" + d.getHours() + ":" + d.getMinutes()
				+ ":" + d.getSeconds() + " 입니다.");
		
		/* Date 클래스는 이미 많이 사용되어져 있으므로 다른 데이터와 호환될 수 있도록
		 * 프로그램을 작성하는 것이 중요하며 Date 또는 시간을 다루는 클래스의 시간 데이터를
		 * 또 다른 클래스의 시간 데이터로 변경할 때에는 생성자 또는 메서드의 인수로 밀리 초 
		 * 형식으로 시간 데이터를 입력 받아 사용하는 것이 일반적인 방식이므로 각각의 시간
		 * 데이터에서 밀리 초를 반환해 주는 메서드를 기억하면 편리하다. 
		 **/
		System.out.println("1970년 1월 1일 0시 부터 오늘까지의 밀리초 : " + d.getTime());
	}
}
