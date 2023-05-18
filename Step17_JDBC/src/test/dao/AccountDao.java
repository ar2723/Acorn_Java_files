package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.AccountDto;
import test.dto.MemberDto;
import test.util.DBConnect;

public class AccountDao {
	
	public List<AccountDto> getList(){
		//회원 정보를 누적할 객체 생성
		List<AccountDto> list = new ArrayList<>();
		
		//필요한 객체를 담을 지역 변수를 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select 문)
			String sql = "SELECT * FROM account"
					+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출한다.
			while (rs.next()) {
				AccountDto dto = new AccountDto();
				dto.setNum(rs.getInt("num"));
				dto.setDay(rs.getString("day"));
				dto.setItem(rs.getString("item"));
				dto.setIncome(rs.getInt("income"));
				dto.setExpense(rs.getInt("expense"));
				dto.setBalance(rs.getInt("balance"));
				
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
		//회원 정보가 누적된 List 객체의 참조값을 리턴한다.
		return list;
	}
	
	public boolean insertIncome(AccountDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "INSERT INTO account"
					+ " (num, day, item, income)"
					+ " VALUES(account_seq.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDay());
			pstmt.setString(2, dto.getItem());
			pstmt.setInt(3, dto.getIncome());
			
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
		
		if(rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean insertExpense(AccountDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		try {
			conn = new DBConnect().getConn();
			String sql = "INSERT INTO account"
					+ " (num, day, item, expense)"
					+ " VALUES(account_seq.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDay());
			pstmt.setString(2, dto.getItem());
			pstmt.setInt(3, dto.getExpense());
			
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
		
		if(rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int rowCount = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM account"
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
			return true;
		} else {
			return false;
		}
	}
	
	public boolean updateBalance(int num, int balance) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    boolean result = false;

	    try {
	        conn = new DBConnect().getConn();
	        String sql = "UPDATE account "
	        		+ "SET balance = ? WHERE num = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, balance);
	        pstmt.setInt(2, num);
	        int count = pstmt.executeUpdate();

	        if(count > 0) {
	            result = true;
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return result;
	}
}
