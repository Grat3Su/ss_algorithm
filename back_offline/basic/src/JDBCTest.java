import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBManager;

public class JDBCTest {
	static Connection con = null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//jdbc driver memory loading... <= class.forname()
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection<=driver manager.getConnection()<=id pwd, url
		
		con = (Connection) DriverManager.getConnection("root","1234","jdbc:mysql://localhost:3306/enjoytrip");
		
		//statement, preparedstatement<= connection
		
		
		//insert delete update -> execute update
		//select -> execute query <= resultset 객체 <= 목록 상세 출력
		
		//자원반납 - close
		con.close();
		//sql exception <- try catch autoclosable
		
	}
	public int insertEmp() {
		PreparedStatement pstmt = null;// ? 를 채우는 뭐시기였음
		
		int ret = -1;
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("insert into users(user_name, user_email, user_password) ");
			sb.append( "values(?,?,?)");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, "김아림");
			pstmt.setString(2, "whereArim@gmail.com");
			pstmt.setString(3, "1234");
			
			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	public int updateEmp() {
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("update users set user_name=?");
			sb.append(" where user_id = ?");
			
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setString(1, "아림");
			pstmt.setInt(2, 2);
						
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public int deleteEmp() {
		PreparedStatement pstmt = null;
		int ret = -1;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("delete from users ");
			sb.append(" where user_id = ?")
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, 2);
			
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void selectEmp() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectDetailEmp() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sb = new StringBuilder();
			
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
