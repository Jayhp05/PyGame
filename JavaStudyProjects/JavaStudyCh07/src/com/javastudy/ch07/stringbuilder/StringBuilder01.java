package com.javastudy.ch07.stringbuilder;

// StringBuilder와 StringBuffer의 생성자와 특징
public class StringBuilder01 {
	
	public static void main(String[] args) {
		
		/* StringBuilder 인스턴스생성
		 * String 데이터는 내부의 문자열이 한 번 생성되면 그 데이터를 변경할 수 없다. 
		 * 자바에서 String 데이터끼리의 + 연산은 문자열을 연결하여 새로운 
		 * String 객체를 생성하는 방식으로 문자열을 관리한다.
		 * StringBuffer와 StringBuilder는 내부에 버퍼를 사용해 문자열을 저장해 두고
		 * 그 버퍼에서 문자열을 추가, 수정, 삭제하는 방식으로 문자열 데이터를 관리한다.
		 **/		
		StringBuilder sb = new StringBuilder();		
		StringBuffer sf = new StringBuffer();		
		
		/* StringBuilder의 append() 메서드는 자바의 기본형 데이터와 문자열
		 * 데이터 등을 문자열로 추가할 수 있도록 13개 메서드를 오버로딩 하고 있다.		
		 **/		
		sb.append("String Builder");
		sb.append(true);
		sb.append(123.5f);
		
		// StringBuilder와 StringBuffer의 메소드는 거의 같다.		
		sf.append("String Builder");
		sf.append(true);
		sf.append(123.5f);
		
		// StringBuilder와 StringBuffer의 실제 데이터의 길이, 내용을 출력한다.
		System.out.println("sb 길이 : " + sb.length() + ", sb 내용 : " + sb.toString());		
		System.out.println("sf 길이 : " + sf.length() + ", sb 내용 : " + sf.toString());
		
		/* StringBuilder와 StringBuffer은 equals()가 오버라이딩 되어 있지 않고 
		 * toString()만 오버라이딩 되어 있어 내용을 비교할 때는 toString()을 이용하여
		 * 문자열 데이터로 변환 후 String 클래스의 equals()를 이용해 비교하면 된다.
		 **/
		System.out.println("sb.equals(sf1) : " + sb.equals(sf));
		System.out.println("sb.toString().equals(sf.toString()) : "
					+ sb.toString().equals(sf.toString()));				
	}
}
