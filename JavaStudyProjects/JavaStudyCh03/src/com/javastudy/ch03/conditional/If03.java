package com.javastudy.ch03.conditional;

// if 문을 이용한 학점 출력하기
public class If03 {
	
	public static void main(String[] args) {
						
		/* 1 ~ 100까지 랜덤한 수를 얻어 변수에 저장
		 * Math.random()은 0 ~ 1사이의 실수를 생성하여 반환해 준다.
		 * 생성되는 랜덤 수는 아래와 같이 0은 포함되고 1은 포함되지 않는다.
		 * 예 : 0.00000, 0.00012, 0.34567, 0.78912, 0.99999
		 **/
		int score = (int)(Math.random() * 100) + 1;
		
		char grade = ' ';
		
		if(score >= 90) { // 90점 이상이면
			grade = 'A';
		} else if(score >= 80) { // 80점 이상이면
			grade = 'B';
		} else if(score >= 70) { // 70점 이상이면
			grade = 'C';
		} else {
			grade = 'F';
		}
		
		System.out.printf("당신의 점수는 %d점으로 %c 학점 입니다.", score, grade);
	}
}
