package com.javastudy.ch04.member;

//클래스 맴버 변수와 인스턴스 맴버 변수
public class EmployeeUseExam {

	public static void main(String[] args) {
		
		// baseCode는 클래스 맴버이므로 인스턴스 생성 없이 클래스 명으로 바로 접근이 가능함
		System.out.println("사번의 기준 번호 : " + Employee.baseCode);
		
		/* new 연산자를 사용해 Employee 클래스의 인스턴스를 생성하고 생성자를
		 * 이용해 인스턴스를 초기화 한 후 변수 emp01에 참조 값을 할당하고 있다.		
		 **/
		Employee emp01 = new Employee("2020005", "홍길동", "남성", 28);				
		
		// 인스턴스 맴버는 반드시 인스턴스를 생성한 후에 접근이 가능
		System.out.println("emp01의 사번 : " + emp01.sabun);
		System.out.println("emp01의 이름 : " + emp01.name);
		
		// 인스턴스 변수로 클래스 멤버에 접근은 가능하나 클래스 명을 사용하는 것이 정석이다.
		System.out.println("emp01 사번의 기준 코드 : " + emp01.baseCode);
		System.out.println();
		
		/* new 연산자를 사용해 Employee 클래스의 인스턴스를 생성하고 생성자를
		 * 이용해 인스턴스를 초기화 한 후 변수 emp02에 참조 값을 할당하고 있다.		
		 **/
		Employee emp02 = new Employee("5032150", "어머나", "여성", 27);

		// 인스턴스 맴버는 반드시 인스턴스를 생성한 후에 접근이 가능하다.
		System.out.println("emp02의 성별 : " + emp01.gender);
		System.out.println("emp02의 나이 : " + emp01.age);
		
		// 인스턴스 변수로 클래스 멤버에 접근은 가능하나 클래스 명을 사용하는 것이 정석이다.
		System.out.println("emp02 사번의 기준 코드 : " + Employee.baseCode);		
		System.out.println();
		
		/* 클래스 정보는 그 클래스가 사용될 때 단 한 번만 메모리에 로딩되며 static 변수는
		 * 클래스를 따라 생성되기 때문에 클래스가 로딩될 때 단 하나만 생성된다. static
		 * 변수는 클래스를 따라서 하나만 생성되기 때문에 여러 인스턴스에서 하나의 static
		 * 변수를 참조하게 된다. 그러므로 static 변수는 여러 인스턴스에서 공용으로 사용하는
		 * 공유 변수라고 할 수 있다.
		 **/
		emp02.baseCode = "TM_";
		
		/* 위에서 baseCode 값을 변경 했으므로 emp01 인스턴스가 참조하는
		 * baseCode 값도 "SM_"에서 "TM_"로 변경된 것을 확인 할 수 있다. 
		 **/
		System.out.println("emp01 사번의 기준 코드 : " + emp01.baseCode);
		System.out.println("emp02 사번의 기준 코드 : " + emp02.baseCode);
	}
}
