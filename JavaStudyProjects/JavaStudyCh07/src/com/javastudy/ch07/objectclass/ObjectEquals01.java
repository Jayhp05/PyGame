package com.javastudy.ch07.objectclass;

// Object 클래스의 equals 메소드로 같은 인스턴스인지 비교하기
public class ObjectEquals01 {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("홍길동");
		Person p2 = new Person("홍길동");
		
		/* 참조 변수 p1과 p2가 같은 인스턴스를 가리키고 있으면 true를 반환 한다.
		 * 다시 말해 참조 변수 p1과 p2에 저장된 인스턴스의 참조 값을 비교하여
		 * 같으면(동일한 객체) true를 반환하고 다르면(다른 객체) false를 반환한다.
		 * Object 클래스의 equals() 대신 동등연산자(==)를 사용하여 참조 변수에
		 * 저장된 참조 값을 직접 비교하여 동일한 객체인지 판단할 수도 있다.
		 **/
		if(p1.equals(p2)) {			
			System.out.println("p1과 p2는 같은 사람입니다.");
			
		} else {			
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
		
		/* p2의 참조값을 p1에 대입하여 같은 인스턴스를 가리키게 하고 있다.
		 * 이전에 p1이 참조하고 있던 인스턴스는 가비지가 된다.
		 **/
		p1 = p2;
		
		if(p1.equals(p2)) {			
			System.out.println("p1과 p2는 같은 사람입니다.");
			
		} else {			
			System.out.println("p1과 p2는 다른 사람입니다.");
		}
	}
	
}

