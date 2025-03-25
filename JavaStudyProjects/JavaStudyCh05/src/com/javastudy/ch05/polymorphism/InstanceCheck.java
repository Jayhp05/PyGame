package com.javastudy.ch05.polymorphism;

// instanceof 연산자를 이용한 객체의 타입 체크
class Car { }
class Bus extends Car { }
class Bongo extends Bus { }
class Ambulance extends Bus { }

public class InstanceCheck {	
	
	public static void main(String[] args) {
		
		Car car = new Car();
		Car bus = new Bus();		
		Car bongo = new Bongo();
		Car ambulance = new Ambulance();
		
		/* 자식의 인스턴스를 참조하고 있는 자식 타입의 참조 변수와 부모 클래스 타입을 
		 * instanceof 연산을 수행하면 true가 반환 된다. 이 처럼 instanceof 연산의
		 * 결과가 true이면 참조 변수를 비교한 클래스 타입으로 형 변환이 가능하다.
		 * 부모 클래스를 상속 받으면 부모의 모든 멤버를 자식이 포함하고 있기 때문이다.
		 **/
		System.out.println("bus instanceof Car : " + (bus instanceof Car));		
		System.out.println("bus instanceof Bus : " + (bus instanceof Bus));
		System.out.println("bus instanceof Object : " + (bus instanceof Object));
		System.out.println();
		
		/* 부모의 인스턴스를 참조하고 있는 부모 타입의 참조 변수와 자식 클래스 타입을
		 * instanceof 연산을 수행하면 false가 반환된다. 그 이유는 상속 관계라 
		 * 하더라도 부모 클래스의 멤버가 자식 클래스의 멤버 보다 적거나 같기 때문이다.
		 **/
		System.out.println("bus instanceof Bongo : " + (bus instanceof Bongo));	
		System.out.println();
		
		/* 자바의 클래스 상속 관계에서 형제 관계는 존재하지 않고 오로지 직계 상속 관계만
		 * 가능하다. Bongo 클래스가 Bus 클래스를 상속 하였으므로 bongo instanceof Bus
		 * 연산을 수행하면 true가 반환 된다. Ambulance 클래스 또한 Bus 클래스를 상속하여 
		 * Bongo 클래스와 Ambulance 클래스는 형제 관계지만 bongo instanceof Ambulance
		 * 연산을 수행하면 false가 반환 된다. 
		 **/
		System.out.println("bongo instanceof Bus : " + (bongo instanceof Bus));
		System.out.println("bongo instanceof ambulance : " 
					+ (bongo instanceof Ambulance));
		System.out.println();
		
		/* 아무리 상속 관계의 계층이 많아도 자식 타입의 참조 변수와 조상 클래스 타입을  
		 * instanceof 연산을 수행하면 자식 클래스가 상위의 모든 부모 클래스가 가진 
		 * 멤버를 포함하고 있기 때문에 true가 반환 된다.
		 **/
		System.out.println("ambulance instanceof Object : " 
					+ (ambulance instanceof Object));
	}
}

