package com.javastudy.ch02.datatype;

import java.util.Scanner;

// Scanner 클래스를 이용해 키보드 입력 처리하기
public class Scanner01 {
	
	public static void main(String[] args) {
		
		/* Scanner 클래스의 next()는 사용자가 입력한 키의 값을 공백(' ', \t, \f, 
		 * \r, \n)을 기준으로 구분하여 한 단위로 분리하고 분리된 한 단위씩 데이터를
		 * 읽어 들인다. 또한 데이터가 입력되지 않은 상태(아무것도 입력되지 않은 상태, 
		 * 공백 문자만 입력되었을 때 모두 해당됨)에서 Enter 키가 눌려져도 
		 * 다음 단계로 넘어가지 않고 데이터가 입력 될 때까지 대기하는 특징이 있다.
		 * 참고로 Scanner 클래스에는 nextLine() 메서드가 있는데 이 메서드는
		 * 한 줄 단위로 데이터를 읽어오기 때문에 대기하지 않고 다음 단계로 넘어간다.
		 **/
		Scanner scanner = new Scanner(System.in);
		
		/* next()는 공백으로 분리된 단위로 데이터를 읽기 때문에 "홍길동 11"을
		 * 한 줄에 입력하면 "홍길동"은 이름을 입력받는 첫 번째 next()가 읽고
		 * 나이를 입력받는 두 번째 next()는 두 번째 데이터가 이미 입력되었기
		 * 때문에 대기하지 않고 바로 11을 읽어 변수에 저장한다.
		 * */
		System.out.print("이름을 입력해 주세요 : ");		
		String name = scanner.next();
		
		System.out.print("나이를 입력해 주세요 : ");
		String age = scanner.next();
		
		// 포맷팅 문자열 출력
		System.out.printf("안녕하세요~ %s님! 당신의 나이는 %s세 군요", name, age);
		
		// Scanner 사용이 끝나면 자원을 해제한다.
		scanner.close();
	}
}
