package com.Bridge;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.cj.protocol.Resultset;


public class Bridge {
	static Connection con=null;
	static Properties prop=null;
	
	static {
	prop=new Properties();
	try {
		prop.load(Bridge.class.getClassLoader().getResourceAsStream("db.properties"));
		Class.forName(prop.getProperty("driver"));
		con=DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("user"),prop.getProperty("password"));
	} catch (IOException | ClassNotFoundException | SQLException e) {


		e.printStackTrace();
	}
	
	

	}

	public static Connection opencon() {
		
		
		return con;
	}
	public static void closeCon(Connection con,PreparedStatement ps) {
		try {
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	public static void main(String[] args) {
//		System.out.println(prop.getProperty("driver"));
//		System.out.println(prop.getProperty("url"));
		System.out.println(con);
	}

}

