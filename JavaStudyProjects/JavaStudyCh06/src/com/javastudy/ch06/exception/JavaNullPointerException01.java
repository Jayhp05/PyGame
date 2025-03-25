package com.javastudy.ch06.exception;

// 참조 값이 null인 변수를 사용하면 발생하는 NullPointerException 예외 처리하기
public class JavaNullPointerException01 {
	
	static Member member;
	
	public static void main(String[] args) {		
		
		Member m1 = new Member("이순신", 35);
		System.out.println("m1 : " + m1);		
		
		try {			
			/* member 변수는 클래스 맴버로 클래스 로딩시 null로 초기화 된다.
			 * member 변수가 가리키는 인스턴스가 없는 상태에서 인스턴스 메소드를
			 * 호출하게 되면 NullPointerException이 발생하게 된다.
			 * member 변수의 참조 값이 null 이므로 member 변수는 어떠한 객체도
			 * 가리키고 있지 않은 상태에서 메소드를 호출하기 때문에 발생하는 예외이다.
			 * 즉 member 변수만 존재하고 그 변수가 참조하고 있는 객체가 없기 때문에
			 * member 변수를 사용해 메소드를 호출하는 것은 메모리에 존재하지도 않는
			 * 객체를 이용해 메소드를 호출하는 격이 된다.  
			 **/
			member.setName("을지문덕");
			
		} catch(NullPointerException e) {
			// Stack을 추적하여 Stack의 내용을 출력하는 메소드
			e.printStackTrace();
			System.out.println("존재하지 않는 객체를 참조 : " + e.getMessage());
		}
		System.out.println(member);
	}
}
