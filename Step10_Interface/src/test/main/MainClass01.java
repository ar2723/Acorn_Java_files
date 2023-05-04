package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		// 어떻게 하면 Remocon 인터페이스 type의 참조값을 얻어낼 수 있을까?
		// class는 extends 하는 것이고 interface는 implements 한다.
		Remocon r1 = new MyRemocon();
		r1.up();
		r1.down(); 
	}
}
