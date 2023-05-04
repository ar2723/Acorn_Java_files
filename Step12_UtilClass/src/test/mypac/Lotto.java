package test.mypac;

import java.util.ArrayList;

public final class Lotto {
	public ArrayList<Integer> lottoNum () {
		ArrayList<Integer> numList = new ArrayList<>();
		for(int i = 0; i <= 6; i++) {
			numList.add((int)(Math.random()*50));
		}
		
		

		
		return numList;
	}
}
