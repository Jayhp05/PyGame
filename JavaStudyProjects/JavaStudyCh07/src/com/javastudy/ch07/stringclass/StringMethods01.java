package com.javastudy.ch07.stringclass;

// 문자열 안에서 특정 문자열을 찾아 필요한 문자열만 추출하기 
// trim(), length(), indexOf(), lastIndexOf(), substring()
public class StringMethods01 {
	
	public static void main(String[] args) {
		
		// 아래와 같이 양쪽에 공백이 있도록 문자열을 만든다.
		String filePath = "        D:\\javaStudy.zip         ";
		
		// trim() 메서드는 문자열의 양쪽 끝에서 공백 문자열을 제거하는 메소드
		filePath = filePath.trim();
		
		/* 매개변수로 넘겨준 문자열을 filePath 문자열에서 찾아 index를 반환한다.
		 * 매개변수로 지정한 첫 번째 만나는 문자열의 index를 반환하고 검색을 종료 한다.
		 * filePath 문자열에 매개변수로 넘겨준 문자열이 존재하지 않으면 -1을 반환한다.
		 **/
		int index = filePath.indexOf("\\");
		
		/* 매개변수로 넘겨준 index의 위치부터 끝까지 문자열을 추출하여 반환한다.
		 * 아래는 파일의 경로에서 확장자를 포함한 파일명을 추출한다.
		 **/
		String fileName = filePath.substring(index + 1);
		
		/* 매개변수로 넘겨준 시작 index와 끝 index 바로 이전까지의 문자열 반환한다.
		 * 문자열의 처음부터 점(.)이 위치한 바로 이전의 문자열까지 추출하여 반환한다.
		 * 아래는 파일명에서 확장자를 제외한 파일 이름만 추출한다.
		 **/
		index = fileName.indexOf(".");
		String name = fileName.substring(0, index);
		
		/* 문자열 중에서 점(.)이 있는 문자열 다음부터 마지막까지 추출한다.
		 * 파일명에서 확장자만 추출한다.
		 **/
		String extension = fileName.substring(index + 1);
		
		System.out.println("filePath : " + filePath);
		System.out.println("fileName : " + fileName);		
		System.out.println("파일명의 길이 : " + fileName.length() + "자");
		System.out.println("확장자를 제외한 파일 이름 : " + name);
		System.out.println("파일의 확장자 : " + extension);		
		System.out.println();
		
		filePath = "D:\\javastudy\\example\\string.study.txt";
		
		/* 매개변수로 넘겨준 문자열을 filePath 문자열의 끝에서 부터 찾아 index를
		 * 반환한다. 매개변수로 넘겨준 문자열의 뒤에서 부터 찾아 첫 번째 만나는 
		 * index를 반환하고 검색을 종료 한다. 
		 * 아래는 전체 경로에서 확장자를 포함한 파일명을 추출한다.
		 **/
		index = filePath.lastIndexOf("\\");
		fileName = filePath.substring(index + 1);
		
		// 아래는 파일명에서 확장자를 제외한 파일 이름을 추출한다.
		index = fileName.lastIndexOf(".");
		name = fileName.substring(0, index);
		
		// 아래는 파일명에서 확장자만 추출한다.
		extension = fileName.substring(index + 1);
		
		System.out.println("filePath : " + filePath);
		System.out.println("filePath의 길이 : " + filePath.length() + "자");
		System.out.println("fileName : " + fileName);
		System.out.println("확장자를 제외한 파일명 : " + name);
		System.out.println("파일의 확장자 : " + extension);
	}
}
