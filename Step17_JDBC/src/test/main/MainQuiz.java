package test.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * swing gui를 이용해서
 * 
 */
public class MainQuiz extends JFrame implements ActionListener{
	Connection conn=null;
	
	public MainQuiz(String title) {
	      super(title);
	   
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url="jdbc:oracle:thin:@localhost:1521:xe";
	         conn=DriverManager.getConnection(url, "scott", "tiger");
	         System.out.println("Oracle DB 접속 성공");
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      setBounds(100, 100, 300, 500);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLayout(new FlowLayout());
	      
	      JLabel numlabel = new JLabel("번호");
	      JLabel namelabel = new JLabel("이름");
	      JLabel addrlabel = new JLabel("주소");
	      
	      JTextField numfield=new JTextField(20);
	      JTextField namefield=new JTextField(20);
	      JTextField addrfield=new JTextField(20);
	      JButton saveBtn=new JButton("저장하기");
	      
	      add(numlabel);
	      add(numfield);
	      add(namelabel);
	      add(namefield);
	      add(addrlabel);
	      add(addrfield);
	      add(saveBtn);
	      
	      saveBtn.addActionListener((e)->{
	    	  int num = Integer.parseInt(numfield.getText());
	    	  String name = namefield.getText();
	    	  String addr = addrfield.getText();
	    	  
	    	  PreparedStatement pstmt = null;
		      try {
		    	String sql = "INSERT INTO member"
		    			+ " (num, name, addr)"
		    			+ " VALUES(?, ?, ?)";
		    	
		    	pstmt = conn.prepareStatement(sql);
		    	
		    	pstmt.setInt(1, num);
		    	pstmt.setString(2, name);
		    	pstmt.setString(3, addr);
		    	
		    	pstmt.executeUpdate();
		    	
		    	System.out.println("회원 정보를 저장했습니다.");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	      });
	      
	      setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainQuiz("나의 프레임");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
