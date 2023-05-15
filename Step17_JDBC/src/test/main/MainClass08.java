package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.mypac.Member;

public class MainClass08 {
	public static void main(String[] args) {
		//수정할 회원의 정보라고 가정하자
		int num = 1;
		String name = "이정호";
		String addr = "아현동";
		
		//아래의 update() 메소드를 이용해서 회원정보가 수정되도록 해보세요.
		
		Member mem = new Member();
		mem.num = num;
		mem.name = name;
		mem.addr = addr;
		
		update(mem);
		
	}
	
	public static void update(Member m) {
		//Member 객체에 담긴 정보를 이용해서 회원 정보를 수정하도록 해보세요.
		
		Connection conn=null;
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url="jdbc:oracle:thin:@localhost:1521:xe";
	         conn=DriverManager.getConnection(url, "scott", "tiger");
	         
	         System.out.println("Oracle DB 접속 성공");
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	    	  //실행할 sql 문
	    	  String sql = "UPDATE member"
		    			+ " SET name = ?, addr = ?"
		    			+ " WHERE num = ?";

	    	  //SELECT 문 실행하고 결과 값을 ResultSet으로 얻어내기
	    	  pstmt = conn.prepareStatement(sql);
	    	  //PreparedStatement 객체의 메소드를 이용해서 미완성이 sql문을 완성시키기(? 에 값 바인딩하기)
			    pstmt.setString(1, m.name); // 1번째 ? 에 문자열 바인딩
			    pstmt.setString(2, m.addr); // 2번째 ? 에 문자열 바인딩
			    pstmt.setInt(3, m.num); // 3번째 ? 에 정수 바인딩
			    //sql 문 실행하기
			    pstmt.executeUpdate();
			    System.out.println("회원 정보를 수정했습니다.");
	    	  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
