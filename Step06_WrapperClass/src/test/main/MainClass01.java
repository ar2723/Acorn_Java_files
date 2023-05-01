package test.main;
/*
 *  [ 기본 data type의 참조 data type ]
 *  
 *  byte   : Byte
 *  short  : Short
 *  int    : Integer
 *  long   : Long
 *  
 *  float  : Float
 *  double : Double
 *  
 *  char   : Character
 *  boolean: Boolean
 *  
 *  - 때로는 기본 데이터 type에 대한 참조 데이터 type이 필요할 때가 있다.
 *  - 기본 데이터 type을 객체에 포장(boxing)하는 형태이다.
 *  - boxing과 unboxing은 자동으로 되기 때문에 프로그래머가 신경을 쓸 필요는 없다.
 */

public class MainClass01 {
	public static void main(String[] args) {
		//기본 데이터 type num1
		//이 데이터는 단순히 stack 영역에 만들어진 저장공간에 10이 대입된 것이다.
		//이 10에 대한 참조값은 존재하지 않는다.
		int num1 = 10;
		
		//참조 데이터 type num2
		//이 데이터는 heap 영역에 만들어진 객체 안에 10이 포장되어 있는 것이다.
		//따라서 여기 10에 대한 참조값은 존재하며, num2에는 10에 대한 참조값이 들어있다.
		Integer num2 = 10;
		
		//참조 데이터 type이지만 기본 데이터 type처럼 사용할 수 있다.
		int result1 = num2 + 1;
		int result2 = num1 + num2;
		Integer result3 = num1 + num2;
		
		//기본 데이터의 참조 데이터화 해서 구분하는 것은 
		//특정 필드에 기본 데이터 타입이 담기지 못하고, 객체의 참조값만 담을 수 있는 경우가 있기 때문이다.
		
		//Integer 클래스의 static 메소드를 이용해서 문자 "999"를 숫자 999로 변환 할 수 있다.
		int result4 = Integer.parseInt("999");
		//자바스크립트의 Number("xxx") 함수와 기능이 동일하다.
	}
}
