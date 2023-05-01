package test.main;

import java.util.Random;

public class QuizMain2 {
	public static void main(String[] args) {
		/*
		 * 	2. run 했을 때
		 * 	5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해보세요
		 * 	예) cherry | apple | cherry
		 */
		Random ran = new Random();
		String[] str = {"cherry", "apple", "banana", "melon", "7"};
		int ranNum1 = ran.nextInt(5);
		int ranNum2 = ran.nextInt(5);
		int ranNum3 = ran.nextInt(5);
		System.out.print(str[ranNum1]);
		System.out.print(" | ");
		System.out.print(str[ranNum2]);
		System.out.print(" | ");
		System.out.print(str[ranNum3]);
		System.out.println("");
		
		for(int i = 0; i < 3 ; i++) {
			int ranNum = ran.nextInt(5);
			System.out.print(str[ranNum]);
			if(i < 2) {
				System.out.print(" | ");
			}
		}
	}
}
