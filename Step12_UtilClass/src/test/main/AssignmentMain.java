package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import test.mypac.Lotto;

/*
 * 1. java 콘솔창 실행 결과
 * 
 * 로또를 몇개 구입하시겠어요? : 2
 * 1, 4, 5, 6, 40, 45
 * 3, 4, 10, 15, 16, 20
 * 
 * 단) 번호는 오름차순 정렬되어있어야 한다.
 *    중복된 번호가 나오면 안된다.
 *    
 * 2. javascript
 * 
 * -토끼 잡기 게임을 마음대로 만들어와 보세요.
 * 
 */
public class AssignmentMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("로또를 몇개 구입하시겠습니까? : ");
		int num = scan.nextInt();
		System.out.println("");
		System.out.println("생성된 로또 번호는 다음과 같습니다");
		System.out.println("");
		
		//구입한 로또 숫자만큼 반복문 수행
		for(int i = 0; i < num; i++) {
			//Lotto 객체를 생성 후 참조값을 지역변수 lotto에 담기
			Lotto lotto = new Lotto();
			//lotto 지역 변수에 담긴 객체의 참조값을 이용해서 lottoNum() 메소드를 호출 후 
			//배열의 반환 값을 지역 변수에 담기
			ArrayList<Integer> num1 = lotto.lottoNum();
			//생성된 로또 번호 배열을 오름차순으로 정렬
			Collections.sort(num1);
			//정렬된 로또 번호 배열을 출력
			System.out.println(i+1+"회차");
			System.out.println(num1);
			System.out.println("");
		}
	}
}
