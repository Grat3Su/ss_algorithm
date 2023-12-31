package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DBManager class
public class Test4 {

    public static void main(String[] args){
        
        // SQL
        String insertSql = "insert into customer values (?, ?);";
        String updateSql = "update customer set customer_nm = ? where customer_id=?;";
        String deleteSql = "delete from customer where customer_id=?;";
        String selectSql = "select * from customer where customer_id > ?;";
        
        // 자료구조 및 객체
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int ret = -1;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            con = DBManager.getConnection();

            // insert
//            pstmt = con.prepareStatement(insertSql);    
//            pstmt.setInt(1, 4);
//            pstmt.setString(2, "사길동");
//            ret = pstmt.executeUpdate();
            
            
            // update
//            pstmt = con.prepareStatement(updateSql);    
//            pstmt.setString(1, "사길동2");
//            pstmt.setInt(2, 4);            
//            ret = pstmt.executeUpdate();
            
            // delete
//            pstmt = con.prepareStatement(deleteSql);    
//            pstmt.setInt(1, 4);                        
//            ret = pstmt.executeUpdate();
//            
//            System.out.println(ret);
            
            // Statement 객체 - select
            pstmt = con.prepareStatement(selectSql);    
            pstmt.setInt(1, 1);    
            rs = pstmt.executeQuery();
            while( rs.next() ) {
                // 테이블 컬럼의 타입에 맞게 ResultSet 객체의 getXXX() 호출하고 결과를 받는다.
                int customer_id = rs.getInt("customer_id");
                String customer_nm = rs.getString("customer_nm");
                System.out.println(customer_id + " / " + customer_nm);            
            }
            
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DBManager.releaseConnection(rs, pstmt, con);
        }
    }
}




