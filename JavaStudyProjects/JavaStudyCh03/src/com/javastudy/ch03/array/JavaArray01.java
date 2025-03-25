package com.javastudy.ch03.array;

// 동일한 타입의 데이터를 하나로 묶어서 다루는 배열(Array) 
public class JavaArray01 {
	
	public static void main(String[] args) {
		
		// 5개의 int 형 자료를 저장할 수 있는 배열의 선언과 초기화
		int numbers[] = new int[5];		
		int[] nums = {1, 3, 5, 7, 9};	
		
		// 배열의 원소(데이터)는 index로 접근 - index는 0부터 시작 한다.
		int num1 = nums[0];
		System.out.println("배열 nums의 첫 번째 데이터 : " + num1);
		
		// 배열의 길이는 index와 달리 배열 안에 저장된 데이터 개수를 의미 한다.
		System.out.println("배열의 길이 : " + nums.length);		
		
		/* 배열의 크기를 이용해 for문의 조건식을 작성
		 * 배열의 원소는 0부터 시작하는 index로 접근하기 때문에 배열의 
		 * 마지막 원소가 위치한 index는 1부터 시작하는 배열의 길이보다 1작다.
		 * 배열의 index 범위를 벗어난 index를 지정하여 배열에 접근하면 
		 * IndexOutOfBoundsException이 발생한다.
		 **/
		System.out.print("배열 nums의 데이터 : ");
		for(int i = 0; i < nums.length; i++) {			
			// i가 배열의 마지막 데이터가 아니면 콤마(,)로 구분하여 출력
			System.out.print(i != nums.length - 1 ? nums[i] + ", " : nums[i]);
		}
		
		// for문을 이용해 배열 mumbers에 데이터 저장하기
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}		
		System.out.println();
		
		System.out.print("배열 numbers의 데이터 : ");		
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(i < numbers.length - 1 ? i + ", " : i);
		}
	}
}
