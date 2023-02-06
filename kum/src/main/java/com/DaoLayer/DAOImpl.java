package com.DaoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bridge.Bridge;
import com.Quary.MysqlQuary;
import com.model.Student;

public class DAOImpl implements DAO{
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs= null;

	@Override
	public List<Student> getAllStudent() {
		
		List<Student>list=new ArrayList();
		con=Bridge.opencon();
		Student s=new Student();
		try {
			ps=con.prepareStatement(MysqlQuary.FIND_ALL_QUERY);
			rs=ps.executeQuery();
			while(rs.next()) {
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			list.add(s);
		} 
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return null;
	}

}
