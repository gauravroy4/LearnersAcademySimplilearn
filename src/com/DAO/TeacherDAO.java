package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Teachers;

public class TeacherDAO {
	
	public List<Teachers> getAllTeachers() 
	{
		List<Teachers> teacherList = new ArrayList<Teachers>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "0000");
			
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM teachers");
			while (rs.next()) {
				Teachers sub = new Teachers();
				sub.setTid(rs.getInt(1));
				sub.setTname(rs.getString(2));
				sub.setContact(rs.getString(3));
				teacherList.add(sub);
			}
			
			statement.close();
			connection.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return teacherList;
	}
}
