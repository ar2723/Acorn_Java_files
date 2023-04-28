package test.mypac;

public class Square {
	public int width;
	public int height;
	
	public void squareArea () {
		int result = this.width*this.height;
		System.out.println("사각형의 넓이 : "+result);
	}
}
