package test.main;

/*
 * java에서 배열도 객체이다
 * 즉 배열은 참조데이터 type이다.
 */

public class MainClass01 {
	public static void main(String[] args) {
//		int num = null; // null은 바로 아래와 같이 참조 데이터 타입의 기본값이다.
//		String a = null;
//		
//		int[] nums = null;
//		int[] nums2 = 0; // 참조 데이터 타입에 0을 대입할 수는 없다.
		
		// int type 5개를 저장하고 있는 배열 객체 생성해서 참조값을 nums3라는 지역 변수에 담기
		int[] nums3 = {10, 20, 30, 40, 50};
		//위의 배열 데이터는 자바스크립트에서 let nums3 = [10, 20, 30, 40, 50]; 이것과 동일하다.
		
		// double type 5개를 저장하고 있는 배열
		double[] nums4 = {10.1, 10.2, 10.3, 10.4, 10.5};
		// boolean type 5개를 저장하고 있는 배열
		boolean[] truth = {true, false, false, true, true};
		// String type (참조데이터 type) 5개를 저장하고 있는 배열
		String[] names = {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		
		// 배열객체는 .clone() 이라는 메소드와 .length 라는 필드가 있다.
		
		// 배열 객체의 복제본 얻어내기
		// 하지만 이 메소드는 거의 사용할 일이 없다.
		int[] result = nums3.clone();
		// 배열의 크기 얻어내기
		int size = nums3.length;
		// 배열은 순서가 있는 데이터이다. 특정 index의 item 참조하는 방법
		int first=nums3[0];
		int second=nums3[1];
		int third=nums3[2];
		
		
		
		
	}
}
