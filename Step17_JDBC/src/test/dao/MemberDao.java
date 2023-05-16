package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 * Data Access Object 만들어 보기
 * 
 * - DB에 insert, update, delete, select 작업을 대신 해주는 객체를 생성할 클래스 설계하기
 */
public class MemberDao {
	
	//회원 한명의 정보를 저장하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean insert(MemberDto dto) {
		
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row의 갯수를 담을 변수
		int rowCount = 0; //초기값을 0으로 부여한다.
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 문
			String sql = "INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//sql 문이 ?가 존재하는 미완성이라면 여기서 완성한다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			
			//insert or update or delete 문을 실제 수행한다. 변화된 row의 갯수가 리턴된다.
			rowCount = pstmt.executeUpdate(); //수행하고 리턴되는 값을 변수에 담는다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		//변화된 row의 갯수가 0보다 크면 작업 성공
		if(rowCount > 0) {
			System.out.println("회원정보를 성공적으로 저장하였습니다.");
			return true;
		} else { //그렇지 않으면 작업 실패
			return false;
		}
		
	}
	
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int rowCount = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member"
					+ " WHERE num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
					
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		if(rowCount > 0) {
			System.out.println("회원정보를 성공적으로 삭제하였습니다.");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int rowCount = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE member"
					+ " SET name = ?, addr = ?"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
					
			rowCount = pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
		if(rowCount > 0) {
			System.out.println("회원정보를 성공적으로 수정하였습니다.");
			return true;
		} else { 
			return false;
		}
	}
}
