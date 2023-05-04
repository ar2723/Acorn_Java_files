package test.main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * Car 클래스는 default 생성자가 없고
		 * Engine type의 참조값을 전달해야지만 호출되는 생성자를 가지고 있기 때문에
		 * Car 객체를 생성하기 위해서는 반드시 Engine 객체의 참조값을 전달해주어야 한다.
		 */
		Car car1 = new Car(new Engine());
		
		car1.drive();
		//car1 객체의 engine 필드의 접근 지정자가 private일때에도 해당 car1 객체 내에서 참조하기 때문에서 접근가능하며
		//car1 생성자 호출시 car1.engine 필드에 인자로 대입된 engine 객체가 있기 때문에 "달려요"가 콘솔창에 나타난다.
	}
}
