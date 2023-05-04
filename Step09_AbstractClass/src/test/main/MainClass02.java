package test.main;

import test.mypac.YourWeapon;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		
		Weapon w1 = new YourWeapon();
		w1.prepare(); // Weapon 추상 클래스에서 상속받은 메소드
		w1.attack(); // 이 메소드가 공중 공격을 하도록 프로그래밍 해보세요.
	}
}
