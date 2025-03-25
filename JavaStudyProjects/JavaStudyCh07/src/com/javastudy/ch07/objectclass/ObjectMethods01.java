package com.javastudy.ch07.objectclass;

// Object 클래스의 메소드
public class ObjectMethods01 {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("이순신");
		
		// 인스턴스의 클래스 이름 출력하기
		System.out.println("p1의 완전한 클래스명 : " + p1.getClass().getName());
		System.out.println("p1의 클래스명 : " + p1.getClass().getSimpleName());
		
		/* hashCode() 메소드는 인스턴스의 메모리 주소를 사용해
		 * 해시코드를 생성하기 때문에 중복되지 않는 고유한 정수를 반환 한다.
		 **/
		System.out.println("p1의 해쉬코드 : " + p1.hashCode());
		
		// 인스턴스의 클래스 명@16진수 해시코드 값 형태로 출력 한다.
		System.out.println("p1을 이용한 정보출력하기 : " + p1.getClass().getName() 
				+ "@" + Integer.toHexString(p1.hashCode()));
		
		/* Person 클래스는 toString() 메소드를 오버라이드 하지 않았기 때문에
		 * 부모 클래스인 Object 클래스로부터 상속받은 toString() 메소드가 호출된다.
		 * Object 클래스의 toString() 메소드는 인스턴스에 대한 정보를 문자열로 반환하는
		 * 메서드로 "인스턴스의 클래스 명@16진수 해시코드 값" 형태로 문자열을 만들어 반환해 준다. 
		 **/
		System.out.println("Object toString이 호출됨 : " + p1);
	}
}

class Person {
	
	String name;
	
	Person(String name) {
		this.name = name;
	}
}