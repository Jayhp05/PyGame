package com.javastudy.ch03.forwhile;


// while 문을 이용한 1 ~ 100까지 7의 배수 출력하기
public class While02 {

	public static void main(String[] args) {
		
		final int num = 7;
		int i = 1;		
		String nums = "";
		
		while(i <= 100) {			
			
			// 상수 num의 값이 7이므로 num으로 나누어 나머지가 0이 되면 7의 배수임
			if(i % num == 0) {
				
				/* 7의 배수를 콤마(,)로 구분하여 nums의 문자열에 추가	
				 * 비교 연산자 보다 사칙 연산자가 연산자 우선순위가 높으므로
				 * 100 - 7의 연산을 먼저 수행한 후 그 결과를 현재의 i에 저장된
				 * 값과 비교하여 i에 저장된 값이 작거나 같으면 콤마(,)를 추가하고
				 * 그렇지 않으면 i의 값만 문자열로 추가하기 위해 삼 항 연산자를 사용함
				 * 즉 1 ~ 100까지 7의 배수 중 맨 마지막에 위치한 7의 배수를 제외하고
				 * 나머지 7의 배수를 콤마(,)로 구분하여 출력하기 위해 삼 항 연산자를 사용함 
				 **/				
				nums += (i <= 100 - num) ? i + ", " : i; 
			}
			
			/* while문의 조건식에 사용된 i를 1씩 증가시켜 101이 되면 
			 * while문의 조건식 결과가 false가 되므로 while문을 빠져 나가게 된다.
			 **/
			i++;
		}
		System.out.println(nums);
	}
}
