package com.javastudy.ch05.polymorphism;

import com.javastudy.ch05.interfaceclass.MobilePhone;
import com.javastudy.ch05.interfaceclass.Phone;

public class InterfaceTest {

	public static void main(String[] args) {
		
		Phone p = new SubPhone("subPhone");
		p.sendPhone();
		
		// default 메소드는 접근 지정자가 기본적으로 public이 된다.
		p.power("테스트");
		MobilePhone.resetEnabled();
	}
}


class SubPhone implements Phone, MobilePhone {
	
	String name;
	
	public SubPhone(String name) {
		this.name = name;
	}

	@Override
	public void sendPhone() {
		this.power(this.name);		
	}

	@Override
	public void receivePhone() {
		this.power(this.name);	
	}

	@Override
	public void sendSMS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveSMS() {
		// TODO Auto-generated method stub
		
	}
	
}