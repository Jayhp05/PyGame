package com.javastudy.ch05.nopolymophism3.controller;

import com.javastudy.ch05.nopolymophism3.service.BoardDetailService;
import com.javastudy.ch05.nopolymophism3.service.BoardListService;
import com.javastudy.ch05.nopolymophism3.service.BoardWriteService;
import com.javastudy.ch05.nopolymophism3.service.DeleteService;
import com.javastudy.ch05.nopolymophism3.service.LoginFormService;
import com.javastudy.ch05.nopolymophism3.service.LoginService;
import com.javastudy.ch05.nopolymophism3.service.LogoutService;
import com.javastudy.ch05.nopolymophism3.service.UpdateFormService;
import com.javastudy.ch05.nopolymophism3.service.UpdateService;
import com.javastudy.ch05.nopolymophism3.service.WriteFormService;

// 상속을 사용하지 않고 서비스 클래스를 사용해 요청 명령을 처리하는 클래스
public class NoPolyController {
	
	// 매개 변수로 받은 명령을 처리할 서비스 클래스의 인스턴스를 실행하는 메서드
	public void doProcess(String cmd) {
		
		/* 요청 처리 결과를 저장할 변수
		 **/
		String result = null;
		
		/* 요청 명령을 비교해 그 명령을 처리할 서비스 클래스를 결정하여
		 * 인스턴스를 생성하고 요청을 처리할 메서드를 호출해 요청을 처리한다.
		 **/
		if(cmd.equals("boardList")
				|| cmd.equals("index")) {
				
			/* 게시 글 리스트 보기를 요청한 경우 BoardListService 
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 게시 글 리스트 보기에 대한 요청을 처리 한다.
			 **/
			BoardListService service = new BoardListService();
			result = service.requestProcess();
			
		} else if(cmd.equals("boardDetail")) {
			
			/* 게시 글 상세보기가 요청된 경우 BoardDetailService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 게시 글 상세보기에 대한 요청을 처리 한다.
			 **/
			BoardDetailService service = new BoardDetailService();
			result = service.requestProcess();
			
		} else if (cmd.equals("writeForm")) {

			/* 게시 글쓰기 폼을 요청한 경우 WriteFormService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 게시 글쓰기 폼에 대한 요청을 처리 한다.
			 **/
			WriteFormService service = new WriteFormService();
			result = service.requestProcess();
			
		} else if(cmd.equals("writeProcess")) {
			
			/* 게시 글쓰기 완료를 요청한 경우 BoardWriteService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 게시 글쓰기 완료에 대한 요청을 처리 한다.
			 **/
			BoardWriteService service = new BoardWriteService();
			result = service.requestProcess();
			
		} else if(cmd.equals("updateForm")) {
			
			/* 게시 글 수정 폼을 요청한 경우 UpdateFormService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 게시 글 수정 폼에 대한 요청을 처리 한다.
			 **/
			UpdateFormService service = new UpdateFormService();
			result = service.requestProcess();
			
		} else if(cmd.equals("updateProcess")) {
			
			/* 게시 글 수정 완료를 요청한 경우 UpdateService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 게시 글 수정 완료에 대한 요청을 처리 한다.
			 **/
			UpdateService service = new UpdateService();
			result = service.requestProcess();
			
		} else if(cmd.equals("deleteProcess")) {
			
			/* 게시 글 삭제하기를 요청한 경우 DeleteService 
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 게시 글 삭제하기에 대한 요청을 처리 한다.
			 **/
			DeleteService service = new DeleteService();
			result = service.requestProcess();
			
		} else if(cmd.equals("loginForm")) {

			/* 로그인 폼을 요청한 경우 LoginFormService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 로그인 폼에 대한 요청을 처리 한다.
			 **/
			LoginFormService service = new LoginFormService();
			result = service.requestProcess(); 
			
		} else if(cmd.equals("login")) {

			/* 로그인 완료를 요청한 경우 LoginService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 로그인 완료에 대한 요청을 처리 한다.
			 **/
			LoginService service = new LoginService();
			result = service.requestProcess();
			
		} else if(cmd.equals("logout")) {
			
			/* 로그아웃을 요청한 경우 LogoutService
			 * 클래스의 인스턴스를 생성하고 requestProcess()를
			 * 호출하여 로그아웃에 대한 요청을 처리 한다.
			 **/
			LogoutService service = new LogoutService();
			result = service.requestProcess();
			
		}
		/* if 문을 이용한 방식은 새로운 명령이 수정되거나 추가될 때 마다 
		 * else if 문을 수정 또는 계속해서 추가해야 하므로 좋은 방식은 못 된다.
		 **/
		else {
			result = "명령을 잘 못 입력했습니다.";
		}
		
		System.err.println(result);
	}
}
