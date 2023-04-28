package test.mypac;
/*
 * [ 메소드를 만들 때 고려해야 하는 것 ]
 * 
 * 1. 접근 지정자 (모르면 public)
 * 2. static or non static ( 모르면 non static )
 * 3. 리턴 type ( 모르면 void )
 * 4. 메소드명
 * 5. 메소드에 전달하는 인자의 갯수와 데이터 type
 */
public class Test {
	public void walk() {
		System.out.println("걸어요!");
	}
	
	public int getNumber() {
		return 10;
	}
	
	public String getGreeting() {
		return "안녕하세요";
	}
	
	public Airplane getPlane() {
		Airplane plane = new Airplane();
		return plane;
	}
	// int type 을 메소드의 인자로 전달 받는 메소드
	// 메소드 호출 시 int type 데이터를 전달하지 않으면 호출 자체가 되지 않는다.
	public void setNum(int Num) {
		
	}
	//String type을 메소드의 인자로 전달 받는 메소드
	public void setName(String name) {
		
	}
	//Airplane type을 메소드의 인자로 전달 받는 메소드
	public void setPlane(Airplane plane) {
		
	}
	// int type, String type, Airplane type 세개를 전달 받는 메소드
	public void doSomething(int num, String name, Airplane plane) {
		
	}
	
	//메소드가 다중정의 되어있다 = 메소드가 오버로딩 되어있다.
	public void send() {
		System.out.println("무언가를 전송해요");
	}
	public void send(int Num) {
		System.out.println(Num+" 을(를) 전송해요");
	}
	public void send(String Name) {
		System.out.println(Name+" 을(를) 전송해요");
	}
	public void send(Airplane plane) {
		System.out.println("비행기를 전송해요");
	}
}
