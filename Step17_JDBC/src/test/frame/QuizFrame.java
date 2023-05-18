package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.AccountDao;
import test.dto.AccountDto;

/*
 * [Oracle DB가 연동되는 프레임을 하나 만들어보세요]
 * 
 * - 주제는 자유 (할일 목록, 친구목록, 금전출납부 등등...)
 * - 테이블을 1개 이상 만들기
 * - dto, dao 클래스 만들기
 * - JFrame을 이용해서 해당 주제에 대해서 구현해보세요.
 */
public class QuizFrame extends JFrame implements ActionListener{
	//필드
	private JTable table;
	private DefaultTableModel model;
	private AccountDao dao;
	JTextField inputDate;
	JTextField inputItem;
	JTextField inputValue;
	
	//생성자
	public QuizFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JButton printBtn = new JButton("내역 불러오기");
		JLabel labelDate = new JLabel("날짜");
		inputDate = new JTextField(10);
		JLabel labelItem = new JLabel("항목");
		inputItem = new JTextField(10);
		JLabel labelValue = new JLabel("금액");
		inputValue = new JTextField(10);
		JButton incomeBtn = new JButton("수입 내역 추가");
		JButton expenseBtn = new JButton("지출 내역 추가");
		JButton deleteBtn = new JButton("내역 삭제하기");
		
		JPanel panel = new JPanel();
		panel.add(printBtn);
		panel.add(labelDate);
		panel.add(inputDate);
		panel.add(labelItem);
		panel.add(inputItem);
		panel.add(labelValue);
		panel.add(inputValue);
		panel.add(incomeBtn);
		panel.add(expenseBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.cyan);
		
		table = new JTable();
		
		String[] colNames = {"번호", "날짜", "항목", "수입", "지출", "잔액"};
		model = new DefaultTableModel(colNames, 0);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		printBtn.addActionListener(this);
		printBtn.setActionCommand("print");
		incomeBtn.addActionListener(this);
		incomeBtn.setActionCommand("income");
		expenseBtn.addActionListener(this);
		expenseBtn.setActionCommand("expense");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete");
		
		dao = new AccountDao();
	}
	
	//실행 main 메소드
	public static void main(String[] args) {
		QuizFrame frame = new QuizFrame("금전출납부");
		frame.setBounds(100, 100, 1200, 500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
	    if(cmd.equals("print")) {
	    	displayList();
	    } else if(cmd.equals("income")) {
	    	AccountDto dto = new AccountDto();
			dto.setDay(inputDate.getText());
			dto.setItem(inputItem.getText());
			dto.setIncome(Integer.parseInt(inputValue.getText()));
			dao.insertIncome(dto);
			
			displayList();
	    	
	    } else if(cmd.equals("expense")) {
	    	AccountDto dto = new AccountDto();
			dto.setDay(inputDate.getText());
			dto.setItem(inputItem.getText());
			dto.setExpense(Integer.parseInt(inputValue.getText()));
			dao.insertExpense(dto);
			
			displayList();
	    } else if(cmd.equals("delete")) {
	    	//JTable로부터 선택된 row의 인덱스를 얻어낸다
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) { //만일 선택된 row가 없다면
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요!");
				return; //메소드를 여기서 끝내라 (리턴)
			}
			
			//JOPtionPane 클래스가 가지고 있는 static 메소드가 return하는 값은 보통 int나 String인 경우가 많은데
			//이때 이러한 반환값의 데이터 타입은 static final 상수로 사전에 정의되어 있는 경우가 많다.
			int result = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?");
			// "예" 버튼을 눌렀을 때만 실제 삭제하기
			if(result == JOptionPane.YES_OPTION) {
				//선택된 row에 해당하는 회원번호(PK)를 얻어낸다.
				int num = (int)model.getValueAt(selectedRow, 0);
				//Dao 객체를 이용해서 회원 정보를 삭제한다.
				dao.delete(num);
				//JTable을 refresh 한다.
				displayList();
			}
	    }
	}
	
	public void displayList() {
		model.setRowCount(0);	
		List<AccountDto> list = dao.getList();
		int balance = 0;
		for(AccountDto tmp : list) {
			
			int income = tmp.getIncome();
	        int expense = tmp.getExpense();
	        balance += income - expense;
	        
			Object[] data = {
					tmp.getNum(), tmp.getDay(), tmp.getItem(),
					income, expense, balance
					};
			model.addRow(data);
			
			dao.updateBalance(tmp.getNum(), balance);
		}
	}

}
