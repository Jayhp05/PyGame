package com.javastudy.ch03.conditional;

// 중첩 if 문을 이용해 점수에 해당하는 학점 출력하기
public class If04 {
	
	public static void main(String[] args) {
		
		int score = 59;
		String grade = null;
		
		if(score >= 90) { // 90점 이상이면
			grade = "A";
			
			if(score >= 95) { // 95점 이상이면
				grade += "+";
				
			} else { 			// 95점 미만이면
				grade += "-";
			}
		} else if(score >= 80) { // 80점 이상이면
			grade = "B";
			
			if(score >= 85) { // 85점 이상이면
				grade += "+";
				
			} else { 			// 85점 미만이면
				grade += "-";
			}
		} else if(score >= 70) { // 70점 이상이면
			grade = "C";
			
			if(score >= 75) { // 75점 이상미면
				grade += "+";
				
			} else { 			// 75점 미만이면
				grade += "-";
			}			
		} else if(score >= 60) { // 60점 이상이면
			grade = "D";
			
		} else {
			grade = "F";
		}
		
		System.out.printf("당신의 점수는 %d점으로 학점은 %s 입니다.",  score, grade);
	}
}
