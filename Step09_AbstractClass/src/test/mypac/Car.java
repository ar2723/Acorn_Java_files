package test.mypac;

//누군가 미리 만들어 놓은 Util 클래스
//아래 클래스 선언에서 final을 집어 넣으면 다른 클래스에서 상속이나 오버라이드가 불가능해진다.
public class Car {
	public void drive() {
		System.out.println("달려요!");
	}
}
