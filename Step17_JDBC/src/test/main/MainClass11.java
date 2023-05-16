package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		int num = 3; //삭제할 회원의 번호라고 가정
		
		//아래의 delete() 메소드를 이용해서 회원 정보를 삭제해보세요.
		delete(num);
	}
	
	public static void delete(int num) {
		//인자로 전달된 num에 해당하는 회원정보를 삭제하는 기능을 완성해보세요.
		//DBConnect 클래스를 활용하세요
		
		Connection conn=null;
	    PreparedStatement pstmt = null;
	    try {
	    	conn = new DBConnect().getConn();
	    	//실행할 sql 문
	    	String sql = "DELETE FROM member"
		    		+ " WHERE num = ?";
	    	//SELECT 문 실행하고 결과 값을 ResultSet으로 얻어내기
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
