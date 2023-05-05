package test.mypac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class Lotto {
	public ArrayList<Integer> lottoNum () {
		Set<Integer> numSet = new HashSet<>();
	    while(numSet.size() < 6) {
	        numSet.add((int)(Math.random()*50) + 1);
	    }
	    return new ArrayList<>(numSet);
	}
}
