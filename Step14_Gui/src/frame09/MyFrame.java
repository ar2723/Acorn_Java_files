package frame09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	//생성자
	public MyFrame (String msg) {
		super(msg);
		
		setBounds(100, 100, 900, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//JTextField 2개
		JTextField inputMsg = new JTextField(10);
		JTextField inputMsg2 = new JTextField(10);
		
		//JButton 4개
		JButton plusBtn = new JButton("+");
		JButton minusBtn = new JButton("-");
		JButton mulBtn = new JButton("*");
		JButton divBtn = new JButton("/");
		
		//JLabel 1개
		JLabel label = new JLabel("= " + 0);
		
		//UI를 프레임에 배치
		add(inputMsg);
		add(plusBtn);
		add(minusBtn);
		add(mulBtn);
		add(divBtn);
		add(inputMsg2);
		add(label);
		
		plusBtn.addActionListener((e)->{
			String value = inputMsg.getText();
			String value2 = inputMsg2.getText();
			Double result = Double.parseDouble(value) + Double.parseDouble(value2);
			label.setText("= " + result);
		});
		
		minusBtn.addActionListener((e)->{
			String value = inputMsg.getText();
			String value2 = inputMsg2.getText();
			Double result = Double.parseDouble(value) - Double.parseDouble(value2);
			label.setText("= " + result);
		});
		
		mulBtn.addActionListener((e)->{
			String value = inputMsg.getText();
			String value2 = inputMsg2.getText();
			Double result = Double.parseDouble(value) * Double.parseDouble(value2);
			label.setText("= " + result);
		});
		
		divBtn.addActionListener((e)->{
			String value = inputMsg.getText();
			String value2 = inputMsg2.getText();
			Double result = Double.parseDouble(value) / Double.parseDouble(value2);
			label.setText("= " + result);
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame calculator = new MyFrame("계산기");
		
	}
}
