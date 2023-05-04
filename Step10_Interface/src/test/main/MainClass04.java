package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		//자바에서 메소드가 단독으로 존재할 수 없다. 메소드의 인자를 메소드로 전달할 때 아래의 메소드를 객체로 포장해서 인자로 전달한 것과 유사하며
		//이는 자바스크립트에서 함수를 호출하면서 함수를 전달하는 것과 비슷하다.
		// new Drill () {} 이것은 결국 Drill type 데이터의 참조값이다.
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("구멍을 뚫어요");
			}
		});
		
		//아래의 코드는 위의 코드를 줄인 표현이지만 메소드를 직접적으로 전달하는 것은 아니다.
		//추상 메소드가 오직 1개인 인터페이스에 한해서만 사용가능하다.
		//여기서 ()->{}는 'public void hole() {}' 과 동일하다. (크게 중요하지는 X)
		useDrill(()->{
			System.out.println("천장에 구멍을 뚫어요!");
		});
	}
	
	public static void useDrill(Drill d) {
		d.hole();
		d.hole();
	}
}
