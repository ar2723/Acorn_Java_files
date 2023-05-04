package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;
import test.mypac.TVRemocon;
import test.mypac.YourRemocon;

public class MainClass02 {
	public static void main(String[] args) {
		//다형성 확인
		MyRemocon r1 = new MyRemocon();
		Remocon r2 = r1;
		Object r3 = r1;
		
		//직접 클래스를 test.mypac 패키지에 파일로 만들어서 useRemocon() 메소드를 여기서 호출해보세요.
		//새로운 클래스를 만드는 것은 인자에 전달할 객체를 미리 정하는 것이다.
		TVRemocon r4 = new TVRemocon();
		useRemocon(r4);
		r4.reserve(); // TVRemocon 클래스 메소드
		
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
		//만일 여기서 TVRemocon 클래스의 reserve() 메소드를 활용하고 싶으면 방법이 없을까?
		TVRemocon r2 = (TVRemocon)r; // casting 활용, r에 오는 값이 반드시 TVRemocon type이여야만 함.
		r2.reserve();
	}
}
