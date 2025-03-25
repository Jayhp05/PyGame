package com.javastudy.ch03.conditional;

// switch 문을 이용해 영문 문자열에 따라 메달 종류 출력하기 
public class Switch03 {

	public static void main(String[] args) {
		
		String medal = "silver";
		
		/* switch 문은 식의 결과가 int 형으로 자동 형 변환 가능하거나
		 * byte, char, short, int 형 데이터만 가능하였으나
		 * jdk 1.7부터는 String과 enum 타입도 가능해졌다.
		 * 
		 * switch 문의 조건식에 해당하는 case 절이 없다면 default 절만 실행된다.
		 **/
		switch(medal) {
		case "Gold": case "gold":
			System.out.println("금메달 입니다.");			
			break;
		case "Silver": case "silver":
			System.out.println("은메달 입니다.");
			break;
		case "Bronze": case "bronze":
			System.out.println("동메달 입니다.");
			break;
		default:
			System.out.println("아쉽네요 no 메달 입니다.");
			break;
		}
	}
}
