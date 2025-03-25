package com.javastudy.ch07.usefulclass;

import java.util.StringTokenizer;

// StringTokenizer 클래스를 활용해 문자열 분리하기
public class StringTokenizer01 {
	
	public static void main(String[] args) {
		
		String str = "id=midas&name=강감찬&age=27";		
		StringTokenizer st = new StringTokenizer(str, "&");
		
		// 생성자의 두 번째 문자열을 기준으로 분리할 수 있는 token의 수를 얻는다.
		System.out.println("token의 수 : " + st.countTokens());
		
		// hasMoreTokens() 메소드는 다음 토큰이 존재하면 true를 반환한다.
		while(st.hasMoreTokens()) {
			
			/* "&"를 기준으로 분리한 토큰 중 i 번째 위치한 토큰을 가져와 다시
			 * String 클래스의 split()를 이용해 "="로 분리하여 배열로 반환 받는다.
			 **/
			String temp[] = st.nextToken().split("=");
			
			if(temp[0].equals("id")) {				
				System.out.println("아이디 : " + temp[1]);
				
			} else if(temp[0].equals("name")) {				
				System.out.println("이 름 : " + temp[1]);
				
			} else if(temp[0].equals("age")) {				
				System.out.println("나 이 : " + temp[1]);
			}
		}		
	}
}
