package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		List<Lotto> lottoList = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("로또를 몇개 구입하시겠습니까? : ");
		int num = scan.nextInt();
		
		Lotto lotto = new Lotto();
		
		ArrayList<Integer> num1 = lotto.lottoNum();
		//오름차순 정렬
		Collections.sort(num1);
		
		System.out.println(num1);
			}
	}
