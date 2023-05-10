package test.main;

import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나눌 수 입력 : ");
		String inputNum1 = scan.nextLine();
		System.out.print("나누어 지는 수 입력 : ");
		String inputNum2 = scan.nextLine();
		
		try {
			int num1 = Integer.parseInt(inputNum1);
			int num2 = Integer.parseInt(inputNum2);
			
			int result = num2 / num1;
			int result2 = num2 % num1;
			
			System.out.println(num2+" 을(를) "+num1+" 으로 나눈 몫 :"+result);
			System.out.println(num2+" 을(를) "+num1+" 으로 나눈 나머지 :"+result2);
		} catch (ArithmeticException ae) {
			System.out.println("어떤 수를 0으로 나눌 수는 없어요");
		} catch (NumberFormatException nfe) {
			System.out.println("입력할 부분을 모두 숫자 형식으로 입력해주세요!");
		}
		
		System.out.println("main 메소드가 정상 종료 됩니다.");
		
	}
}
