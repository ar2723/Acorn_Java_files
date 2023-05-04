package test.main;

//외부 클래스
public class MainClass04 {
	// 외부 클래스 -> 내부 클래스
	// static 메소드 안에서 사용하려면 static 예약어가 필요!
	public static class Gura {
		public void say () {
			System.out.println("안녕! 나는 구라야!");
		}
	}
	
	//static 메소드는 static 영역 안에 있는 내부 클래스만을 사용할 수 있다.
	public static void main(String[] args) {
		//다른 내부 클래스의 객체를 생성
		Gura g = new Gura();
		//생성된 내부 클래스 객체의 메소드를 호출
		g.say();
		
		/*
		 * 메소드 안에서도(여기서는 main 메소드) 클래스를 정의할 수 있다.
		 * 메소드 안에 정의한 클래스를 지역 내부 클래스라고 한다. (Local Inner Class)
		 * 선언된 메소드 내부(여기서는 main 메소드)에서만 객체를 생성해서 사용할 수 있다.
		 * 메소드 내부에서 정의된 변수나 객체의 참조값을 지역 내부 클래스에서 사용할 수 있다.
		 */
		// 외부 클래스 - static 메소드 - 지역 내부 클래스
		class Cat {
			public void say() {
				System.out.println("야옹!");
			}
		}
		// 외부 클래스 - static 메소드 안에서 지역 내부 클래스 객체를 생성 및 객체의 메소드를 호출
		Cat c = new Cat();
		c.say();
	}
}
