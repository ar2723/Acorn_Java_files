package test.main;

import test.util.MyUtil;

public class MainClass09 {
	public static void main(String[] args) {
		//static 메소드도 상속이 가능하다
		//상속 받은 BaseUtil 클래스에 정의된 static 메소드도 모두 사용가능
		MyUtil.light(); //MyUtil 클래스 static 메소드
		MyUtil.clear(); //상속받은 BaseUtil 클래스 static 메소드
		MyUtil.send();  //상속받은 BaseUtil 클래스 static 메소드
	}
}
