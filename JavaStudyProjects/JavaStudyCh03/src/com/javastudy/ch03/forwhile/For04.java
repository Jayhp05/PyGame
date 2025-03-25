package com.javastudy.ch03.forwhile;

// for문을 이용한 1부터 ~ 100까지 3의 배수와 개수 그리고 그 합계 구하기
public class For04 {
	
	public static void main(String[] args) {	
		
		final int num = 3;
		int count = 0;
		int sum = 0;
		String nums = "";
		
		for(int i = 1; i <= 100; i++) {
			
			// 어떤 수를 3으로 나눠서 나머지가 0이면 그 수는 3의 배수이다.
			if(i % num == 0) {
				// 3의 배수를 콤마(,)로 구분해 문자열로 저장
				nums += (100 - num >= i) ?  i + ", " : i;
				
				// 3의 배수의 합계와 개수를 구한다.
				sum += i;
				count = count + 1; // count++;
			}
		}
		
		System.out.println("1부터 ~ 100까지 3의 배수는\n " + nums);
		System.out.println("개수는 " + count + "개이며 합계는 " + sum + "입니다.");
	}
}
