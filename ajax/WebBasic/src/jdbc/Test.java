package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*	
java <--> DB(My SQL) 연동방법 : JDBC
Connection 객체
아주아주 귀한 자원 -> 한번 얻었으면 최대한 활용하고 닫는다
만약 DBMS에 반납하지 않으면 큰일난다.
statement 객체 <= static한 문자열 SQL 처리
PreparedStatement 객체 <- 변수를 맨SQL을 미리 parse, compile한 후 반복적ㅇ니 작업은 paramenter만 변경
=> 속도 빠르고 보안에도 유리
resultSet은 grid 형태의 자료구조를 가진다.
next()를 이용해서 다음 행으로 이동 처리
 */
public class Test {

	public static void main(String[] args) {
		//DB 연결 url  <- jdbc url <-dbms 마다 다르다
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "songsing121@";

		//SQL
		String insertSql = "insert into customer values(1,'홍길동');";
		String updateSql = "update customer set customer_nm = '홍길동2' where customer_id=1;";
		String deleteSql = "delete from customer where customer_nm = '홍길동2';";
		String selectSql = "select *  from test.customer;";
		Connection con = null;
		Statement stmt = null;
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
			stmt = con.createStatement();
			//insert
			// ret = stmt.executeUpdate(insertSql);
			
			//update
			// ret = stmt.executeUpdate(updateSql);
			
			//delete
			//ret = stmt.executeUpdate(deleteSql);
			
//		for(int i = 0; i<5; i++)
//		ret = stmt.executeUpdate("insert into customer values("+i+",'홍길동"+ i +"');");
			
			System.out.println(ret);
			
			//statement 객체 - select
			rs = stmt.executeQuery(selectSql);
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
					if(stmt!=null)stmt.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		System.out.println(con);
		
		
		
	}

}
