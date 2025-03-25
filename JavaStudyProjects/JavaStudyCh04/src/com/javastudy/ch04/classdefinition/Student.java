package com.javastudy.ch04.classdefinition;

// 학생 정보를 다루는 클래스 정의하고 생성자를 이용해 인스턴스 맴버 초기화
public class Student {

	/* 속성(Property)을 private으로 선언해 외부로 부터 직접 접근을 차단(정보은닉)
	 * 
	 * 캡슐화(Encapsulation)는 객체가 독립적인 역할을 수행할 수 있도록 속성과 기능을
	 * 하나의 클래스로 묶어 관리하는 것을 말한다. 캡슐화를 통해서 객체가 가진 중요한 
	 * 속성과 기능은 외부에 노출되지 않도록 하고 꼭 필요한 속성과 기능만 외부에 노출할
	 * 수도 있다. 이렇게 실제 구현된 객체의 중요한 부분은 외부에 노출되지 않게 하고 필요한
	 * 부분만 외부에 노출 시키는 것을 정보은닉(Information Hiding)이라고 한다.
	 * 정보은닉은 접근 지정자(접근 제어자, Access Modifier)를 통해 적절한 제어 권한이
 	 * 있는 사용자에게만 객체 내부의 정보에 접근할 수 있도록 구현하는데 아래와 같이
	 * 객체의 속성이나 기능에 private을 적용하면 클래스 안에 구현된 내용을 외부에서
	 * 볼 수 없게 되며 객체가 필요에 의해서 외부로 노출하는 속성과 메서드를 통해서만
	 * 접근할 수 있도록 할 수 있다.
	 **/
	private String name;
	private int age;	
	
	/* 생성자의 이름은 클래스 이름과 같아야 하며 반환 타입은 지정하지 않는다.
	 * 아래와 같이 () 부분에 파라미터가 없는 것을 기본 생성자라고 한다.
	 **/
	public Student() {}	
	
	/* 인스턴스가 생성되면서 name 필드를 초기화 하는 생성자
	 * 생성자를 생성자 메서드라고도 부르며 생성자는 객체 생성 후에 그 객체의 초기화를
	 * 위해 사용된다. 외부로부터 입력된 값을 사용해 객체를 초기화 하려면 아래와 같이 
	 * 생성자의 () 부분에 필요한 타입의 변수를 선언하여 외부로부터 데이터를 받을 수 
	 * 있도록 생성자를 정의하면 된다. 이는 생성자 뿐만이 아니라 메서드도 외부로 부터 
	 * 입력된 값이 필요하다면 메서드의 () 부분에 필요한 데이터 타입의 변수를 선언해 
	 * 외부로부터 필요한 데이터를 입력 받을 수 있도록 메서드를 정의하면 된다.       
	 **/
	public Student(String name) {
		this.name = name;
	}	
	
	/* 인스턴스가 생성되면서 name과 age 필드를 초기화 하는 생성자
	 * 여러 생성자를 정의하는 것을 생성자 오버로딩(Overloading)이라고 한다. 
	 **/
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/* 정보 보호를 위해 외부에서 직접 접근하는 것을 차단한 속성(Property)에
	 * 접근할 수 있도록 다음과 같이 public의 getter와 setter 메서드를 제공 한다.
	 **/
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
}
