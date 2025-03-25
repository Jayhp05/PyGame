package com.javastudy.ch06.exception;

import java.io.File;

// 사용자 정의 예외 클래스 만들기
/* CheckedException 계열의 사용자 정의 예외 클래스를 정의하려면 Exception
 * 클래스를 상속받고 UncheckedException 계열의 사용자 정의 예외 클래스를
 * 정의하려면  RuntimeException 클래스를 상속받아 사용자 정의 예외 클래스를
 * 작성하면 된다. 
 *
 * 아래는 mp3 파일이 존재하지 않으면 발생하는 예외를 Exception 클래스를
 * 상속받아 CheckedException 계열의 사용자 정의 예외 클래스를 정의하고 있다.
 **/
class MP3NotFoundException extends Exception {
	
	public MP3NotFoundException(String message) {
		super(message);
	}	
}

/* 유효하지 않은 mp3 파일일 경우 발생하는 예외를 Exception 클래스를
 * 상속받아 CheckedException 계열의 사용자 정의 예외 클래스를 정의하고 있다. 
 **/
class MP3FileInvalidException extends Exception {
	
	public MP3FileInvalidException(String message) {
		super(message);
	}
}


public class UserDefinitionExceptionTest {
	
	public static void main(String[] args) {
		
		/* 프로젝트의 src 위치에 test.txt, test.mp3 파일이 존재하는지
		 * 확인하고 File() 생성자의 값을 수정해 보면서 테스트 해 보자.
		 * mp3 파일은 음악 파일은 아니고 test.txt을 확장자만 변경한 것이다.
		 **/ 
		File file = new File("src/test.mp3");
		
		try {			
			mp3Open(file);
			play(file);
			
		} catch(MP3NotFoundException e) {			
			System.out.println(e.getMessage());
			
		} catch(MP3FileInvalidException e) {			
			System.out.println(e.getMessage());
			
		} finally {			
			// File을 읽을 때 사용한 Stream을 닫는 코드를 여기에 기술한다.			
		}
		
		// 자바 7 부터는 여러 예외를 하나의 catch 문에 선언할 수 있다.
		try {			
			mp3Open(file);
			play(file);
			
		} catch(MP3NotFoundException | MP3FileInvalidException e) {	
			System.out.println(e.getMessage());
			
		} catch(Exception e) {			
			System.out.println(e.getMessage() + " : " + e.getCause());
			
		} finally {			
			// File을 읽을 때 사용한 Stream을 닫는 코드를 여기에 기술한다.			
		}
	}	
	
	/* mp3 파일을 불러오는 메소드
	 * throws를 사용해 사용자가 정의한 MP3NotFoundException과 
	 * MP3FileInvalidException을 선언하여 호출자에게 예외 처리를 미루고 있다.
	 **/
	static void mp3Open(File file) throws	
		MP3NotFoundException, MP3FileInvalidException {
		
		/* 참조 변수 file이 null 이거나 File 객체를 생성하면서 생성자에
		 * 지정한 파일 또는 디렉터리가 존재하지 않으면 if문이 실행되어
		 * MP3NotFoundException이 발생하게 된다.
		 **/
		if(file == null || ! file.exists()) {
			throw new MP3NotFoundException("MP3 파일이 존재하지 않습니다.");			
		}		
		System.out.println(file.getName() + " 을 읽는 중...");
	}
	
	/* File 객체를 매개 변수로 받아 mp3 파일을 재생 하는 메소드
	 * throws를 사용해 사용자가 정의한 MP3FileInvalidException을
	 * 선언하여 호출자에게 예외 처리를 미루고 있다.
	 **/
	static void play(File file) throws MP3FileInvalidException {
		
		/* 확장자 정보를 이용해 mp3 파일인지 체크한다.
		 * 확장자가 mp3 파일이 아니면 MP3FileInvalidException이 발생한다.
		 **/
		if(! file.getName().endsWith("mp3")) {			
			throw new MP3FileInvalidException("선택한 파일은 MP3파일이 아닙니다.");
		}		
		System.out.println(file.getName() + " 을 재생하는 중...");
	}	
}

