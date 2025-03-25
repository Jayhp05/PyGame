package com.javastudy.ch03.array;

// 배열을 이용한 로또번호 생성기 만들기
public class JavaArray03 {
	
	public static void main(String[] args) {
		
		// 로또번호 6개를 저장할 배열 변수를 선언하고 초기화 한다.
		int[] lotto = new int[6];
		for(int i = 0; i < lotto.length; i++) {
			// for문이 반복될 때 마다 난수를 발생해 로또 번호를 생성하고 변수 lotto에 저장 
			int num = (int) (Math.random() * 45) + 1;
			lotto[i] = num;
		}
		
		// for문을 이용해 생성된 로또 번호를 화면에 출력한다. 
		for(int i = 0; i < lotto.length; i++) {
			System.out.print(i < (lotto.length - 1) ? lotto[i] + ", " : lotto[i]);
		}
	}
}
