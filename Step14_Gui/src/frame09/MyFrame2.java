package frame09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame implements ActionListener{
	//필드
	JLabel label2;
	JTextField inputMsg, inputMsg2;
	
	//ActionListener 인터페이스를 구현했기 때문에 강제 오버라이드 된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//눌러진 버튼의 command 읽어오기
		Object btn = e.getActionCommand();
		
		//입력한 문자열 읽어오기
		String val = inputMsg.getText();
		String val2 = inputMsg2.getText();
		
		try {
			//입력한 문자열을 실수(double)로 변경하기
			double num1 = Double.parseDouble(val);
			double num2 = Double.parseDouble(val2);
			
			//연산의 결과값을 담을 변수를 미리 선언하고 초기값 대입하기 (왜 미리 선언해야하는지를 알아야 함)
			double result = 0;
			
			//command가 무엇이냐를 확인해서 분기하기
			if(btn.equals("plus")) {
				result = num1 + num2;
			} else if (btn.equals("minus")) {
				result = num1 - num2;
			} else if (btn.equals("multi")) {
				result = num1 * num2;
			} else if (btn.equals("divide")) {
				if(num2 == 0) {
					JOptionPane.showMessageDialog(this, "어떤 수를 0으로 나룰 수는 없어요!");
					//메소드를 여기서 종료 시키기 
					return;
				}
				result = num1 / num2;
			}
			//숫자를(double) 문자열(String)로 바꾸기
			String resultText = Double.toString(result);
			
			//결과를 JLabel에 출력하기
			label2.setText(resultText);
		
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "입력칸 모두 숫자 형식으로 입력해주세요!");
		}
	}
	
	//생성자
	public MyFrame2 (String msg) {
		super(msg);
		
		setBounds(100, 100, 900, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField 2개
		inputMsg = new JTextField(10);
		inputMsg2 = new JTextField(10);
		
		//JButton 4개
		JButton plusBtn = new JButton("+");
		JButton minusBtn = new JButton("-");
		JButton mulBtn = new JButton("*");
		JButton divBtn = new JButton("/");
		
		//JLabel 2개
		JLabel label1 = new JLabel("= ");
		label2 = new JLabel("0");
		
		//UI를 프레임에 배치
		add(inputMsg);
		add(plusBtn);
		add(minusBtn);
		add(mulBtn);
		add(divBtn);
		add(inputMsg2);
		add(label1);
		add(label2);
		
		//각 버튼에 액션 리스너 등록하기
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		mulBtn.addActionListener(this);
		divBtn.addActionListener(this);
		
		//각 버튼에 action command 설정하기
		plusBtn.setActionCommand("plus");
		minusBtn.setActionCommand("minus");
		mulBtn.setActionCommand("multi");
		divBtn.setActionCommand("divide");
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame2 calculator = new MyFrame2("계산기");
		
	}
}
