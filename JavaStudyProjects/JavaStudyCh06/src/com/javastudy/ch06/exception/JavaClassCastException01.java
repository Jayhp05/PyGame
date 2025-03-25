package com.javastudy.ch06.exception;


// 다운 캐스팅할 때 발생할 수 있는 ClassCastException 예외 처리하기
public class JavaClassCastException01 {
	
	public static void main(String[] args) {
		
		Parent c1 = new Child01();
		Parent c2 = new Child02();
		Child01 c3 = null;
		
		try {			
			/* Child01, Child02 클래스는 모두 Parent 클래스를 상속 받은 형제 
			 * 클래스이지만 서로 형 변환은 불가능 하기 때문에 ClassCastException이
			 * 발생하게 된다. 다운 캐스팅시 instanceof 연산자를 사용해 형 변환 가능
			 * 여부를 체크한 후 캐스팅을 시도하는 것이 바람직한 코딩 기법이다. 
			 * if(c2 instanceof Child01) 문은 false 이므로 예외가 발생하지 않고
			 * 다음 코드로 실행 흐름이 이동된다.
			 **/			
			 if(c2 instanceof Child01) {
			 		c3 = (Child01) c2;			 		
			 } 
			 System.out.println("c2 instanceof Child01 실행됨");
			 
			/* Child01 타입의 참조 변수를 Child02 타입으로 형 변환을 시도하면 
			 * ClassCastException이 발생하고 실행 흐름이 catch 블럭으로 이동하여
			 * "c3 = (Child01) c2 실행됨"은 콘솔에 출력되지 못하게 된다.
			 **/
			c3 = (Child01) c2;
			System.out.println("c3 = (Child01) c2 실행됨");
			
		} catch(ClassCastException e) {			
			System.out.println(e.getMessage());
		}		
		System.out.println(c3 == null ? "참조하는 객체가 없는 변수" : c3);
	}	
}

class Parent { }
class Child01 extends Parent { }
class Child02 extends Parent { }
