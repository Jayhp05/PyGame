package com.javastudy.ch08.generic;

// 제네릭 기법으로 설계된 클래스
public class GenericClassTest {

	public static void main(String[] args) {
				
	
		/* 제네릭을 사용하지 않을 경우
		 * 제네릭으로 으로 설계된 클래스라 하더라도 제네릭을 사용해 객체를 
		 * 생성하지 않으면 기본적으로 Object 타입으로 생성된다.
		 **/
		GenericClass test1 = new GenericClass();
				
		// 제네릭을 사용하지 않고 객체를 생성했기 때문에 Object 타입이다.
		test1.setType(new Integer(100));
		test1.setType("ObjectType");		
		
		// 제네릭을 사용하지 않았기 때문에 명시적으로 다운 캐스팅을 해야 한다.
		String s = (String) test1.getType();
		System.out.println(s);
		
		/* 제네릭을 사용하는 경우
		 * 변수를 선언 할 때 변수의 타입을 다이아몬드 연산자와 실제 사용할 클래스 타입을 
		 * 사용해 매개변수화 타입으로 "<Integer>"와 같이 선언하고 new 연산자를 이용해
		 * 객체를 생성하고 생성자를 호출할 때 생성자 이름 뒤에 다이아몬든 연산자와 실제
		 * 사용할 클래스의 타입을 지정해 타입 인수로 "<Integer>"와 같이 지정하면  
		 * 현재 인스턴스 안에서 사용되는 T의 타입이 Integer 타입으로 결정된다.
		 * 따라서 아래의 GenericClass 인스턴스에서는 T를 대체해서 Integer와 
		 * Integer 클래스를 상속하는 하위 클래스 타입의 객체들을 저장할 수 있다.
		 **/
		GenericClass<Integer> test = new GenericClass<Integer>();
		test.setType(123);

		// 제네릭을 사용했기 때문에 별도로 캐스팅이 필요없다.
		Integer i = test.getType();		
		System.out.println(i);
		
		/* 자바 1.7부터는 변수의 타입에 지정하는 매개변수화 타입만 지정하면
		 * 생성자를 호출하는 뒤쪽 부분은 컴파일러가 자동으로 타입 추론을 해 준다.
		 **/
		GenericClass<String> test2 = new GenericClass<>();
		test2.setType("StringType");
		System.out.println(test2.getType());
	}
}


/* 클래스를 정의할 때 클래스 이름 뒤에 다이아몬드 연산자와 타입 매개변수를
 * 이용해 "<T>"와 같이 지정하면 객체가 생성 될 때 타입이 결정되는 자료형의
 * 정보를 T로 대체해서 클래스를 정의할 수 있다.
 * 타입 매개변수의 이름은 일반적으로 대문자 한 문자를 사용해 이름을 지정한다.
 * 한 문자일 필요는 없지만 보편적으로 많이 사용하는 타입 매개변수는 아래와 같다.
 *
 * E : Element
 * K : Key
 * N : Number
 * T : Type
 * V : Value
 **/
class GenericClass<T> {
	
	// T의 실제 타입은 객체가 생성될 때 결정된다.
	private T type;
	
	public void setType(T type) {
		this.type = type;
	}	
	
	public T getType() {
		return type;
	}
}
