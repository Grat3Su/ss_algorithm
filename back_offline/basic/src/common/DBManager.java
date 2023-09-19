package common;

import java.sql.*;


import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.Context;


public class DBManager {
	public static Connection getConnection() {
        Connection con = null;

        try {
        	Context context = new InitialContext();
        	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/enjoytrip");
            con = ds.getConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
	
	public static void releaseConnection(ResultSet rs, PreparedStatement  pstmt, Connection con) {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
