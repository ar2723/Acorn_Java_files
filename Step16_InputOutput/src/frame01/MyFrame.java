package frame01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{

	public MyFrame(String title) {
	      super(title);
	      
	      setBounds(100, 100, 500, 500);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //BorderLayout으로 설정
	      setLayout(new BorderLayout());
	      
	      //UI를 감쌀 패널
	      JPanel p1 = new JPanel();
	      
	      JTextField tf=new JTextField(20);
	      JButton saveBtn=new JButton("저장하기");
	      
	      //패널에 UI를 추가
	      p1.add(tf);
	      p1.add(saveBtn);
	      
	      //패널을 프레임의 북쪽에 배치
	      add(p1, BorderLayout.NORTH);
	      //패널의 배경색
	      p1.setBackground(Color.YELLOW);
	      
	      /*
	       * 읽어오기 버튼을 누르면 diary.txt에 있는 모든 문자열을 읽어와서
	       * JTextArea에 출력해보세요.
	       * 
	       * - hint
	       * FileReader 객체를 활용하면 파일에서 문자열을 읽어 낼 수 있습니다.
	       */
	      JTextArea ta = new JTextArea();
	      add(ta, BorderLayout.CENTER);
	      
	      JButton readBtn = new JButton("읽어오기");
	      p1.add(readBtn);
	      
	      setVisible(true);
	      
	      //File 객체
    	  File f = new File("C:\\acorn202304\\myFolder\\diary.txt");
    	  					// 파일 경로 작성 시 '\' 기호를 쓸 때는 '\\' 이렇게 2개를 써주어야 특별한 기호로 인식한다.
    	  
	      readBtn.addActionListener((e)->{
	    	  //try 블럭 안에서 사용할 변수를 미리 만들어 놓는다.
	    	  FileReader fr = null;
	    	  BufferedReader br = null;
	    	 
	    	  try {
	    		  //참조값은 try 블럭 안에서 new 해서 넣어준다.
	    		  fr = new FileReader(f);
	    		  br = new BufferedReader(fr);
	    		//반복문 돌려서
				while(true) {
					//문자열을 한줄씩 읽어낸다.
					String msg = br.readLine();
				
					ta.append(msg); //개행기호는 제외된 상태로 읽어내기 때문에
					ta.append("\r\n"); //개행기호를 따로 추가해준다.
					
					if(msg == null) break; // 반복문 탈출, if문 뒤에 수행할 코드가 1줄 뿐이라면 {} 표시가 생략이 가능하다.
				}
	    	  	} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					//사용했던 스트림은 닫아주는 것이 좋다 (열렸던 순서의 역순으로...)
					try {
						//close()를 호출할 때도 null에 주의해서 호출해야 한다.
						if(br!=null) br.close();
						if(fr!=null) fr.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
	      });
	      
	      //버튼에 리스너 등록
	      saveBtn.addActionListener((e)->{
	    	  //필드에 입력한 문자열 읽어오기
	    	  String msg = tf.getText(); //바깥 영역에 정의된 지역변수 참조 가능!
	    	  //필드 입력값 클리어
	    	  tf.setText("");
	    	  
	    	  try {
	  			FileWriter fw = new FileWriter(f, true);
	  			fw.write(msg); //출력할 준비
	  			fw.write("\r\n"); //개행기호
	  			fw.flush(); //출력 
	  			fw.close(); //마무리
	  			JOptionPane.showMessageDialog(this, "저장했습니다");
	  		
	    	  } catch(Exception e1) {
	  			e1.printStackTrace();
	    	  }
	      });
	   }

	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
