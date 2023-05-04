package test.main;

import test.mypac.AndroidPhone;
import test.mypac.HandPhone;

public class MainClass05 {
	public static void main(String[] args) {
		//AndroidPhone 객체를 생성해서 참조값을 AndroidPhone type p1 이라는 지역 변수에 담기
		//하나의 사물함 안에 3개의 객체가 동시에 만들어져서 접근이 가능해진다.
		AndroidPhone p1 = new AndroidPhone();
		HandPhone p2 = new AndroidPhone();
		//메소드 호출해보기
		p1.call();		   //Phone 객체의 기능
		p1.mobileCall();   //Handphone 객체의 기능
		p1.takePicture();  //Handphone 객체의 기능이었지만 오버라이드 됨
		//한번 오버라이드 된 상태에서 AndroidPhone 객체를 다른 타입에 담을 경우 데이터 타입과 상관없이 무조건 AndroidPhone 객체의 기능으로 호출된다.
		//만약에 오버라이드 된 상태에서 Handphone 객체의 기능을 불러오려면 super 예약어를 쓰면 된다.
		p1.doInternet();   //AndroidPhone 객체의 기능
		p1.showPlatform(); //AndroidPhone 객체의 기능
		p2.takePicture();
	}
}
