package com.javastudy.ch03.conditional;

// switch 문을 이용한 경품 추첨기 만들기
public class Switch01 {
	
	public static void main(String[] args) {
		
		int score = (int) (Math.random() * 10) + 1;
		
		/* switch 문은 식의 결과가 int 형으로 자동 형 변환 가능하거나
		 * byte, char, short, int 형 데이터만 가능하였으나
		 * jdk 1.7부터는 String과 enum 타입도 가능해졌다.
		 * 
		 * 아래에서는 switch 문의 괄호 안의 식의 결과가 100, 200, 300, 400
		 * 일때 해당 각각의 case 절의 코드가 실행되고 break 명령을 만나서 switch
		 * 문을 빠져 나가며 이에 해당하지 않을 때는 default 절의 코드가 실행된다.
		 **/
		switch(score * 100) {
			case 100  :			
				System.out.println("축 당첨~ 경품은 라면 1박스 입니다.");
				break;
			case 200  :
				System.out.println("축 당첨~ 경품은 5만원 상품권 입니다.");
				break;
			case 300  :
				System.out.println("축 당첨~ 경품은 자전거 입니다.");
				break;
			case 400  :
				System.out.println("측 당첨~ 경품은 자동차 입니다.");
				break;
			default :
				System.out.println("아쉽네요~ 당첨 되지 못했습니다.");
		}
	}
}
