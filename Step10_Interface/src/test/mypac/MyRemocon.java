package test.mypac;
/*
 * 인터페이스를 implements 하면 인터페이스에 정의 되어 있는 모든 추상메소드를 오버라이드 해야한다 (강제)
 * 데이터 타입을 interface로 받게 되면 interface에 등록되어 있는 메소드와 필드만 사용할 수 있게 된다.
 */
public class MyRemocon implements Remocon {

	@Override
	public void up() {
		System.out.println("채널을 올려요");
	}

	@Override
	public void down() {
		System.out.println("채널을 내려요");
	}

}
