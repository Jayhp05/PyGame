package com.javastudy.ch03.forwhile;

import java.io.IOException;
import java.util.Scanner;

// 한번은 무조건 실행되는 do~while문 사용하기
public class DoWhile01 {
	
	public static void main(String[] args) throws IOException {
		
		String input = null;
		Scanner sc = new Scanner(System.in);
		
		/* do~while문 안의 코드가 한 번은 무조건 실행된 후
		 * while문의 조건식을 체크하게 된다.
		 **/
		do {			
			System.out.println("좋아하는 숫자를 입력해 주세요(do~while)\n"
					+ "종료하려면 x 또는 X를 입력 하세요");
			System.out.print(">> ");
			
			input = sc.next();
			System.out.println("입력된 값 : " + input);
			
		} while(! (input.equals("x") || input.equals("X")));
	}
}
