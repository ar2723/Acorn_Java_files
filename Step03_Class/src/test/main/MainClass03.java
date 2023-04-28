package test.main;

import test.mypac.Car;

public class MainClass03 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 사용하지 않고 버림
		//객체와 id값이 생성되었으나 변수안에 담기지 않은 상태로 바로 버려지기 때문에 아래의 코드를 garbage라고 한다.
		new Car();
		
		//Car 객체를 생성해서 1번 사용(객체 내 메소드를 호출)하고 버림 (객체를 1회용으로 사용)
		new Car().drive();
		
		//Car 객체를 생성해서 나온 참조값을 c1이라는 Car type 지역변수에 담아 놓고
		Car c1 = new Car();
		//이러한 지역 변수는 필요할 때마다 c1에 . 찍어서 여러번 사용할 수 있다.
		c1.drive();
		c1.drive();
		
		//아래 변수에는 drive() 메소드에 아무것도 리턴되지 않도록(void) 설계되어 있기 
		//때문에 변수에 아무것도 담을 수 없고 따라서 이 코드 자체가 성립하지 않게 된다.
		//Car c2 = new Car().drive();
	}
}
