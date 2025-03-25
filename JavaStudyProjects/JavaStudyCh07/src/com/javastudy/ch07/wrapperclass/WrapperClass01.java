package com.javastudy.ch07.wrapperclass;

// 오토박싱과 언박싱
public class WrapperClass01 {
	
	public static void main(String[] args) {
		
		/* Integer 클래스는 기본형인 int형 데이터를 객체로 다루어야 할 때 사용하는
		 * 클래스 이다. 자바에서 기본형 데이터를 객체로 저장하거나 메소드를 호출 할 때 
		 * 메소드의 인수로 객체 타입을 지정해야 할 경우가 있는데 이때 기본형 데이터를
		 * 감싸서 객체로 사용할 수 있도록 지원하는 클래스를 Wrapper 클래스라 한다.
		 * 
		 * 자바는 기본형 8개에 대해 Wrapper 클래스를 제공하고 있다.
		 * char형과 int형을 제외한 나머지는 기본 자료형 이름의 첫 글자를 대문자로
		 * 정의한 클래스로 예를 들어 byte -> Byte, boolean -> Boolean으로
		 * 정의되어 있다. char 형은 Character, int 형은 Integer로 정의되어 있다.
		 *
		 * 자바 1.5 이상에서는 오토박싱/언박싱을 지원하므로 add(x, y)가 호출되면
		 * 자동으로 Integer 타입으로 변환 된 후 Object 타입으로 업캐스팅 된다.
		 * 오토박싱(Autoboxing)은 기본형 데이터를 Wrapper 타입으로 자동
		 * 변환해 주는 것을 말하며 언박싱(Unboxing)은 그 반대의 개념이다. 
		 *
		 * Wrapper 타입의 변수에 기본형 데이터를 할당하게 되면 오토박싱에
		 * 의해서 new 연산자와 대입하는 값을 인수로 하는 생성자가 호출된다. 
		 * 아래는 Integer i = new Integer(100)으로 변경되어 실행된다.
		 **/
		Integer i = 100;
		
		/* 아래와 같이 Wrapper 타입의 데이터를 기본형 변수에 대입하면
		 * 자동으로 언박싱 되어 기본형 데이터로 변경된다. 
		 * 아래는 int x = i.intValue()와 같이 변경되어 실행된다.
		 **/
		int x = i;
		
		/* Integer 타입 변수 i에 int형 데이터 10을 감싸서 
		 * Integer 클래스의 인스턴스를 생성하고 그 참조 값을 i에 대입한다.
		 **/ 
		Integer j = new Integer(x);
		System.out.println(i + " : " + j);
		
		/* Wrapper 클래스 타입의 참조 변수 i와 j를 등가 비교하면
		 * i와 j는 서로 다른 인스턴스이므로 아래는 false가 출력된다.
		 **/
		System.out.println("i == j : " + (i == j));
		System.out.println();
		
		/* 모든 Wrapper 클래스는 그 인스턴스의 내부에서 감싸고 있는 
		 * 실제 값을 비교하는 equals() 메소드를 오버라이딩 하고 있다.
		 * 약간의 예외 사항이 있지만 Wrapper 클래스의 인스턴스가 감싸고
		 * 있는 내부의 값이 같은지를 비교할 때도 각 Wrapper 클래스에서
		 * 오버라이딩한 equals() 메소드를 사용해 내부의 값을 비교할 수 있다. 
		 **/
		System.out.println("i.equals(j) : " + i.equals(j));
		
		// 당연한 얘기겠지만 기본형은 equals() 메소드를 사용할 수 없다.
		//System.out.println(x.equals(y));
	}
}
