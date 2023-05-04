package test.mypac;

//미완성된 추상메소드를 멤버로 가지고 있는 클래스는 abstract 예약어를 붙여서 정의 해야 한다.
//추상 클래스는 단독으로 객체 생성이 되지 않는다.
public abstract class Weapon {
	
	//생성자
	public Weapon () {
		System.out.println("Weapon 객체가 생성되었습니다");
	}
	
	//무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비 합니다.");
	}
	
	//[ 추상 메소드 ]
	//공격을 하는 메소드의 모양만 정의하고 실제 구현은 하지 않기
	//미완성된 추상 메소드를 만들 때는 abstract 예약어가 필요하다.
	//이 메소드를 사용하기 위해서는 반드시 상속받아서 오버라이드(강제) 하면 된다.
	public abstract void attack();
}