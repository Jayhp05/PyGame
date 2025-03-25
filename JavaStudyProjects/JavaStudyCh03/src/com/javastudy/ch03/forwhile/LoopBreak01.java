package com.javastudy.ch03.forwhile;

// 반복문을 빠져 나가는 break 문 사용하기
public class LoopBreak01 {
	
	public static void main(String[] args) {
			
		for(int i = 1; i <= 10; i++) {			
			if(i >= 5) {
				// break 명령을 만나면 현재 반복문을 빠져나간다.
				System.out.println("break x : " + i);				
				break;
			}
		}
		System.out.println();		
		
		for(int i = 1; i < 5; i++) {			
			for(int j = 1; j < 5; j++) {				
				if(j >= 3) {					
					/* break 명령이 기술된 안쪽 for 문만 빠져나간다.
					 * 현재 for문을 빠져 나가 밖에 있는 for 문의 "바깥쪽 for 문..." 부분이 
					 * 콘솔에 출력되고 증감식으로 이동하여 i를 1증가시키고 조건식을 비교하여
					 * true면 다시 바깥쪽 for 문으로 들어와 안쪽 for 문이 실행된다.
					 **/
					System.out.println("안쪽 for 문 break : j = " + j);
					break;
				}
				System.out.println("안쪽 for 문 : j = " + j);
			}
			System.out.println("바깥쪽 for 문  : i = " + i);
		}
	}
}
