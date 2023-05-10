package test.main;

/*
 * 	Exception은 모든 Exception의 부모 type이다.
 * 	예외의 종류는 크게 2가지로 분류할 수 있다.
 * 	1. RuntimeException을 상속 받은 예외
 * 		try~catch 블럭으로 감싸는 것은 option이다.
 * 
 * 	2. RuntimeException을 상속 받지 않은 예외
 * 		try~catch 블럭으로 감싸는 것은 의무이다.
 */


import java.util.Scanner;

public class MainClass03 {
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
//		} catch (NumberFormatException nfe) {
//			System.out.println("입력할 부분을 모두 숫자 형식으로 입력해주세요!");
		} catch (Exception e) {
			//전달인자 e에는 new NumberFormatException() 객체의 참조값이나, new ArithmeticException() 객체의 참조값이 대입된다고 생각하면 된다.
			//Exception type은 모든 예외의 부모 type이기 때문에 모든 예외가 여기서 처리된다.
			System.out.println("예외가 발생했습니다.");
			System.out.println("예외 메세지:"+e.getMessage());
		} finally {
			//여기는 예외가 발생을 하건 안하건 반드시 실행이 보장되는 블럭이다.
			//중요한 마무리 작업을 여기서 주로 수행한다.
			System.out.println("중요한 마무리 작업을 합니다!");
		}
		
		System.out.println("main 메소드가 정상 종료 됩니다.");
		
		
	}
}
