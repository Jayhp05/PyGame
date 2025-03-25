package com.javastudy.ch08.map;

import java.util.Enumeration;
import java.util.Properties;

// Properties 클래스를 이용해 어플리케이션의 환경설정 정보 관리하기
public class PropertiesMethods01 {
	
	public static void main(String[] args) {
		
		/* HashTable을 상속한 Properties 클래스는 key와 value를
		 * 모두 String 타입으로 관리할 수 있도록 구현된 클래스 이다.
		 * Properties는 주로 응용프로그램의 환경정보를 관리하는데 사용한다.
		 * Properties 클래스도 Map 계열의 클래스로 key의 중복을 허용하지
		 * 않고 데이터의 저장 순서를 유지하지 않는 특징을 가지고 있다.
		 * 중복된 key의 데이터가 입력되면 기존의 value 데이터를 덮어 쓴다.
		 **/
		Properties prop = new Properties();
		prop.setProperty("dirver", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("username", "HR");
		prop.setProperty("password", "12345678");
		
		System.out.println("데이터베이스 연결정보");

		// Properties에 저장된 key 값을 Enumeration(열거형) 타입으로 반환한다.
		Enumeration<?> e = prop.propertyNames();
		
		/* Enumeration(열거형)도 Iterator와 같이 처음 Enumeration 타입으로
		 * 데이터를 받았을 때 커서가 첫 번째 데이터 바로 이전을 가리키고 있어 while문의
		 * 조건식에서 hasMoreElements()를 사용해 열거형에서 다음 위치에 데이터가
		 * 존재하는지 체크하고 데이터가 존재 한다면 while문 안에서 nextElement()를
		 * 사용해 다음에 존재하는 데이터를 읽어 올 수 있다.
		 **/ 
		while(e.hasMoreElements()) {			
			/* nextElement()로 열거형에서 다음에 위치한 key 값을 읽어와
			 * 그 key 값을 이용해 Properties에 저장된 value 값을 읽어 온다.
			 **/
			String key = (String) e.nextElement();
			System.out.println(key + " : " + prop.getProperty(key));
		}
	}
}
