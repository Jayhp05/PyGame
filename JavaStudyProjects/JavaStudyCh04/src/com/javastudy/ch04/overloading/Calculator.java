package com.javastudy.ch04.overloading;

// 덧셈 계산기의 생성자 오버로딩과 메서드 오버로딩
public class Calculator {
	
	int x;
	int y;
	
	/* 오버로딩(Overloading)
	 * 오버로딩은 하나의 클래스 안에서 같은 이름을 가진 메서드를 여러 개 정의할
	 * 수 있는 것을 말한다. 오버로딩은 자바의 객체지향에서 다형성(Polymorphism)을
	 * 구현하는 방법 중 하나이며 생성자 오버로딩(Constructor Overloading)과
	 * 메서드 오버로딩(Method Overloading)이 있다.
	 * 다형성이란 하나의 객체가 여러 자료형을 가질 수 있는 성질을 의미하며 객체가 여러 
	 * 자료형을 가지므로 인해서 다양한 방식으로 동작할 수 있는 장점을 가질 수 있다.
	 * 오버로딩을 통해서 다형성이 구현된다는 것은 같은 이름을 가진 메서드를 여러 개
	 * 정의해서 이름은 하나이지만 다양한 기능을 구현할 수 있다는 것을 의미한다. 
	 * 다시 말해 오버로딩을 통해서 하나의 이름으로 다양한 기능을 제공하는 것을 의미한다.
	 **/
	
	/* 생성자 오버로딩(Constructor Overloading)
	 * 아래 생성자와 같이 하나의 클래스에 여러 개의 생성자를 정의하는 것을 생성자
	 * 오버로딩이라고 한다. 생성자에서 매개변수의 개수가 다르거나 매개변수의
	 * 타입이 다르면 생성자 오버로딩이 성립된다. 또한 매개변수의 개수가 같다
	 * 하더라도 매개변수의 순서에 따라 타입이 다르면 생성자 오버로딩이 성립된다.
	 **/
	public Calculator() {
		x = 10;
		y = 20;
	}
	
	public Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/* 메서드 오버로딩(Method Overloading)
	 * 아래 add() 메서드와 같이 하나의 클래스에 같은 이름을 가진 메서드를 여러 개
	 * 정의할 수 있는 것을 메서드 오버로딩이라 한다. 메서드의 반환 타입은 중요하지
	 * 않고 메서드에서 오직 매개변수의 개수가 다르거나 매개변수의 타입이 다르면
	 * 메서드 오버로딩이 성립된다. 또한 매개변수의 개수가 같다 하더라도 매개변수의
	 * 순서에 따라 타입이 다르면 메서드 오버로딩이 성립된다. 
	 **/
	public int add() {
		return x + y;
	}
	
	/* int 형 숫자 두 개를 입력 받아 두 수를 더하여 반환 하는 메서드
	 **/
	public int add(int x, int y) {
		return x + y;
	}

	// int 형 숫자 세 개를 입력 받아 모두 더하여 반환 하는 메서드
	public int add(int x, int y, int z) {
		return x + y + z;
	}
	
	// 실수 형 숫자 두 개를 입력 받아 두 수를 더하여 반환 하는 메서드
	public double add(double x, double y) {
		return x + y;
	}
	
	// 실수 형 숫자 세 개를 입력 받아 모두 더하여 반환 하는 메서드	
	public double add(double x, double y, double z) {
		return x + y + z;
	}
	
	/* 가변인수 메서드(Variable Argument)
	 * 가변인수로 정의된 메서드를 호출할 때 1개 이상의 인수를 지정할 수 있는
	 * 동적 인수 지정 방식으로 이 클래스에는 add() 메서드의 매개변수가 2개와 
	 * 3개짜리가 이미 선언되어 있기 때문에 add() 메서드를 호출할 때
	 * 1개의 인수를 지정하거나, 4개 이상 인수를 지정하여 호출할 때 이 가변인수
	 * 메서드가 호출된다. 메서드 인수의 개수에는 제한이 없다.  
	 **/
	public int add(int... nums) {
		int sum = 0;
		
		// 가변인수로 선언된 매개변수는 메서드 내부에서 배열처럼 접근할 수 있다.
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}	
}
