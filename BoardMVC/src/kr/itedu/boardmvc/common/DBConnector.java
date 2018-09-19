package kr.itedu.boardmvc.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {	
	public static Connection getConn() throws SQLException {
		DataSource ds = null;
		
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/OracleDB");
		} catch (NamingException e) {
			// TODO: 예외처리
		}		
			
		return ds.getConnection();
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void close(Connection conn, PreparedStatement ps) {
		close(conn, ps, null);
	}

}
