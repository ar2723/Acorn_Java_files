package frame01;

import javax.swing.JButton;
import javax.swing.JFrame;

//자바의 GUI는 그렇게 잘 쓰이지는 않는다.
public class MyFrame extends JFrame{
	
	//생성자
	public MyFrame(String title) {
		super(title);
		
		// setBounds(x, y, width, height) 창의 위치와 크기 설정
		this.setBounds(100, 100, 500, 500);
		// 이 프레임(MyFrame)의 x 버튼 (close 버튼)을 눌렀을 때 프로세스도 같이 종료 되도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 레이아웃 매니저는 아직 사용하지 않겠다 (모든 UI를 절대 좌표에 배치하겠다)
		setLayout(null);
		
		//버튼 객체를 하나를 만들어서
		JButton btn1 = new JButton("버튼1");
		//위치를 설정하고 (x, y)
		btn1.setLocation(10, 10);
		//크기도 설정하고 (width, height)
		btn1.setSize(100, 30);
		//프레임에 추가하기
		this.add(btn1);
		
		// 프레임을 화면상에 실제 보이게 하기 (false하면 화면에 보이지 않는다)
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료됩니다.");
	}
}
