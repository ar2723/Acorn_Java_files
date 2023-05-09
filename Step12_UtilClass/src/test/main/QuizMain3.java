package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class QuizMain3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("로또를 몇개 구입하시겠어요 : ");
		//숫자를 입력받고
		int amount = scan.nextInt();
		//입력 받은 숫자 만큼 로또 번호를 출력한다.
		for(int i = 0; i < amount; i++) {
			printLotto();
			System.out.println(); // 개행
		}
		
	}
	
	//로또 번호 한 셋트를 콘솔에 출력하는 메소드
	public static void printLotto() {
		//로또 번호 6개를 출력하는 프로그래밍
				
		Random ran = new Random();
		//로또번호를 저장할 HashSet 객체 생성해서 참조값을 Set 인터페이스에 type 변수에 담기
		Set<Integer> numSet = new HashSet<>();
				
		//반복문 돌면서 로또 번호를 담다가 특정 조건에 이르면 중단하기
		while(true) {
			int ranNum = ran.nextInt(45)+1;
			numSet.add(ranNum);
			//만일 6개의 숫자를 모두 얻어 냈다면
			if(numSet.size() == 6) {
				break;
			}
		}
		//ArrayList에 담기 (정렬을 위해서)
		List<Integer> lottoNums = new ArrayList<>(numSet);
				
		//Collections 클래스의 Static 메소드를 이용해서 숫자를 오름차순 정렬하기
		Collections.sort(lottoNums);
		//Collections.sort(lottoNums, Collections.reverseOrder()); // 내림차순 정렬
				
		for(int i = 0; i < lottoNums.size(); i++) {
			int num = lottoNums.get(i);
			System.out.print(num);
			//i가 마지막 인덱스(5)가 아닐 때만 , 를 출력한다.
			if(i != lottoNums.size() - 1) {
				System.out.print(", ");
			}
		}
	}
}
