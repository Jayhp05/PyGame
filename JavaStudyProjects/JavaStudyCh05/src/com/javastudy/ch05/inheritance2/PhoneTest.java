package com.javastudy.ch05.inheritance2;

import com.javastudy.ch05.inheritance.HandPhone;

// 메소드 오버라이딩
public class PhoneTest {
	
	public static void main(String[] args) {		

		HandPhone hp = new HandPhone("핸드폰", true);
		System.out.println();
		
		hp.sendPhone();	
	}
}
