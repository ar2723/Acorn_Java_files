package test.mypac;

public class MyUtil {
	//static 필드
	//아래의 경우 static 영역안에서 MyUtil class 객체 안에 version이라는 이름의 필드가 생성되고, 그 안에는 String type의 데이터가 들어있다.
	//static 필드에는 다른 객체의 참조값이 들어갈 수 있다.
	public static String version = "1.0.0";
	
	//static 메소드
	//아래의 경우 send() 메소드가 heap 영역에 만들어지는 것이 아니라 static 영역안에서 MyUtil class 객체 안에 만들어진다.
	//이러한 send() 메소드는 다른 클래스에서 중복 선언되거나 해서는 안된다.
	public static void send() {
		System.out.println("전송합니다.");
	}
	
	//new MyUtil().send(); -> heap 영역에 객체 선언 및 생성 이후 해당 객체 안의 메소드를 호출
	//MyUtil.send(); -> (static) 객체 선언 과정 없이 class안의 메소드를 바로 호출
}
