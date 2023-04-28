package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// 0으로 초기화된 방 3개짜리 int[] 객체 만들어서 참조값을 지역 변수 nums에 담기
		int[] nums = {0, 0, 0};
		//0번방에 10, 1번방에 20, 2번방에 30을 저장해보세요.
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		// 0 으로 초기화된 방 500개짜리 int[] 객체 만들어서 참조값을 지역 변수 nums2에 담기
		int[] nums2 = new int[500];
		/*
		 * 0번 방에 1
		 * 1번 방에 2
		 * 2번 방에 3
		 * .
		 * .
		 * .
		 * 499번 방에 500을 저장해보세요.
		 */
		
		for(int i = 0; i < 500; i++) {
			nums2[i] = i + 1;
		}
		
	}
}