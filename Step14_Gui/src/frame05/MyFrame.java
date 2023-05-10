package frame05;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//자바의 GUI는 그렇게 잘 쓰이지는 않는다.
public class MyFrame extends JFrame implements ActionListener{
	
	//ActionListener 인터페이스 구현에 따른 오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "수정합니다.");
	}
	
	//생성자
	public MyFrame(String title) {
		super(title);
		
		// setBounds(x, y, width, height) 창의 위치와 크기 설정
		this.setBounds(100, 100, 500, 500);
		
		// 이 프레임(MyFrame)의 x 버튼 (close 버튼)을 눌렀을 때 프로세스도 같이 종료 되도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//BorderLayout 매니저 사용해보기
		setLayout(new FlowLayout());
		
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		
		//this = MyFrame
		//JFrame이 Component의 상속을 받았기 때문에 MyFrame 객체가 Component type을 지닐 수 있다.
		Component a = this;
		
		//ActionListener 인터페이스 type의 참조값을 얻어내서
		ActionListener listener1 = new ActionListener () {
			// 이 리스너를 등록한 UI에 어떤 액션이 발생하면 호출되는 메소드
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//익명 내부 클래스지만 ActionListener 인터페이스를 구현했기 때문에 인터페이스의 데이터 타입을 물려받는다.
				ActionListener b = this;
				
				System.out.println("전송 버튼을 눌렀네?");
				//JOptionPane.showMessageDialog(프레임의 참조값, 띄울 메세지);
				// 클래스명.this 하면 외부에 있는 클래스로 생성한 객체의 참조값을 가리킬 수 있다.
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다!.");
			}
		};
		
		//전송 버튼에 등록하기
		sendBtn.addActionListener(listener1);
		
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		//ActionListener 인터페이스 type의 참조값을 함수 형태로 전달도 가능
		deleteBtn.addActionListener(
			(e) -> {
				System.out.println("삭제 버튼을 눌렀네?");
				//함수 형태의 메소드에서 this는 바깥 클래스로 생성한 객체의 참조값을 가리킬 수 있다.
				JOptionPane.showMessageDialog(this, "삭제합니다.");
			}
		);
		
		JButton updateBtn = new JButton("수정");
		add(updateBtn);
		//MyFrame을 ActionListener 인터페이스 type으로 만들 수는 없을까? -> 객체를 인터페이스로 구현하면 됨
		updateBtn.addActionListener(this);
		
		// 프레임을 화면상에 실제 보이게 하기 (false하면 화면에 보이지 않는다)
		setVisible(true);
		
	}
	public static void main(String[] args) {
		//MyFrame 객체 생성
		new MyFrame("나의 프레임");
		System.out.println("main 메소드가 종료됩니다.");
	}
	
}
