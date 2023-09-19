package regist.dao;

import common.DBManager;
import dto.UserDto;

public class RegistDaoImpl implements RegistDao{

    @Override
    public UserDto join(String userID, String userName, String password) {
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
			sb.append("INSERT INTO users (userID, name, password) VALUES (?, ?, ?)");//insert
			// pstmt = con.prepareStatement("select user_id, user_name, user_email,
			// usaer_password from users_db;");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userID);
			pstmt.setString(2, userName);
			pstmt.setString(3, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userdto = new UserDto(rs.getString("userID"), rs.getString("name"),
						rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		return userdto;
	}

    @Override
    public RegistDaoImpl joinout() {//회원탈퇴는 id만 있으면 된다
        UserDto userdto = null;
        String userID = request.getParameter("userID");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ConnectionPool 로부터 Connection 객체를 얻는다.
			// ConnectionPool 을 먼저 java 실행환경 (Tomcat)으로 부터 이름을 전달하고 그 객체를 얻는다.

			con = DBManager.getConnection();

			// Statement 객체 - select
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM users WHERE userID = ?;");//회원 탈퇴
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
            if (rs.next()) {
				userdto = new UserDto(rs.getString("userID"), rs.getString("name"),
						rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
        return userdto;

	} 
    
}
