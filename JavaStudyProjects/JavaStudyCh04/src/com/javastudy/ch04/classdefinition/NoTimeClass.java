package com.javastudy.ch04.classdefinition;

// 시간 데이터 다루기
public class NoTimeClass {

	public static void main(String[] args) {
		
		/* 여러 개의 시간 데이터를 다루기 위해 여러 개의 변수가 필요하다.
		 * 아래는 3개의 시간 데이터를 다루기 위해 변수 9개를 선언하였다.
		 * 만약 100개의 시간 데이터를 다뤄야 한다면 그때 마다 매번 
		 * 3개의 변수를 추가로 선언해야 하는 불편함이 따른다.
		 **/
		int hour1, hour2, hour3;
		int minute1, minute2, minute3;
		int second1, second2, second3;
		
		hour1 = 12;
		minute1 = 35;
		second1 = 57;
		System.out.println("현재 시간 : " 
				+ hour1 + "시 " + minute1 + "분 " + second1 + "초");
		
		/* 여러 개의 시간 데이터를 다루기 위해 배열을 사용하면 변수만 사용할 때
		 * 보다 조금 간편해 지긴 했지만 시, 분, 초 데이터가 따로 분리되어 있어 
		 * 프로그래밍 중에 다른 시간, 분, 초 데이터와 서로 뒤섞일 가능성이 있다.
		 **/
		int[] hour = new int[3];
		int[] minute = new int[3];
		int[] second = new int[3];
		hour[0] = 9;
		hour[1] = 11;
		hour[2] = 10;
		minute[0] = 24;
		minute[1] = 37;
		minute[2] = 57;
		second[0] = 3;
		second[1] = 56;
		second[2] = 27;
		
		for(int i = 0; i < hour.length; i++) {
			System.out.println((i + 1) + "번째 시간 데이터 : " 
					+ hour[i] + "시 " + minute[i] + "분 " + second[i] + "초");
		}
		System.out.println();
	}
}
