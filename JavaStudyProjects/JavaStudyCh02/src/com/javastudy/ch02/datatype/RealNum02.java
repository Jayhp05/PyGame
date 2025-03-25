package com.javastudy.ch02.datatype;

// float 형과 double 형의 정밀도 비교
public class RealNum02 {
	
	public static void main(String[] args) {
		
		float f = 0.763F;
		float f1 = 0.763f;			
		double d = 0.763d;
		
		/* double형과 float형을 연산하게 되면 먼저 두 수의 형을
		 * 동일하게 맞춘 후에 실제 연산이 이루어지는데 이 때 float형의 
		 * 변수가 double형으로 자동 형 변환 된 후 연산을 하게 된다.
		 * 
		 * float과 double은 수의 표현 범위가 다르므로 소수 자리를 표현하는 범위도 다르다.
		 **/
		System.out.println(f + " / " + f1 + " = " + (f / f1));
		
		/* 포맷팅 문자열 출력(형식화된 문자열 출력) 
		 * printf() 메서드를 사용해 특정 형식에 맞는 문자열로 결과를 출력할 수 있다. 
		 **/
		System.out.printf("%f / %d = %f\n", f, d, f / d);		
		System.out.println();
		System.out.println((float)(9.9 / 3));
		System.out.println(9.9 / 3);
	}
}
