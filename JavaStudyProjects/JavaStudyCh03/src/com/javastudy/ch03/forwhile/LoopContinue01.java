package com.javastudy.ch03.forwhile;

// 반복문의 처음으로 이동하는 continue 문 사용하기
public class LoopContinue01 {
	
	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			
			if(i % 2 == 0) {
				
				/* continue 명령을 만나면 현재 반복문의 처음으로 돌아간다.
				 * for 문일 경우 continue 명령을 만나면 증감식으로 이동하여
				 * 값을 증가시킨 후 조건식으로 이동하여 true면 for 문 안의 코드를 
				 * 수행하고 조건식이 false면 for 문을 빠져 나가게 된다.
				 * while 문일 경우 조건식으로 이동하고 do~while 문일 경우
				 * while 문의 조건식으로 이동하여 true면 반복문 안의 코드를
				 * 수행하고 false면 반복문을 빠져 나가게 된다.
				 * while 문이나 do~while 문의 조건식에 사용되는 변수의 값이
				 * 변경되는 위치에 따라 무한 반복문이 될 수 있으므로 주의가 필요하다.
				 **/
				continue;
			} else {
				sum += i;
			}
			// 이 아래 다른 추가 코드가 있다고 가정
		}
		System.out.println("1 ~ 100까지 홀수의 합 : " + sum);
	}
}
