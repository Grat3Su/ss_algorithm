package loginout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.UserDto;

public class LoginoutDaoImpl implements LoginoutDao{

	@Override
	public UserDto login(String userEmail) {

		UserDto userdto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ConnectionPool 로부터 Connection 객체를 얻는다.
			// ConnectionPool 을 먼저 java 실행환경 (Tomcat)으로 부터 이름을 전달하고 그 객체를 얻는다.

			con = DBManager.getConnection();

			// Statement 객체 - select
			StringBuilder sb = new StringBuilder();
			sb.append("select user_id, user_name, user_email, user_password from users_db ")
					.append("where user_email=?;");
			// pstmt = con.prepareStatement("select user_id, user_name, user_email,
			// usaer_password from users_db;");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userdto = new UserDto(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_email"),
						rs.getString("user_password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		return userdto;
	}

}
