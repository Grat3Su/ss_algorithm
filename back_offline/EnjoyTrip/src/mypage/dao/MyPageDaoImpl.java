package mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBManager;
import dto.UserDto;

public class MyPageDaoImpl implements MyPageDao{

	@Override
	public UserDto change(String userID, String password) {
		 UserDto userdto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ConnectionPool 로부터 Connection 객체를 얻는다.
			// ConnectionPool 을 먼저 java 실행환경 (Tomcat)으로 부터 이름을 전달하고 그 객체를 얻는다.

			// Statement 객체 - select
			StringBuilder sb = new StringBuilder();
			sb.append("update users set password = ? where userid=?;");//update
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, password);
			pstmt.setString(2, userID);
			pstmt.executeUpdate();//id가 이미 있으면 등록 안될것
			
			System.out.println(rs);
			if (rs.next()) {
				userdto = new UserDto(userID," ",password);//비번체크는 id, pw만 했다
			}
			return userdto;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		return userdto;
	}

}
