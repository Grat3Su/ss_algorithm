package main.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import common.DBManager;
import dto.SidoDto;

public class MainDaoImpl implements MainDao{
	public List<SidoDto> sidoList(){
		
		List<SidoDto> list = new ArrayList<>();
		
		 Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            // ConnectionPool 로부터 Connection 객체를 얻는다.
	            // ConnectionPool 을 먼저 java 실행환경 (Tomcat)으로 부터 이름을 전달하고 그 객체를 얻는다.
	           

	            con = DBManager.getConnection();

	            // Statement 객체 - select
	            pstmt = con.prepareStatement("select sido_code, sido_name from enjoytrip.sido;");
	            
	            rs = pstmt.executeQuery();
	            while( rs.next() ) {
	                // 테이블 컬럼의 타입에 맞게 ResultSet 객체의 getXXX() 호출하고 결과를 받는다.
	                int sidoCode = rs.getInt("sido_code");
	                String sidoName = rs.getString("sido_name");
	                SidoDto dto = new SidoDto(sidoCode, sidoName);
	                
//	                SidoDto dto2 = new SidoDto();
//	                dto2.setSidoCode(sidoCode);
//	                gro2
	                list.add(dto);
	            }

	        }catch(Exception e) {
	            e.printStackTrace();
	        }finally {
	            DBManager.releaseConnection(rs, pstmt, con);
	        }
	        return list;
	}
}
