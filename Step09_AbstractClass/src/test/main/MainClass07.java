package test.main;

import test.mypac.Car;

public class MainClass07 {
	public static void main(String[] args) {
		//개발자가 코딩하는 위치
		
		useCar(new Car() { // 익명 로컬 내부 클래스 -> Car 클래스 상속
			//조금 더 빨리 달릴 수는 없을까?
			@Override
			public void drive() {
				System.out.println("더 빠르게 달려요!~");
			}
		});
		
	}
	
	//누군가 미리 만들어 놓은 메소드
	public static void useCar(Car c) {
		c.drive();
		c.drive();
	}
}
