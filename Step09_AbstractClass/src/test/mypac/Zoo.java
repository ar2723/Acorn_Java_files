package test.mypac;

//외부 클래스
public class Zoo {
	//내부 클래스(inner class) 선언
	public class Monkey{
		public void say() {
			System.out.println("안녕! 나는 원숭이야");
		}
	}
	//내부 클래스
	public class Tiger {
		public void say() {
			System.out.println("안녕! 나는 호랑이야");
		}
	}
	//외부 클래스 - 메소드
	public Monkey getMonkey() {
		//내부 클래스로 객체를 생성해서 리턴해주기
		return new Monkey();
	}
	public Tiger getTiger() {
		return new Tiger();
	}
}
