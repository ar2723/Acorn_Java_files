package test.main;

import test.mypac.MyUtil;

public class MainClass06 {
	public static void main(String[] args) {
		//MyUtil 클래스의 send() 메소드 호출해보기
		MyUtil.send();
		//MyUtil 클래스의 version 필드 참조해보기
		String v = MyUtil.version;
		
		//static 영역의 System class안에 out (public static PrintStream out)이라는 명칭의 필드가 존재하고, 
		//이 필드에는 PrintStream data type 객체의 참조값이 담겨있다.
		//이 참조값을 통해 참조하는 객체 안에 println(){}의 메소드가 존재한다.
		System.out.println("오잉?");
		//현재 시간을 mili second 단위로 얻어내기
		long time = System.currentTimeMillis();
		System.out.println(time);
	}
}
