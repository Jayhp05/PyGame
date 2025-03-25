package com.javastudy.ch07.objectclass;

// equals() 메서드를 재정의해 같은 정보를 가진 객체를 동일 객체로 체크하기
public class ObjectEquals02 {
	
	public static void main(String[] args) {
		
		/* 일반적으로 회원 아이디와 이름이 같으면 같은 사람이라 할 수 있다.
		 * 아래는 동일한 정보를 가지고 있는 Person01 클래스의 인스턴스이지만
		 * 실제로 인스턴스가 생성되는 주소가 다르기 때문에 서로 다른 객체가 된다.
		 * 실생활에서는 동일한 속성을 가지면 같은 사람이라고 판단해야 하는 경우가 있다.
		 * 예를 들면 주민번호와 이름이 같은 사람이면 동일한 사람이라고 보아야 한다.
		 * 아래와 같이 동일한 정보를 가지는 두 개의 인스턴스를 생성해서 동등 연산자로
		 * 비교하면 서로 다른 인스턴스이므로 false 값을 얻게되는데 이런 경우에는  
		 * 동일한 클래스로부터 생성된 서로 다른 인스턴스를 비교해서 특정 속성이 같을 경우
		 * true를 반환할 수 있도록 Object 클래스의 equals() 메서드를 오버라이딩 하면 된다.  
		 **/
		Person01 p1 = new Person01("midas", "홍길동");
		Person01 p2 = new Person01("midas", "홍길동");		
		
		/* 참조 변수의 동등연산(==)은 참조 변수에 저장된 참조 값을 비교한다.  
		 * 참조 변수의 참조 값을 비교하여 같으면 if문을 실행한다.
		 **/
		if(p1 == p2) {			
			System.out.println(p1 + " : " + p2 + "는 같은 객체입니다.");
			
		} else {
			System.out.println(p1 + " : " + p2 + "는 다른 객체입니다.");
		}
		
		/* Persion01 클래스에서 오버라이드된 equals() 메소드를 이용해 서로 다른
		 * 인스턴스라 할지라도 id와 name이 동일하면 if문 안의 코드가 실행된다.
		 **/ 
		if(p1.equals(p2)) {		
			
			/* Object hashCode() 메소드는 인스턴스의 주소 값을 이용해 
			 * 해시코드를 생성하므로 인스턴스마다 고유한 정수 값을 반환한다.
			 * 즉 서로 다른 인스턴스라면 해시코드 값은 다르게 반환된다.
			 **/
			System.out.println("p1과 p2의 해시코드값 비교 : " 
							+ p1.hashCode() + " : " + p2.hashCode());			
			System.out.println(p1 + " : " + p2 + "은 같은 사람입니다.");			
			
		} else {			
			System.out.println(p1.hashCode() + " : " + p2.hashCode());
			System.out.println(p1 + " : " + p2 + "은 다른 사람입니다.");
		}		
	}
}

// 상속받는 클래스가 없는 경우 컴파일러에 의해 Object 클래스를 상속받는다. 
class Person01 {
	
	String id;
	String name;
	
	public Person01(String id, String name) {
		this.id = id;
		this.name = name;		
	}
	
	// 아이디와 이름이 같으면 true를 반환하도록 Object 클래스의 equals()를 재정의 한다.
	@Override
	public boolean equals(Object obj) {
		
		/* 매개변수로 넘어온 인스턴스의 참조 값이 null이 아니고 Person01 타입으로
		 * 형 변환이 가능하면 Persion01로 형 변환한 후 현재 인스턴스의 id와 name을
		 * 매개변수로 넘어온 인스턴스의 id와 name과 비교하여 같으면 true를 반환한다.
		 * Persion01 클래스의 id와 name 필드는 String 객체 이므로 String 클래스에서
		 * 오버라이드된 equals()를 이용해 비교하게 된다. String 클래스의 equals()는
		 * 두 문자열을 문자 단위로 비교하여 같으면 true를 반환하도록 정의되어 있다.
		 **/
		if(obj != null && obj instanceof Person01) {			
			Person01 p = (Person01) obj;
			return this.id.equals(p.id) && name.equals(p.name);
		}
		
		return false;		
	}
	
	@Override
	public String toString() {		
		return name + "(" + id + ")";
	}
}
