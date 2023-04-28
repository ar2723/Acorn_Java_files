package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		//지역 변수는 값을 넣지 않고 선언만 하면 만들어지지 않는다.
		//이후 변수에 별도로 값을 대입하는 방식도 있으나 잘 사용하지는 않는다.
		int num1;
		String name1;
		
		//아직 만들어지지 않았기 대문에 num1은 참조 불가
		//int result = 10+num1;
		
		//아직 만들어지지 않았기 때문에 name1은 참조 불가
		//System.out.println(name1);
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
