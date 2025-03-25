package com.javastudy.ch07.objectclass;

// clone() 메소드로 객체 복사하기
public class ObjectClone01 {
	
	public static void main(String[] args) {
		
		Student originStudent = new Student("홍길동", 25);
		
		/* clone() 메소드는 자기 자신을 복제하여 새로운 인스턴스를 생성하여 반환한다.
		 * Object 타입을 반환하므로 다운 캐스팅이 필요하다.
		 **/
		Student copyStudent = (Student) originStudent.clone();
		
		/* 원본의 name을 변경해도 같은 인스턴스가 아니므로 copy 본의
		 * name은 변경되지 않는다. 기본형과 String 타입의 멤버 변수는
		 * 제대로 복제가 이루어지지만 참조 타입 멤버 변수는 참조 값이 
		 * 복사되므로 완전한 복제가 이루어지지 않는다.
		 **/
		originStudent.setName("이순신");
		originStudent.setAge(28);
		
		System.out.println("originStudent : " + originStudent);		
		System.out.println("copyStudent : " + copyStudent);
		
		// originStudent와 copyStudent가 같은 인스턴스인지 비교하고 있다.
		System.out.println("originStudent.equals(copyStudent) : " 
				+ originStudent.equals(copyStudent));		
	}
}

/* clone()를 사용하기 위해서는 Cloneable 인터페이스를 반드시 구현해야 한다.
 * Cloneable을 구현하지 않으면 CloneNotSupportedException이 발생한다.
 * Cloneable 인터페이스는 구현해야 할 추상 메소드가 없는 마커 인터페이스 이다.
 * 마커 인터페이스란 추상 메소드는 갖고 있지 않지만 이 마커 인터페이스를 구현하게 
 * 되면 어떤 기능을 제공할 지의 여부를 판단하기 위해 정의된 인터페이스를 말한다.
 **/
class Student implements Cloneable {
	
	private String name;
	private int age;	
	
	public Student(String name, int age) {		
		this.name = name;
		this.age = age;		
	}
	
	public String getName() {
		return name;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {		
		return name + "(" + age + ")";
	}
	
	/* Object 클래스의 clone() 메소드는 protected 접근 제어자로 선언되었다.
	 * 어디에서든 접근할 수 있는 public 접근 제어자로 사용하기 위해 재정의했다.
	 **/
	@Override
	public Object clone() {
		
		Object obj = null;	
		
		try {
			
			/* 오버라이드 하는 자식의 clone() 메소드 안에서 부모 클래스인 
			 * Object 클래스의 clone() 메소드를 이용해 자신을 복제한다.
			 **/
			obj = super.clone();
			
		} catch(CloneNotSupportedException e) {
			System.out.println("Cloneable이 구현되지 않은 인스턴스");
			e.printStackTrace();
		}
		
		// 복제한 새로운 인스턴스를 반환한다.
		return obj;
	}
}




