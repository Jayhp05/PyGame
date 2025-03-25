package com.javastudy.ch04.classdefinition;

// 시간 정보를 저장하는 클래스 정의하고 사용하기
public class TimeUseExam {
	
	public static void main(String[] args) {
		
		/* Time 클래스를 정의해 사용하면 시, 분, 초에 대한 시간 데이터를 하나로 묶어서
		 * 데이터 타입으로 관리할 수 있으므로 시간 데이터가 뒤섞일 염려가 없어진다. 또한
		 * 새로운 시간 데이터가 더 필요하면 Time 클래스의 객체를 생성해 얼마든지 새로운
		 * 시간 데이터로 사용할 수 있기 때문에 시간 데이터를 위해서 매번 새로운 변수를
		 * 여러 개 만들어야 하는 불필요한 작업이 필요 없으며 이미 만들어 놓은 클래스의
		 * 코드를 재사용하므로 코드의 중복을 줄이고 재사용성을 높일 수 있다는 장점이 있다.   
		 **/
		Time time = new Time();
		time.hour = 12;
		time.minute = 27;
		time.second = 58;
		System.out.println("Time 클래스 현재 시간 : " 
				+ time.hour + "시 " + time.minute + "분 " + time.second + "초");
		
		/* Time 클래스 타입의 배열을 사용하면
		 * 여러 시간 데이터를 하나로 묶어서 관리할 수 있어서 편리하다.
		 **/
		Time[] times = new Time[2];
		times[0] = new Time();		
		times[0].hour = 14;
		times[0].minute = 38;
		times[0].second = 29;
		
		times[1] = new Time();
		times[1].hour = 11;
		times[1].minute = 58;
		times[1].second = 59;
		
		for(int i = 0; i < times.length; i++) {
			System.out.println("Time 클래스 현재 시간 : " + times[i].hour + "시 " 
					+ times[i].minute + "분 " + times[i].second + "초");
		}
	}
}
