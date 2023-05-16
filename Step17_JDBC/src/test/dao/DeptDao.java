package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.dto.MemberDto;
import test.util.DBConnect;

public class DeptDao {
	
	//인자로 전달되는 부서 번호에 해당하는 부서의 정보를 리턴하는 메소드
	public DeptDto getData(int num) {
		DeptDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select 문)
			String sql = "SELECT * FROM dept"
					+ " WHERE deptno = ?";
			pstmt = conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.
			pstmt.setInt(1, num);
			//select문을 수행하고 결과를 ResultSet으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출해서 사용한다.
			while(rs.next()) {
				dto = new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	//전체 부서의 정보를 리턴하는 메소드
	public List<DeptDto> getList(){
		//회원 정보를 누적할 객체 생성
		List<DeptDto> list = new ArrayList<>();
			
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select 문)
			String sql = "SELECT * FROM dept"
						+ " ORDER BY deptno DESC";
			pstmt = conn.prepareStatement(sql);
			//select 문이 미완성이라면 여기서 완성한다.

			//select문을 수행하고 결과를 ResultSet으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출한다.
			while (rs.next()) {
				//row에 있는 부서 정보를 DeptDto 객체에 담아서
				DeptDto dto = new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				//List에 누적시킨다.
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		//부서 정보가 누적된 List 객체의 참조값을 리턴한다.
		return list;
	}
	
	//부서 한개의 정보를 저장하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean insert(DeptDto dto) {
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
			
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 문
			String sql = "INSERT INTO dept"
					+ " (deptno, dname, loc)"
					+ " VALUES(?, ?, ?)";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//sql 문이 ?가 존재하는 미완성이라면 여기서 완성한다.
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
				
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
			System.out.println("부서정보를 성공적으로 저장하였습니다.");
			return true;
		} else { //그렇지 않으면 작업 실패
				return false;
		}
	}
	
	//부서 하나의 정보를 삭제하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int rowCount = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM dept"
						+ " WHERE deptno = ?";

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
			System.out.println("부서정보를 성공적으로 삭제하였습니다.");
			return true;
		} else {
			return false;
		}
	}
		
	//부서 하나의 정보를 수정하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean update(DeptDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		int rowCount = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE dept"
					+ " SET dname = ?, loc = ?"
					+ " WHERE deptno = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			pstmt.setInt(3, dto.getDeptno());
						
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
			System.out.println("부서정보를 성공적으로 수정하였습니다.");
			return true;
		} else { 
			return false;
		}
	}
}
