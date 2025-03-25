package com.javastudy.ch03.array;

// 2차원 배열 사용하기
public class JavaArray05 {
	
	public static void main(String[] args) {
		
		/* 2차원 배열을 선언하고 각 요소를 1차원 배열로 초기화
		 * 2차원 배열은 배열안의 배열로 2차원 배열의 각 요소는 1차원 배열로 구성된다.
		 **/
		int [][] nums = { 
				{ 1, 2, 3}, { 4, 5, 6 }, { 7, 8, 9 }				
		};
		
		/* 2 x 3 크기의 2차원 배열을 생성하고 
		 * 배열이 생성된 메모리 주소의 참조 값을 변수 str에 저장한다. 
		 **/
		String strs[][] = new String[2][3];
		
		/* 2차원 배열 strs의 첫 번째 요소인 1차원 배열의 index 0의 위치에
		 * 문자열 데이터 "자바"를 저장하고 strs의 2번째 요소인 1차원 배열의
		 * index 2의 위치에 문자열 데이터 "오라클"을 저장한다. 나머지 배열
		 * 요소는 String이 참조 타입이므로 참조 타입 변수의 기본 값인 null로 채워진다.
		 **/
		strs[0][0] = "자바";
		strs[1][2] = "오라클";
		
		// 2차원 배열은 중첩 for문을 이용해 배열의 각 요소에 순차적으로 접근할 수 있다.
		for(int i = 0; i < strs.length; i++) {			
			for(int j = 0; j < strs[i].length; j++) {				
				System.out.println("strs[" + i + "][" + j + "] - " + strs[i][j] );
			}
		}
		
		// 2차원 배열도 index를 이용해 배열의 각 요소에 접근할 수 있다.
		System.out.println();
		System.out.println(nums[1][1] + ", " + nums[2][0]);
		
		// 2차원 배열은 중첩 for문을 이용해 배열의 각 요소에 순차적으로 접근할 수 있다. 
		for(int i = 0; i < nums.length; i++) {			
			for(int j = 0; j < nums[i].length; j++) {				
				System.out.print(nums[i][j] + ", ");				
			}			
		}		
	}
}
