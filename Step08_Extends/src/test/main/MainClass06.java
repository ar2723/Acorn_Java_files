package test.main;

import test.mypac.AndroidPhone;
import test.mypac.HandPhone;

public class MainClass06 {
	public static void main(String[] args) {
		//자식에게 사준 일반 핸드폰(인터넷이 안됨)
		HandPhone p1 = new HandPhone();
		
		//엄마가 새로운 설명서를 가지고 왔어 이제 그 폰은 AndroidPhone이야
		AndroidPhone p2 = (AndroidPhone) p1; // casting 과정에서 ClassCastException이 발생한다.
		
		//객체 안에 기능이 없음에도 불구하고 사용설명서만 바뀐다고 해서 기능이 동작하는 것은 아니다.
		p2.doInternet();
	}
}
