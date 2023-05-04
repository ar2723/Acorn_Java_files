package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		
		//아래에 있는 useWeapon() 메소드를 호출하려면 Weapon type의 참조값이 필요하다.
		//이름이 있는 클래스를 따로 만들지 않고 추상클래스 Weapon type의 참조값을 얻어낼 수 있을까?
		//아래의 new Weapon()은 익명 지역 내부 클래스의 public ? () {} 생성자를 자동으로 호출하는 표현식이다.
		//익명 지역 클래스의 데이터 타입은 부모 클래스의 타입을 상속한다.
		
		Weapon w1 = new Weapon() {
			//이 중괄호 영역은 이름이 없는 익명(Anonymous) 로컬 클래스이고 앞의 Weapon 클래스를 자동으로 상속받는다.
			//이 익명 클래스는 오버라이드가 강제되지는 않는다.
			@Override
			public void attack() {
				System.out.println("아무나 공격하자!");
			}
		};
		
		//선언된 객체의 참조값 사용하기
		useWeapon(w1);
		
		// 메소드를 호출할 때 바로 익명 지역 클래스를 이용해서 Weapon type의 참조값을 얻어내서 사용하기
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("김구라를 공격해요!");
			}
		});
	}
	//Weapon type의 참조값을 전달 받아서 사용하는 static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	}
}
