package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		//정수를 저장할 수 있는 ArrayList 객체를 생성해서 참조값을 지역변수 nums에 담기
		//ArrayList 객체에서 선언할 수 있는 데이터 type은 기본 type이 아닌 참조 type만 가능
		ArrayList<Integer> nums = new ArrayList<>();
		//ArrayList 객체에 10, 20, 30 숫자 3개를 담아보세요.
		nums.add(10);
		nums.add(20);
		nums.add(30);
		//확장 for문을 이용해서 저장된 정수를 순서대로 콘솔창에 출력하기
		//아래 반복문 조건절에서는 Integer 대신에 Int를 넣어도 된다.
		for(Integer tmp : nums) {
			System.out.println(tmp);
		}
		
		System.out.println("--- 일반 for 문 ---");
		//일반 for문
		for(int i = 0; i < nums.size(); i++) {
			System.out.println(nums.get(i));
		}
	}
}
