package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	//file을 따로 만들지 않고 클래스를 정의하기
	//외부 클래스에서 생성한 내부 클래스를 static 메소드에서 사용하려면 static class로 선언해야 한다.
	//내부 클래스에 한해서 class 앞에 static을 붙이는 것이 가능하다.
	
	public static class SeaWeapon extends Weapon{
		@Override
		public void attack() {
			System.out.println("바다를 공격해요!");
		}
	}
	
	//외부 클래스 - 메소드
	public static void main(String[] args) {
		Weapon w1 = new SeaWeapon();
		w1.attack();
		
		//외부 클래스 - 메소드 - 지역 내부 클래스 생성
		//이 지역 내부 클래스는 이 static 메소드 안에서만 사용할 수 있다.
		class SpaceWeapon extends Weapon {
			@Override
			public void attack() {
				//우주를 공격하는 무기를 만들어서 이용하고 싶다.
				System.out.println("우주를 공격해요!");		
			}
		}
		Weapon w2 = new SpaceWeapon();
		w2.attack();
	}
}
