package com.javastudy.ch05.inheritance;

// 클래스 상속하기 - 상속받는 자식 클래스
/* 자바에서 다른 클래스를 상속받기 위해서는 아래와 같이 클래스 선언부에
 * extends 키워드를 사용해 상속받을 클래스 이름을 지정하면 된다. 
 * 
 *		public class 클래스 이름 extends 상속받을 클래스 이름
 * 
 * 상속하는 클래스를 부모 클래스, 기반 클래스, 상위 클래스 등으로 부르며  
 * 상속받는 클래스를 자식 클래스, 서브 클래스, 하위 클래스 등으로 부른다.
 * 아래 SmartTv 클래스와 같이 extends 키워드를 사용해 Tv 클래스를 상속 받으면
 * 부모 클래스인 Tv 클래스가 가지고 있는 모든 속성(필드)과 모든 기능(메서드)을
 * 자식 클래스인 SmartTv 클래스에서 자신의 것과 마찬가지로 사용할 수 있게 된다.
 * 
 * 부모 클래스인 Tv 클래스와 자식 클래스인 SmartTv 클래스를 상속 관계가
 * 아닌 각각 개별적인 클래스로 작성하면 SmartTv 클래스에서는 Tv 기능을
 * 구현하기 위해서 Tv 클래스에 있는 동일한 코드를 다시 한 번 작성해야 한다.  
 * 이렇게 각각 Tv 클래스와 SmartTv 클래스에서 필요한 Tv 기능을 구현하기
 * 위해서 동일한 코드의 중복이 발생하게 된다. 코드의 중복은 에러율을 높이고
 * 유지보수 등의 작업을 어렵게 만들게 되므로 결국에는 소프트웨어 개발과
 * 유지보수 비용을 증가시키는 원인이 된다. 하지만 상속을 활용하면 코드의
 * 중복을 최소화 하고 재사용성을 높일 수 있는 효율적인 프로그래밍을 할 수 있다.
 **/
// Tv 클래스를 상속 받아서 SmartTv의 속성과 동작을 정의한 클래스
public class SmartTv extends Tv {
		
	boolean isInternet;
	
	/* 아래는 부모 클래스인 Tv 클래스로부터 상속 받은 power() 메서드를 자식인
	 * SmartTv 클래스에서 다시 정의 하고 있는데 이렇게 상속 받은 메서드를
	 * 자식이 자신에 맞게 다시 정의하는 것을 메서드 재 정의라고 하며 이런 
	 * 객체지향 기법을 메서드 오버라이딩(Method Overriding) 이라고 부른다.
	 **/
	@Override
	public void power() {
		power = !power;
		if(power) {
			isInternet = true;
		}
	}
	
	public SmartTv() {
		
		/* Object 클래스를 제외하고 자바의 모든 클래스의 생성자는 첫 줄에
		 * 자신의 다른 생성자 또는 조상의 생성자를 호출해야 한다. 그렇지 않으면
		 * 컴파일러에 의해서 모든 생성자의 첫 줄에 부모 클래스의 기본 생성자를
		 * 호출하는 super() 코드가 자동으로 추가된다. super()는 부모 클래스의
		 * 기본 생성자를 호출하는 코드로써 자식 클래스의 생성자 안에서만 호출
		 * 할 수 있으며 항상 생성자의 첫 줄에 작성되어야 한다.
		 **/
		this("기본 생성자 TV");
		//super("기본생성자 TV");
	}
	
	public SmartTv(String name) {
		super(name);
	}
	
	public void internet() {		
		if(isInternet) {
			System.out.println("요청 사이트로 이동 중...");
		} else {
			System.out.println("인터넷 연결을 확인해주세요");
		}
	}
	
	public void movieInfo() {
		System.out.println("요청한 영화정보 검색 중...");
	}
}