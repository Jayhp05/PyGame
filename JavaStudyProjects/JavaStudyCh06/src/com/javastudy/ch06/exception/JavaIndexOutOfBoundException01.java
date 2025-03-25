package com.javastudy.ch06.exception;

// 배열을 사용할 때 자주 발생하는 ArrayIndexOutOfBoundsException 예외 처리하기
public class JavaIndexOutOfBoundException01 {
	
	public static void main(String[] args) {
		
		int[] nums = { 1, 3, 5, 6, 9 };

		try {			
			/* for문 맨 마지막에 배열의 index 범위를 넘어 접근했기 때문에 
			 * ArrayIndexOutOfBoundsException이 발생한다.
			 * Exception이 발생 했지만 try{} catch{}문을 사용해 예외를 처리했기
			 * 때문에 프로그램의 비정상 종료를 막고 다음 코드로 정상적인 실행 흐름을
			 * 유지 시킬 수 있다.
			 **/
			for(int i = 0; i <= nums.length; i++) {
				System.out.println(nums[i]);
			}					
						
		} catch(ArrayIndexOutOfBoundsException e) {			
			System.out.println("잘못된 index 접근 : " + e.getMessage());
		}		
				
		try {
			// 배열 index를 -1로 지정하여 배열의 index 범위를 벗어난다.
			System.out.println(nums[-1]);
			//System.out.println(0 / 0);
			
		/* 아래와 같이 catch 블럭을 여러 개 지정해 다양한 예외에 대해 처리할 수 있다.
		 * 이 때 주의할 것은 예외 타입도 업 캐스팅이 되므로 하위 예외 타입의 catch 블럭을
		 * 위쪽에 배치하고 상위 예외 타입을 아래쪽에 배치해야 세부적인 예외처리가 가능하다.
		 * 만약 아래에서 Exception 타입의 catch 블럭을 위쪽에 배치한다면  
		 * ArrayIndexOutOfBoundsException을 비롯한 Exception의 하위 타입의
		 * 예외가 발생하더라도 모두 Exception 타입의 catch 블럭에서 예외가 처리되므로
		 * 세부적인 예외 처리가 필요하다면 상위 타입의 catch 블럭을 아래쪽에 배치해야 한다. 
		 **/
		} catch(ArrayIndexOutOfBoundsException aoe) {			
			System.out.println("잘못된 index 접근 : " + aoe.getMessage());
			
		} catch(Exception e) {			
			/* ArrayIndexOutOfBoundsException 발생으로 
			 * 이 catch 블럭은 실행되지 않고 finally 블럭으로 넘어간다.
			 **/			
			System.out.println(e.getMessage());
			
		} finally {			
			/* finally 블록은 예외가 발생할 때나 발생하지 않을 때 모두 실행된다.
			 * finally 블록에는 주로 프로그램에서 사용한 자원(DB 연결 해제 등)을 
			 * 해제하거나 예외가 발생하더라도 꼭 실행해야 하는 코드를 기술한다.
			 **/  
			System.out.println("finally는 항상 실행됨");
		}
	}
}
