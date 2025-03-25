package com.javastudy.ch02.operator;

import java.util.Scanner;

// 입력된 첫번째 문자가 한글인지 아닌지 판단하기(삼항 연산자 활용)
public class Operator06 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("한글 한 자만 입력해주세요");
		
		// 키보드에 입력된 데이터를 문자열로 읽어온다.
		String input = sc.next();	
		
		/* 키보드에서 읽어온 데이터는 문자열 데이터이므로 자바에서 기본 제공하는 
		 * String 클래스의 charAt() 메서드를 이용하면 첫 번째 문자를 읽어 올 수 있다.
		 * 자바는 String 클래스로 문자열을 처리할 수 있는 다양한 메서드를 제공하고 있다.
		 **/
		char ch = input.charAt(0);
		System.out.print("첫 번째 문자 : " + ch + "는 ");		
		System.out.println(ch >= '가' && ch <= '힣' ? "한글 입니다." : "한글이 아닙니다.");
		
		// Scanner 사용이 끝나면 자원을 해제한다.
		sc.close();
	}
}
