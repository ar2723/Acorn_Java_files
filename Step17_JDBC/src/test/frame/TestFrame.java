package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class TestFrame extends JFrame{
	//필드
	JTable table;
	DefaultTableModel model;
	MemberDao dao;
	
	//생성자
	public TestFrame(String title) {
		super(title);
		
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("이름");
		JTextField inputName = new JTextField(10);
		JLabel label2 = new JLabel("주소");
		JTextField inputAddr = new JTextField(10);
		JButton btn1 = new JButton("데이터 출력하기");
		JButton addBtn = new JButton("데이터 추가하기");
		JTextField inputNum = new JTextField(10);
		JLabel label3 = new JLabel("번호");
		JButton deleteBtn = new JButton("데이터 삭제하기");
		JButton updateBtn = new JButton("데이터 수정하기");
		
		//패널에 UI를 패치하고
		JPanel panel = new JPanel();
		panel.add(btn1);
		panel.add(label3);
		panel.add(inputNum);
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		panel.add(updateBtn);
		
		//페널째로 프레임의 북쪽에 배치
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.yellow);
		
		//테이블 객체 생성 후 필드에 참조값 담기
		table = new JTable();
		
		String[] colNames = {"번호", "이름", "주소"};
		//테이블에 연결할 모델 객체 생성 (테이블에 출력할 데이터를 여기에 추가하면 테이블에 출력된다)
		model = new DefaultTableModel(colNames, 0);
		//모델을 테이블에 연결한다.
		table.setModel(model);
		//스크롤이 가능 하도록 테이블을 JScrollpane에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		//테이블을 프레임의 중앙에 배치한다.
		add(scroll, BorderLayout.CENTER);
		
		//테이블에 출력할 sample 데이터
//		Object[] row1 = {1, "김구라", "노량진"};
//		Object[] row2 = {2, "해골", "행신동"};
//		Object[] row3 = {3, "원숭이", "상도동"};
//		
//		model.addRow(row1);
//		model.addRow(row2);
//		model.addRow(row3);
		
		dao = new MemberDao();
		
		btn1.addActionListener((e)->{
			displayMember();
		});
		
		addBtn.addActionListener((e)->{
			MemberDto dto = new MemberDto();
			try {
				dto.setNum(Integer.parseInt(inputNum.getText()));
				dto.setName(inputName.getText());
				dto.setAddr(inputAddr.getText());
				dao.insert(dto);
				
				//JTable을 refresh 한다.
				displayMember();
				
				JOptionPane.showMessageDialog(this, "데이터를 추가했습니다!");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "번호칸에는 반드시 숫자만 입력해주세요!");
			}
		});
		
		deleteBtn.addActionListener((e)->{
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
				displayMember();
			}
		});
		
		updateBtn.addActionListener((e)->{
			try {
				int rowNum = Integer.parseInt(inputNum.getText());
				dao.update(new MemberDto(rowNum, inputName.getText(), inputAddr.getText()));
				//JTable을 refresh 한다.
				displayMember();
				
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "수정할 데이터 행의 번호를 입력해주세요!");
			}
		});
	}
	//run 했을 때 실행의 흐름이 시작되는 main 메소드
	public static void main(String[] args) {
		TestFrame f = new TestFrame("테스트 프레임");
		f.setBounds(100, 100, 1100, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//TestFrame에 메소드 추가
	public void displayMember() {
		model.setRowCount(0);	
		List<MemberDto> memberList = dao.getList();
		Collections.reverse(memberList);
		for(MemberDto tmp : memberList) {
			//tmp = memberList.get(i)
			Object[] data = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(data);
		}
	}
}
