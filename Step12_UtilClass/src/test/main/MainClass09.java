package test.main;
/*
 * While 문을 활용해서 원하는 횟수만큼 반복하기
 * 
 * -반복 횟수가 명확히 정해져 있으면 for 문으로 반복문을 도는게 좋다.
 * -반복 횟수가 명확히 정해져 있지 않고 반복을 돌아봐야지 횟수를 아는 경우 while문으로 반복문을 도는 게 좋다.
 * -while 문안의 조건식이 true에서 false로 바뀔 때까지 (또는 안에 미리 설정한 break 문을 충족할 때까지) 반복 수행하게 된다.
 */
public class MainClass09 {
	public static void main(String[] args) {
		//카운트를 셀 변수를 미리 만들어서 0으로 초기화
		int count = 0;
		//무한 루프로 돌다가
		while(true) {
			System.out.println("안녕!");
			count++;
			//특정 조건 하에서 무한 루프로 빠져나오기
			if(count == 5) {
				break;
			}
		}
		
		System.out.println("-----");
		
		int i = 0; // i를 0으로 초기화시키고
		
		//i가 5보다 작은 동안에 반복문 수행하기
		//아래의 반복문 조건식은 for(int i = 0; i < 5 ; i++) 이것과 동일하다.
		while(i<5) {
			//원하는 작업을 수행하고
			System.out.println("안녕!");
			//i를 1 증가시킨다.
			i++;
		}
	}
}
