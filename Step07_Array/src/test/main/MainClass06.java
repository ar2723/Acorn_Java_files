package test.main;

import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		//1. 문자열을 저장할 수 있는 방 5개짜리 배열 객체를 생성해서 참조값을 msgs 라는 지역변수에 담는다.
		String[] msgs = new String[5];
		//2. 키보드로부터 입력 받을 수 있는 Scanner 객체를 생성해서 참조값을 scan이라는 지역변수에 담는다.
		Scanner scan = new Scanner(System.in);
		//3. 반복문을 생성한 배열의 방의 갯수 만큼 돌면서 키보드로부터 문자열을 입력받아서
		//   배열에 순서대로 저장한다.
		//4. 반복문 돌면서 배열에 저장되었던 모든 문자열을 순서대로 콘솔창에 출력한다.
		for(int i = 0; i < msgs.length; i++) {
			System.out.print("저장할 문구를 입력하세요 : ");
			String msg = scan.nextLine();
			msgs[i] = msg;
			System.out.println("");
		}
		
		//위의 반복문을 줄여서 작성하는 경우 배열안에 data가 들어가지 않는다.
		//그 이유는 tmp = name[i] 이고
		//tmp = "김구라" 이렇게 문자열의 참조값을 대입한다고 해도
		//name[i]에는 어떤 값이 대입되는 것도 아니기 때문이다.
		
		for(String tmp:msgs) {
			System.out.println(tmp);
		}
	}
}
