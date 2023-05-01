package test.main;

import java.util.Random;

public class QuizMain3 {
	public static void main(String[] args) {
		/*
		 * 	3. 우연히 3개가 모두 같게 나왔을 때는 "당첨됐습니다!!~"를 출력하고
		 * 	   하나라도 다르면 "꽝"을 출력하도록 프로그래밍 해보세요.
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
		
		if(ranNum1 == ranNum2 && ranNum2 == ranNum3) {
			System.out.println("당첨됐습니다!");
		} else {
			System.out.println("꽝");
		};
		
		System.out.println("");
		
		int[] nums = new int[3];
		for(int i = 0; i < 3 ; i++) {
			nums[i] = ran.nextInt(5);
			System.out.print(str[nums[i]]);
			if(i < 2) {
				System.out.print(" | ");
			}
		}
		System.out.println(); // 개행 기호만 출력
		
		if(nums[0] == nums[1] && nums[1] == nums[2]) {
			System.out.println("당첨됐습니다!");
		} else {
			System.out.println("꽝");
		}
	}
}
