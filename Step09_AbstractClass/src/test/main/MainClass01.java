package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

/*
 * [ 추상클래스 (Abstract Class) ]
 * 
 * -class 예약어 앞에 abstract를 명시해서 클래스를 정의한다.
 * -형태만 정의되고 실제 구현은 되지 않은 메소드가 존재할 수 있다.
 * -형태만 정의된 메소드를 만들 때는 abstract 예약어를 붙여서 메소드를 정의한다.
 * -추상 클래스의 생성자는 존재하지만 단독으로 객체 생성은 불가하다
 * -추상 클래스 Type의 참조값이 필요하다면 추상클래스를 상속받은 자식클래스를 정의해서 객체를 생성한다.
 * -추상 클래스를 상속받은 자식클래스는 부모의 추상메소드를 모두 오버라이드(재정의) 해야한다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		//Weapon type의 참조값을 담을 빈 지역 변수 w1 만들기
		//추상 클래스는 데이터 타입으로서의 역할은 해낼 수 있다.
		Weapon w1 = null;
		//바로 밑의 주석 코드는 실행 시에 NullPointerException을 발생시킨다.
//		w1.prepare();
		
		
		MyWeapon w2 = new MyWeapon();
		w2.prepare();
		w2.attack();
		
		//자바의 다형성으로 인해 new MyWeapon() 객체를 Weapon type 데이터에도 담을 수 있다.
		Weapon w3 = w2;
		w3.prepare();
		w3.attack();
		
		Object w4 = w2;
		
	}
}
