package test.mypac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class Lotto {
	public ArrayList<Integer> lottoNum () {
		Set<Integer> numSet = new HashSet<>();
		//중복되지 않는 번호가 6개가 될 때까지 계속해서 반복문 수행
	    while(numSet.size() < 6) {
	        numSet.add((int)(Math.random()*44) + 1);
	    }
	    //중복된 번호가 없는 numSet 객체를 이용해서 새로운 ArrayList 객체를 생성 수 반환
	    return new ArrayList<>(numSet);
	}
}
