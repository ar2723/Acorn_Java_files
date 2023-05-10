package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		//Thread 클래스는 RuntimeException을 상속받지 않았기 때문에 반드시 try-catch 블럭으로 감싸주어야 한다.
		//만약 exception을 throw를 하는 경우 main 메소드 호출시에 자체적으로 알아서 예외처리를 넘기는 것을 의미한다.
		try {
			/*
			 * 실행의 흐름을 스레드라고 하는 데 스레드를 임으로 5초동안 잡아두기
			 * 컴파일시에 발생하는 Exception(RuntimeException을 상속받지 않은 Exception)
			 * 이 발생하기 때문에 반드시 try~catch 블럭으로 예외 처리를 해야 한다.
			 */
			
			//일정 시간 실행의 흐름을 잡아 놓을 수 있다.
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료 되었습니다.");
	}
}
