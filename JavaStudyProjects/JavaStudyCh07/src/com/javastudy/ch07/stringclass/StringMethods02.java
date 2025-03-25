package com.javastudy.ch07.stringclass;

import java.util.Arrays;

// 문자열 안에서 지정한 문자열이 포함되어 있으면 대문자로 변환하기
// contains(), toUpperCase(), toLowerCase(), replace(), split()
public class StringMethods02 {
	
	public static void main(String[] args) {
		
		String[] files = { 
				"javastudy.zip", "EnglishStudy.txt", "java수업.hwp", 
				"JSPStudy.txt", "자바 웹프로그래밍", "Java과제.txt" };
		
		String strFiles = "";
		int count = 0;
		String keyword = "java";
		System.out.println("초기 files 배열의 내용 - " + Arrays.toString(files));
		
		// 반복문 안에서 keyword를 포함하고 있으면 대문자 그렇지 않으면 소문자로 변환
		for(int i = 0; i < files.length; i++) {
			
			// 매개변수로 넘어온 keyword의 문자열을 포함하고 있으면 true를 반환한다.
			if(files[i].contains(keyword)) {				
				count++;
				
				// 문자열을 대문자로 변환하는 메소드
				files[i] = files[i].toUpperCase();
				
			} else {
				
				// 문자열을 소문자로 변환하는 메소드
				files[i] = files[i].toLowerCase();
			}
		}
		
		System.out.println(keyword + "에 대한 검색 결과 " + count + "개 파일을 찾음");
		System.out.println("검색 후 files 배열의 내용 - " 
						+ (strFiles = Arrays.toString(files)));
		
		// 첫 번째 매개변수에 지정한 문자열을 찾아 두 번째 매개변수에 지정한 문자열로 치환
		strFiles = strFiles.replace("[", "");
		strFiles = strFiles.replace("]", "");
		System.out.println("[와 ]를 공백문자열로 치환 후 : " + strFiles);
		
		// 첫 번째 매개변수에 지정한 문자열을 두 번째 매개변수에 지정한 문자열로 치환
		strFiles = strFiles.replace(',', '/');
		System.out.println(strFiles);
		
		// 매개변수로 지정한 문자열을 기준으로 문자열을 분할하여 String 배열로 반환한다.
		String[] strs = strFiles.split("/");
		System.out.println("분할한 문자열의 개수 : " + strs.length);
		
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}
}
