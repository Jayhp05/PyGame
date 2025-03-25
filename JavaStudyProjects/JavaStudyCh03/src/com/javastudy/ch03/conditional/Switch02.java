package com.javastudy.ch03.conditional;

// switch 문을 이용한 경품 추첨기 2
public class Switch02 {
	
	public static void main(String[] args) {
		
		int num = (int) (Math.random() * 10) + 1;
		int score = num * 100;
		String str = "";
		
		/* 다음과 같이 case 절에 break 명령을 사용하지 않으면 switch 문의
		 * 조건식과 일치하는 case 절의 코드부터 그 아래로 나오는 모든 case
		 * 절과 default 절의 코드가 실행된다. 다시 말해 score가 800 이라면
		 * case 800:의 코드가 실행되고 그 아래의 case 700:의 코드, default
		 * 절의 코드가 모두 실행되어 경품은 5만원 상품권, 라면 1박스, 고무장갑이 된다. 
		 **/
		switch(score) {
			case 1000 :
				str += "자동차, ";
			case 900 :
				str += "자전거, ";
			case 800 :
				str += "5만원 상품권, ";
			case 700 :
				str += "라면 1박스, ";
			default :
				str += "고무장갑";
		}
		
		System.out.printf("당신의 점수는 %d점으로 경품은 %s 입니다.", score, str);		
	}
}
