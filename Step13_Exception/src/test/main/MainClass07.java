package test.main;

import test.mypac.MyUtil;

public class MainClass07 {
	public static void main(String[] args) {
		
		//메소드 안에서 발생하는 예외를 직접 처리한 draw() 메소드 호출
		MyUtil.draw();
		
		//메소드 안에서 발생하는 예외를 (밖으로) throws 한 send() 메소드 호출
		//호출하는 쪽에서 예외 처리
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
