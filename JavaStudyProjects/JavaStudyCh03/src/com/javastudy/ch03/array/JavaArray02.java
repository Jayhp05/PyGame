package com.javastudy.ch03.array;

// 배열을 이용한 학생의 성적(총점, 평균) 출력하기
public class JavaArray02 {
	
	public static void main(String[] args) {		
		
		// int 데이터를 저장하는 배열의 선언 및 초기화		
		int[] score = new int[3];
		score[0] = 88;
		score[1] = 81;
		score[2] = 86;		
		int total = 0; 
		
		// for문을 이용해 배열에 저장된 점수의 총점을 구한다.
		for(int i = 0; i < score.length; i++) {
			total += score[i];						
		}
		
		System.out.println("총점 : " + total + ", 평균 : " + total / score.length);		
		
		total = 0;		
		/* 향상된 for 문은 배열이나 열거형(Enumeration) 또는 컬렉션 프레임 워크의
		 * List 계열 객체에 순차적으로 접근할 때 유용하게 사용할 수 있는 반복문이다.
		 * for문 안에서 사용할 변수를 선언하고 배열과 열거형 또는 컬렉션을 지정하면
		 * 반복문이 반복될 때 마다 변수를 이용해 현재 위치의 데이터에 접근할 수 있다. 
		 **/
		for(int s : score) {
			
			/* 변수 s는 index의 역할을 하는 것이 아니라 반복문이 반복될 때 마다
			 * score 배열의 현재 index에 해당하는 데이터가 s에 저장 된다.
			 * 즉 s = score[0], score[1], score[2]... 와 같이 동작하게 된다.  
			 **/
			total += s;
		}
		
		System.out.println("총점 : " + total + ", 평균 : " + total / score.length);
	}
}
