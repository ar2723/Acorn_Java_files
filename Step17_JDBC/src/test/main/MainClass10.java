package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num = 1;
		String name = "호빵";
		String addr = "독산동";
		
		// update(new MemberDto(num, name, addr));
		
		//MemberDto 객체를 생성해서
		MemberDto mem = new MemberDto();
		//수정할 회원의 정보를 담고
		mem.setNum(num);
		mem.setName(name);
		mem.setAddr(addr);
		//update() 메소드의 매개변수에 전달해서 회원 정보가 수정되도록 한다.
		update(mem);
	}
	
	public static void update(MemberDto mem) {
		
		Connection conn=null;
	    PreparedStatement pstmt = null;
	      
	    try {
	    	conn = new DBConnect().getConn();
	    	//실행할 sql 문
	    	String sql = "UPDATE member"
	    			+ " SET name = ?, addr = ?"
		    		+ " WHERE num = ?";

	    	//SELECT 문 실행하고 결과 값을 ResultSet으로 얻어내기
	    	pstmt = conn.prepareStatement(sql);
		    //PreparedStatement 객체의 메소드를 이용해서 미완성이 sql문을 완성시키기(? 에 값 바인딩하기)
		    pstmt.setString(1, mem.getName()); // 1번째 ? 에 문자열 바인딩
		    pstmt.setString(2, mem.getAddr()); // 2번째 ? 에 문자열 바인딩
		    pstmt.setInt(3, mem.getNum());
		    //sql 문 실행하기
		    pstmt.executeUpdate();
		    System.out.println("회원 정보를 수정했습니다.");
	    	  
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}
}
