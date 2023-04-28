package test.mypac;

public class MacBook {
	//외부에서 접근 불가하도록 접근 지정자를 private로 해서 필드 3개 선언하기
	//자바에서는 보통 필드는 private로 선언하고, 이런 필드는 객체 내에서만 접근할 수 있다.
	private Cpu cpu;
	private Memory memory;
	private HardDisk hardDisk;
	
	//생성자
	public MacBook(Cpu cpu, Memory memory, HardDisk hardDisk) {
		//생성자의 매개 변수에 전달된 값을 필드에 저장하기
		this.cpu=cpu;
		this.memory=memory;
		this.hardDisk=hardDisk;
	}
	//메소드
	//여기서 이 메소드는 같은 클래스내에 위치하기 때문에 this는 생략가능하다.
	public void doGame() {
		if(cpu == null || memory == null || hardDisk == null) {
			System.out.println("부품이 부족해서 게임을 할수가 없어요!");
			return ;
		} else {
			System.out.println("신나게 게임을 해요");
		}
	}
}
