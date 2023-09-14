package basic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectionPoolTestServlet
 */
@WebServlet("/ConnectionPoolTestServlet")
public class ConnectionPoolTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConnectionPoolTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int ret = -1;
        
        try {
            // Connection Pool 을 가져올 수 있음 (Data Source 타입)
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
            
            con = ds.getConnection();
            
            System.out.println(con);
            
            
            // select
            pstmt = con.prepareStatement("select * from customer where customer_id > ?;");
            pstmt.setInt(1, 1);
            rs = pstmt.executeQuery();
            
            // rs.next -> true 다음 원소가 있다는 뜻
            while(rs.next()) {
                // 테이블 컬럼의 타입에 맞게 Result Set 객체의 get...() 호출하고 결과를 받는다.
                int customer_id = rs.getInt("customer_id");
                String customer_nm = rs.getString("customer_nm");
                
                System.out.println(customer_id + " / " + customer_nm);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 귀한 자원 rs, stmt, con 의 순서대로 null check 하면서 close() 를 해줘야한다.
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close(); // 커넥션 풀로 부터 불러온 데이터를 반납
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}