package com.javastudy.ch05.polymophism3.controller;

import java.util.Scanner;

// PloyController를 실행해 주는 시작 클래스
public class PloyAppStart {
	
	private static StringBuilder  commend = new StringBuilder()
			.append("==========================\n")
			.append("다음에서 하나를 골라 요청 명령을 입력해 주세요\n")
			.append("--------------------------------------------\n")
			.append("index, boardList, boardDetail, writeForm\n")
			.append("writeProcess, updateForm, updateProcess\n")
			.append("deleteProcess, loginForm, login, logout\n")
			.append("종료 하려면 x를 입력해 주세요\n")
			.append("==========================\n");
			
	public static void main(String[] args) {
		
		String input = null;		
		Scanner sc = null;
		PolyController controller = new PolyController();
		System.out.println("PolyAppStart...");
		
		do {
			System.out.println(commend.toString());
			sc = new Scanner(System.in);
			input = sc.next();
				
				// x 또는 X가 입력되면 프로그램 종료
				if(input.toUpperCase().equals("X")) {
					System.out.println("안녕히 가세요~~");
					sc.close();
					break;
				}
			
			// PloyController를 통해서 요청을 처리한다.
			controller.doProcess(input);
			
			//sc.close();
		} while(true);

	}
}
