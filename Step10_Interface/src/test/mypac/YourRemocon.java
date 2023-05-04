package test.mypac;

public class YourRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("티비의 채널을 올려요");
	}

	@Override
	public void down() {
		System.out.println("티비의 채널을 내려요");
	}

}
