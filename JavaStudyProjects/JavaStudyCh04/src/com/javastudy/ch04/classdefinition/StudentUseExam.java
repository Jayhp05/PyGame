package com.javastudy.ch04.classdefinition;

// 학생 정보를 다루는 클래스 정의하고 생성자를 이용해 인스턴스 맴버 초기화
public class StudentUseExam {
	
	public static void main(String[] args) {
		
		/* 클래스를 통해서 아래와 같이 여러 개의 객체를 생성할 수 있어서 클래스를 객체의
		 * 설계도 또는 객체를 찍어 내듯이 여러 개 생성할 수 있어서 객체의 틀이라고 한다.
		 *
		 * 클래스를 통해 메모리에 실제 만들어지는 하나하나의 객체를 클래스의 인스턴스라고
		 * 부르며 인스턴스는 클래스를 통해 실제 메모리에 실체화된 객체를 의미하는 용어이다. 
		 * 		
		 * 기본 생성자를 이용해 Student 클래스의 인스턴스 생성
		 * new 연산자로 Student 클래스의 인스턴스가 생성되고 기본 생성자에 의해 초기화
		 * 된다. 초기 값을 지정하지 않았기 때문에 각 필드의 데이터 타입에 따라 기본 값으로
		 * 초기화 된다. 
		 * name = null, age = 0으로 초기화 된다.
		 **/
		Student s1 = new Student();
		
		/* 이름을 설정할 수 있는 생성자를 이용해 Student 클래스의 인스턴스 생성
		 * new 연산자로 Student 클래스의 인스턴스가 생성되고 name은 생성자의 인수에
		 * 지정한 값으로 초기화 되고 age는 기본 값으로 초기화 된다.
		 * name = "이순신", age = 0으로 초기화 된다.
		 **/
		Student s2 = new Student("이순신");
		
		/* 이름과 나이를 설정할 수 있는 생성자를 이용해 Student 클래스의 인스턴스 생성
		 * new 연사자로 Student 클래스의 인스턴스가 생성되고 name과 age는 생성자의
		 * 인수에 지정한 값으로 초기화 된다.
		 * name="홍길동", age = 17로 초기화 된다.		 
		 **/
		Student s3 = new Student("홍길동", 17);
		
		/* 위에서 생성한 Student 클래스의 각 인스턴스가 가지고 있는 속성(Property) 값을
		 * getter 메소드를 사용해 출력할 수 있다. Student 클래스의 속성은 모두 private으로
		 * 선언되어 있으므로 참조 변수를 통해 직접 접근할 수 없고 setter와 getter 메서드를
		 * 통해서 데이터를 설정하거나 현재 객체가 가지고 있는 데이터를 읽어올 수 있다.
		 **/
		System.out.printf("첫 번째 학생 - 이름 : %s, 나이 %s\n", s1.getName(), s1.getAge());
		System.out.printf("두 번째 학생 - 이름 : %s, 나이 %s\n", s2.getName(), s2.getAge());
		System.out.printf("세 번째 학생 - 이름 : %s, 나이 %s\n", s3.getName(), s3.getAge());
	}
}
