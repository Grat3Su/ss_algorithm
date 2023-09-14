package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.SetOfIntegerSyntax;

// PreparedStatement 사용
// sql 문자열 속에 파라미터를 지정 => ?

public class Test3 {

	public static void main(String[] args) {
		//DB 연결 url  <- jdbc url <-dbms 마다 다르다
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "songsing121@";

		//SQL
		String insertSql = "insert into customer values(?,?);";
		String updateSql = "update customer set customer_nm = ? where customer_id=?;";
		String deleteSql = "delete from customer where customer_ㅑㅇ = ?;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;//return value
		
		//connection 객체 생성
		//JDBC Driver 추가 해야 해
		//jdbc driver class memory load(Class.forName()) <- 최근 버전 필요없음
		// JDBC Driver Class의 코드 안에서 static initializer 를 이용해서 자기 자신 객체를 JDBC Driver 객체에  등록
		//JDBC Driver로부터 Connection 객체를 얻는다
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url,user,pwd);

			//Statement 객체 생성 및 SQL 실행
			//insert
			pstmt = con.prepareStatement(insertSql);
			pstmt.setInt(1,4);
			pstmt.setString(2,"사길동");
			ret = pstmt.executeUpdate();
			
			//update
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1,"사길동");
			pstmt.setInt(1,4);
			ret = pstmt.executeUpdate();
			
			//delete
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1,4);
			ret = pstmt.executeUpdate();
			
			
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, 1);
			
//		for(int i = 0; i<5; i++)
//		ret = stmt.executeUpdate("insert into customer values("+i+",'홍길동"+ i +"');");
			
			System.out.println(ret);
			
			//statement 객체 - select
			//rs = stmt.executeQuery(selectSql);
			while(rs.next()) {
				//테이블 col의 타입에 맞게 resultSet 객체의 getXXX() 호출하고 결과를 받는다
				int customer_id = rs.getInt("customer_id");
				String customer_nm = rs.getString("customer_nm");
				System.out.println(customer_id +" / "+customer_nm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					//귀한 자원 역순으로, null체크하면서 close()
					rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		System.out.println(con);
		
		
		
	}

}
