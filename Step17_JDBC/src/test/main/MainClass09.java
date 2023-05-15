package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dto.MemberDto;
import test.mypac.Member;

public class MainClass09 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "에이콘";
		String addr = "강남역";
		
		//아래의 insert() 메소드를 활용해서 위의 회원 정보가 DB에 저장되도록 프로그래밍 해보세요.
		MemberDto mem = new MemberDto();
		mem.setName(name);
		mem.setAddr(addr);
		
		insert(mem);
		
	}
	
	public static void insert(MemberDto mem) {
		//인자로 전달된 MemberDto 객체에 담긴 내용을 이용해서 DB에 회원 정보가 저장되도록 해보세요.
		
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
	    	  String sql = "INSERT INTO member"
		    			+ " (num, name, addr)"
		    			+ " VALUES(member_seq.NEXTVAL, ?, ?)";

	    	  //SELECT 문 실행하고 결과 값을 ResultSet으로 얻어내기
	    	  pstmt = conn.prepareStatement(sql);
		    	//PreparedStatement 객체의 메소드를 이용해서 미완성이 sql문을 완성시키기(? 에 값 바인딩하기)
		    	pstmt.setString(1, mem.getName()); // 1번째 ? 에 문자열 바인딩
		    	pstmt.setString(2, mem.getAddr()); // 2번째 ? 에 문자열 바인딩
		    	//sql 문 실행하기
		    	pstmt.executeUpdate();
		    	System.out.println("회원 정보를 저장했습니다.");
	    	  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
