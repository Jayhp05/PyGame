package com.javastudy.ch07.stringbuilder;

// StringBuilder의 메소드 사용하기
public class StringBuilder02 {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("1234567890");
		StringBuffer sf = new StringBuffer("어려운 Java");
		
		// StringBuilder에 저장된 문자열을 거꾸로 나열한다.
		sb.reverse();
		System.out.println("sb를 역순으로 출력 : " + sb);	
		
		/* StringBuilder에 저장된 문자열에서 index 범위의 문자를 제거 한다.
		 * 두 번째 매개변수의 index 바로 이전까지 제거 한다.
		 **/
		sb.delete(0, 1);
		System.out.println("sb의 첫 번째 문자 제거 : " + sb);
		
		/* StringBuilder에 저장된 문자열에 첫 번째 매개변수로 지정한 
		 * index 위치에 두 번째 매개변수의 데이터를 추가 한다.
		 **/
		sb.insert(2, ".");
		System.out.println(sb);
		
		/* StringBuffer에 저장된 문자열에서 index 범위의 문자열을 지정한
		 * 문자열로 치환 한다. 두 번째 매개변수의 index 바로 이전까지 적용 된다.
		 **/
		sf.replace(0, 3, "쉬운");
		System.out.println(sf);
		
		// 지정한 위치부터 문자열 추출
		System.out.println(sb.substring(sb.indexOf(".") + 1));
		System.out.println(sf.substring(3));			
	}
}
