package com.javastudy.ch03.forwhile;

// while 문을 이용해 1 ~ 100까지 합 구하기
public class While01 {
	
	public static void main(String[] args) {
		
		int i = 1;
		int sum = 0;
		
		while(true) {
			
			/* while문은 for문과는 다르게 초기문과 반복 후의 명령문을 지정할 수 없어
			 * 조건이 true로 주어지는 경우 아래와 같이 while문을 종료하기 위해 필요한
			 * 증감식과 특정 조건에서 while문을 빠져나가는 구문이 기술되어야 한다.
			 * 그렇지 않으면 while문은 무한 반복문이 된다.
			 *    
			 * 	후 증감 연산자를 이용해 i의 값을 sum에 더한 후 1증가시킴		
			 **/
			sum += i++;
			
			// i가 100보다 크면 while문을 빠져나간다.
			if(i > 100) {
				break;
			}
		}
		System.out.println("1 ~ 100까지의 합 : " + sum);
	}
}
