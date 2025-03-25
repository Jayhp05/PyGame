package com.javastudy.ch04.classdefinition;

//속성과 메서드를 가지는 클래스 정의하고 사용하기
public class AnimalUseExam01 {
	public static void main(String[] args) {

		/* new 연산자를 사용해 Animal01 클래스의 인스턴스를 생성하고 
		 * dog라는 변수에 인스턴스가 생성된 메모리 주소의 참조 값을 할당한다.
		 * 변수 dog는 인스턴스의 참조 값을 저장하는 변수로 참조형 변수가 된다.
		 *   
		 * name=null, age=0, sound=null, kind=null로 초기화됨 
		 **/
		Animal01 dog = new Animal01();
		
		// 참조형 변수 cheolSu를 이용해 인스턴스의 속성을 설정
		dog.name = "희망이";
		dog.age = 5;
		dog.sound = "멍멍";
		dog.kind = "강아지";
		dog.eat();
		
		/* sleep() 메서드를 호출하면서 메서드의 인수로 "희망이2"를 지정하고 있다.
		 * 메서드를 정의하거나 사용하면서 매개변수(Parameter)와 인수(Argument)라는
		 * 용어를 사용하게 되는데 이 용어는 메서드 사용에서 혼용되어 사용되는 경우가 많다.
		 * 매개변수(Parameter)는 외부에서 메서드 안으로 전달되는 값을 저장하는 변수를
		 * 의미하며 인수(Argument)는 메서드를 호출할 때 메서드에 입력되는 값을 의미 한다.
		 **/
		dog.sleep("희망이2");		
		dog.cry("강아지", "왈왈");
		System.out.println(dog);
		System.out.println();		
		
		Animal01 cat = new Animal01();
		cat.name = "야옹이";
		cat.age = 4;
		cat.sound ="야옹야옹";
		cat.kind = "고양이";
		cat.eat();
		cat.sleep("나비");		
		cat.cry("고양이", "야옹");
		System.out.println(cat);
		System.out.println();
	}
}
