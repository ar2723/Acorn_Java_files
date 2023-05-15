package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass05 {
	public static void main(String[] args) {
	    
		Connection conn=null;
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url="jdbc:oracle:thin:@localhost:1521:xe";
	         conn=DriverManager.getConnection(url, "scott", "tiger");
	         System.out.println("Oracle DB 접속 성공");
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      /*
	       * 4번 회원의 정보를 삭제해보세요.
	       */
	      int num = 4;
	      
	      PreparedStatement pstmt = null;
	      try {
			//실행할 미완성의 sql 문
	    	String sql = "Delete FROM member"
	    			+ 	 " WHERE num = ?";
	    	//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
	    	pstmt = conn.prepareStatement(sql);
	    	//PreparedStatement 객체의 메소드를 이용해서 미완성이 sql문을 완성시키기(? 에 값 바인딩하기)
	    	pstmt.setInt(1, num);
	    	//sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("회원 정보를 삭제했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
