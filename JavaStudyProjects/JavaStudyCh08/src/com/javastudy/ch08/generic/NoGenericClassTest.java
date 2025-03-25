package com.javastudy.ch08.generic;

// 제네릭 기법을 사용하지 않는 클래스
public class NoGenericClassTest {
	public static void main(String[] args) {

		NoGenericClass test = new NoGenericClass();
		test.setObj(new String("ObjectType"));
		
		/* 데이터를 설정하는 setter에서 Object로 업캐스팅 되었기 때문에
		 * 데이터를 가져올 때는 다운캐스팅을 해야 본래 클래스의 메서드를 
		 * 사용할 수 있게 된다. 아래의 String 클래스와 Integer 클래스는
		 * toString() 메서드를 오버라이딩 했기 때문에 다운 캐스팅 하지
		 * 않아도 객체에 저장된 내용물은 출력할 수 있지만 String 클래스와
		 * Integer 클래스가 지원하는 메서드는 사용할 수 없게 된다.   
		 **/		    
		String str = (String) test.getObj();		
		System.out.println(str);
		test.setObj(1);
		int i =  (Integer) test.getObj();
		System.out.println(i);
		
	}
}


class NoGenericClass {
	
	private Object obj;
	
	/* 제네릭 개념이 나오기 이전에는 여러 타입을 클래스 내부에서 사용하기
	 * 위해서는 메서드의 파라미터를 Object 타입으로 설정하던지 아니면
	 * 상속관계를 만들어 상위 클래스 타입을 매개변수로 설정해야 했었다. 
	 **/ 
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return obj;
	}
}