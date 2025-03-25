package com.javastudy.ch02.datatype;

// 정수형 변수 간의 할당
public class IntNum03 {
	public static void main(String[] args) {
		
		int intNum01 = 30;		
		long longNum01 = 100L;		
		
		/* 큰 데이터 형으로 정의된 변수를 작은 데이터 형의 변수에 할당하는 것은 큰 수를
		 * 작은 그릇에 담는 것이므로 명시적으로 형 변환이 필요하다. 이렇게 작은 그릇에  
		 * 큰 수를 담기 위해서 수의 크기를 작게 조절할 필요가 있기 때문에 작은 쪽으로 
		 * 형 변환하라고 명시적으로 알려줘야 한다. 이렇게 작은 쪽으로 데이터 형을 변환하는
		 * 것을 명시적 형 변환 또는 강제 형 변환이라고 한다. 강제로 형 변환을 하게 되면 
		 * 본래의 수가 손실될 수도 있다.
		 **/
		// int intNum02 = longNum01; // 오류 발생
		int intNum02 = (int)longNum01;
		
		/* 작은 데이터 형으로 정의된 변수를 큰 데이터 형의 변수에 할당할 때는 작은 수를
		 * 큰 그릇에 담는 것이므로 문제되지 않으며 자동으로 형 변환 된다. 이렇게 자동으로
		 * 형 변환되는 것을 자동 형 변환 또는 묵시적 형 변환이라고 한다.
		 **/
		long longNum02 = intNum01;

		/* long형 데이터와 int형 데이터의 곱셈 연산
		 * long형 데이터와 int형 데이터를 연산하면 먼저 두 변수의 형을 동일하게 맞추고 
		 * 연산을 하게 되는데 이 때 int형 변수를 long형으로 형 변환 한 후 두 수를 곱셈한다.
		 * 즉 큰 데이터 형과 작은 데이터 형을 연산하게 되면 두 수의 형을 맞추기 위해 작은 
		 * 데이터 형을 큰 데이터 형으로 자동 형 변환 한 후 연산을 하게 된다.
		 **/	
		long multipleNum = longNum01 * intNum01;
		
		// long형과 int형을 곱셈한 결과를 콘솔에 출력		
		System.out.println("longNum01 * intNum01 = " + multipleNum);
		
		// long형 데이터와 int형 데이터를 나눗셈하여 결과를 콘솔 출력 
		System.out.println("longNum01 / intNum01 = " + longNum01 / intNum01);
	}
}
