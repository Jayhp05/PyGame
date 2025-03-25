package com.javastudy.ch07.stringbuilder;


// String과 StringBuilder의 속도 비교
public class StringBuilder03 {
	
	public static void main(String[] args) {
		
		String str = "";
		StringBuilder sb = new StringBuilder();
		StringBuffer sf = new StringBuffer();
		
		long start = 0;
		long end = 0;
		
		/* String의 작업 속도 계산
		 * 1970년 1월 1일 0시부터 ~ 현재까지의 시간을 밀리 초로 구한다.
		 **/
		start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			str += "java";
		}
		end = System.currentTimeMillis();
		System.out.println("String : " + (end - start));
		
		// StringBuilder의 작업 속도 계산
		start = System.currentTimeMillis();
		for(int i = 0; i < 500000; i++) {
			sb.append("java");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder : " + (end - start));
		
		// StringBuffer의 작업 속도 계산
		start = System.currentTimeMillis();
		for(int i = 0; i < 500000; i++) {
			sf.append("java");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuffer : " + (end - start));
	}	
}
