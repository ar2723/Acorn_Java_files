package test.main;

import java.util.Random;
import java.util.Scanner;

/*
 * 콘솔창으로 부터 문자열이나 숫자를 입력 받을수 있는 객체
 * Scanner scan=new Scanner(System.in);
 * 
 * 랜덤한 숫자나 boolean 값을 얻어낼수 있는 객체
 * Random ran=new Random();
 * 
 * 위의 두가지 객체를 활용해서  가위,바위,보 게임을 만들어 보세요.
 * 
 * console 실행 화면 -
 * (가위:0), (바위:1), (보:2) 
 * 입력하세요:  0
 * 나 : 가위  vs  Com: 보
 * 이겼습니다.
 */

public class MainClass_Assignment {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		String[] rockPaperScissors = {"가위", "바위", "보"};
		
		int b = ran.nextInt(0, 2);
		
		System.out.println("가위바위보 게임을 시작합니다");
		System.out.println("");
		System.out.println("(가위:0), (바위:1), (보:2)");
		System.out.println("");
		System.out.print("내고자 하는 것의 번호를 입력하세요 : ");
		int a = scan.nextInt();
		
		System.out.println("나 : "+ rockPaperScissors[a] + " vs "+"Com : "+rockPaperScissors[b]);
		
		if(a == b) {
			System.out.println("아깝네요 ㅠㅠ 비겼습니다.");
		} else if (a-b == 1 || a-b == -2) {
			System.out.println("축하합니다!! 이겼습니다!!~");
		} else if (a-b == -1 || a-b == 2) {
			System.out.println("아깝네요 ㅠㅠ 졌습니다.");
		}
	}
}
