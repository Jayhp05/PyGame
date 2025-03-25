package com.javastudy.ch05.polymophism3.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.javastudy.ch05.polymophism3.service.CommandProcess;

// 상속과 오버라이딩을 활용해 동일한 방식으로 서비스 클래스를 실행해 요청을 처리하는 클래스  
public class PolyController {

	// 요청 명령과 이 명령을 처리할 서비스 클래스의 인스턴스를 저장할 Map 객체 생성
	Map<String, CommandProcess> commandMap = 
			new HashMap<String, CommandProcess>();   
	
	// 생성자에서 초기화 작업 - 서비스 작업 준비
	public PolyController() {
		
		/* properties 파일에 저장된 요청 명령어와 명령어를 처리할 
		 * 서비스 클래스 이름을 저장할 Properties 객체를 생성	
		 * HashTable을 상속해 구현한 Properties 클래스는 key와 value를
		 * 모두 String 타입으로 관리할 수 있도록 구현한 Map계열의 클래스 이다.
		 **/
		Properties prop = new Properties();
		
		/* properties 파일을 읽기 위해 Stream을 선언하고 null로 초기화 한다.
		 * FileInputStream은 File의 내용을 Byte 단위로 읽을 수 있는 기반 스트림이고
		 * BufferedInputStream은 File을 Byte 단위로 읽을 때 작업 성능을 높이기 위해
		 * 임시 저장소(buffer) 역할을 담당하는 보조 스트림 이다. 
		 **/		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {			
			/* uriCommand.properties 파일의 내용을 읽기 위해 FileInputStream을
			 * 생성하고 이 파일이 위치한 경로를 생성자의 인수로 지정 한다.
			 **/ 
			fis = new FileInputStream("src/uriCommand.properties");
			bis = new BufferedInputStream(fis);

			/* 파일에 연결된 스트림 객체를 Properties 클래스의 load()의 인수로
			 * 지정하면 properties 파일에 저장된 String 데이터를 한 라인씩 읽어
			 * 첫 번째 오는 '=' 문자나 ':' 문자를 기준으로 key와 value로 저장해 준다.
			 **/
			prop.load(bis);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 보조 스트림을 먼저 닫고 기반 스트림을 닫는다.
				if(bis != null) bis.close();
				if(fis != null) fis.close();
			} catch(IOException e) { }
		}

		/* Propertiest 객체에 저장된 key 리스트를 Set 타입으로 반환하는
		 * keySet() 메서드를 이용해 Set에 접근하기 위한 Iterator 객체를 얻어 온다.
		 **/ 
		Iterator<Object> keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String cmd = (String) keyIter.next();
			String className = prop.getProperty(cmd);
			
			try {
				/* Class 클래스 타입의 변수를 선언하고 key에 해당하는 요청 
				 * 명령을 처리할 서비스 클래스의 정보를 메모리에 로딩 시킨다.
				 **/
				Class<?> commandClass = Class.forName(className);
				
				/* 요청 명령을 처리할 서비스 클래스의 슈퍼 인터페이스 타입의 변수를 
				 * 선언하고 메모리에 로딩된 서비스 클래스의 인스턴스를 생성하여 할당 한다.
				 * 
				 * 이와 같이 실행 시간에 동적으로 클래스 정보를 읽어와 그 클래스의 인스턴스를
				 * 생성하는 자바 프로그래밍 기법을 리플렉션(Replection)이라고 한다.
				 * 리플렉션은 구체적인 클래스 타입을 알지 못해도 그 클래스를 찾아 인스턴스를
				 * 생성해고 메소드나 변수에 접근할 수 있도록 지원하는 자바 API 이다.
				 * 작성할 시점에는 어떤 클래스를 사용할지 구체적으로 모르지만 실행 시간에 클래스
				 * 정보를 읽어와 인스턴스를 생성하고 사용해야 할 때 리플렉션 기법을 사용한다.   
				 **/
				CommandProcess service = 
						(CommandProcess) commandClass.newInstance();

				/* 요청 명령을 key로 요청 명령을 처리할 서비스 클래스의 인스턴스를 value 저장
				 **/
				commandMap.put(cmd, service);
				System.out.println(cmd + " : " + service);
				
			} catch(ClassNotFoundException e) {				
				e.printStackTrace();
				
			} catch(InstantiationException e) {
				e.printStackTrace();
				
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 매개 변수로 받은 명령을 처리할 서비스 클래스의 인스턴스를 실행하는 메서드
	public void doProcess(String cmd) {		
		
		/* 요청 처리 결과를 저장할 변수
		 **/
		String result = null;
				
		/* 사용자가 입력한 요청 명령을 매개 변수로 받아서 해당 명령을 처리할 서비스 클래스의
		 * 인스턴스를 Map으로부터 구해서 부모 타입인 CommandProcess 타입으로 읽어
		 * 온다. 그리고 각각의 서비스 클래스에서 구현한 오버라이딩된 requestProcess()
		 * 메서드를 호출하여 사용자 요청을 처리한다. 아래와 같이 상속과 오버라이딩 그리고
		 * 업캐스팅을 활용하면 CommandProcess 인터페이스 타입으로 이 인터페이스를
		 * 구현한 모든 서비스 클래스의 인스턴스를 참조할 수 있게 된다. 그러므로 새로 명령이
		 * 추가되거나 수정되더라고 소스 코드를 직접 수정할 필요는 없고 요청 명령과 클래스
		 * 정보를 저장하고 있는 uriCommand.properties 파일만 수정하면 된다.   
		 **/ 
		CommandProcess service = commandMap.get(cmd);

		if(service != null) {
			result =  service.requestProcess();
		}
		System.err.println(result != null ? result : "명령을 잘 못 입력했습니다.");
	}
}
