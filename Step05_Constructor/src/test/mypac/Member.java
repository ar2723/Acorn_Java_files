package test.mypac;

public class Member {
	//필드
	public int num;
	public String name;
	public String addr;
	
	//생성자 정의하기
	//생성자를 하나라도 명시적으로 정의하면 비명시되어 있었던 default 생성자는 사라지게 된다.
	//따라서 다음과 같이 생성자를 여러개를 만들어 둘 수 있다.
	
	//default 생성자 정의하기
	public Member() {}
	
	//생성자 안의 매개변수는 지역변수이며, 이 매개변수는 오직 생성자 안에서만 사용할 수 있다.
	public Member(int num, String name, String addr) {
		//생성자의 매개변수에 전달된 값을 필드에 저장해놓기
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	
	//메소드
	public void printInfo() {
		System.out.println("번호"+num+" 이름:"+name+" 주소:"+addr);
	}
}
