package com.javastudy.ch04.member;

// 클래스 맴버와 인스턴스 맴버
public class Employee {
	
	/* 사번의 기준이 되는 코드 - 회사의 이니셜을 사용하도록 만듦
	 * 회사의 이니셜은 모든 사원의 사번에 공통으로 적용해야 되므로 static으로 선언함
	 * 예 : 삼성(SAM_), 엘지(LG_) 등
	 * 
	 * Employee 클래스가 처음 사용될 때 이 클래스의 정보는 JVM의 메모리 공간 중 
	 * Method Area라는 메모리 공간으로 로딩되는데 이 때 static이 붙은 변수와
	 * 메서드도 클래스를 따라서 같이 로딩된다. 그래서 static이 붙은 변수와 메서드를
	 * 클래스 맴버라고 부른다. 아래의 baseCode는 static이 붙은 맴버 변수이므로
	 * 클래스 맴버 변수라고 부르며 static 메서드를 클래스 맴버 메서드라고 부른다.
	 * 
	 * 클래스 정보는 그 클래스가 사용될 때 단 한 번만 메모리에 로딩되며 static 변수는
	 * 클래스를 따라 생성되기 때문에 클래스가 로딩될 때 단 하나만 생성된다. static
	 * 변수는 클래스를 따라서 하나만 생성되기 때문에 여러 인스턴스에서 하나의 static
	 * 변수를 참조하게 된다. 그러므로 static 변수는 여러 인스턴스에서 공용으로 사용하는
	 * 공유 변수라고 할 수 있다.
	 **/
	public static String baseCode = "SM_";
	
	/* static 예약어(키워드)가 붙지 않은 맴버 변수를 인스턴스 맴버 변수라고 부른다. 
	 * 이는 새로운 인스턴스가 JVM의 Heap 이라는 영역에 생성될 때 마다 인스턴스를 따라서
	 * 생성되기 때문에 인스턴스 맴버라고 부른다. 인스턴스 맴버 변수는 각각의 인스턴스 별로
	 * 생성되기 때문에 각각의 인스턴스가 현재 가지고 있는 데이터를 저장하는 속성이다.
	 * 
	 * static이 붙지 않은 맴버 메서드를 인스턴스 맴버 메서드라고 부른다.
	 * 인스턴스 맴버 메서드는 인스턴스 맴버 변수와 다르게 인스턴스를 따라서 Heap 영역에
	 * 생성되는 것이 아니라 Method Area에 생성된다. 메서드는 특정 명령을 실행하는
	 * 명령의 집합으로 인스턴스가 달라도 동일한 기능을 수행하기 때문에 인스턴스 마다
	 * 새롭게 생성할 필요가 없고 클래스 별로 구분해 저장하면 인스턴스에서 사용할 수 있다.
	 **/
	public String sabun;
	public String name;
	public String gender;
	public int age;
	
	public Employee(String serialNo, String name, String gender, int age) {
		// 사번의 기준이 되는 번호인 년도와 매개변수로 넘겨받은 값을 조합해 사번을 만듦
		this.sabun = baseCode + serialNo;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
}
