package com.javastudy.ch07.stringclass;

import java.util.Arrays;

// 특정 문자열로 시작하거나 끝나는 문자열 찾기
// startsWith(), endsWith(), equalsIgnoreCase()
public class StringMethods03 {
	
	public static void main(String[] args) {
		
		String[] files = { 
				"javastudy.zip", "EnglishStudy.hwp", "java수업.hwp", 
				"JSPStudy.txt", "자바 웹프로그래밍", "Java과제.hwp" };		
		
		int count1 = 0;
		int count2 = 0;
		String keyword = "hwp";
		System.out.println("초기 files 배열의 내용 - " + Arrays.toString(files));
		
		// 반복문 안에서 지정한 문자열과 시작하거나 끝나는 문자열의 개수를 count
		for(int i = 0; i < files.length; i++) {
			
			// 매개변수로 넘어온 keyword의 문자열로 끝나면 true를 반환한다.
			if(files[i].endsWith(keyword)) {				
				count1++;								
			}
			
			// 매개변수로 넘어온 문자열이 java로 시작하면 true를 반환한다.
			if(files[i].startsWith("java")) {				
				count2++;
				
			} else if(files[i].substring(0, 4).equalsIgnoreCase("java")){				
				// 대소문자 구분 없이 java 라는 단어로 시작하면 카운트 증가
				count2++;
			}
		}
		
		System.out.println("files 배열의 hwp 파일의 수 : " + count1 + "개");
		System.out.println("files 배열의 java로 시작하는 파일의 수 : " + count2 + "개");
	}
}
