package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Students;

public class StudentDAO {
	
	public List<Students> getAllStudents() 
	{
		List<Students> studentList = new ArrayList<Students>();
		
	try {

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "0000");
		
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM students");
		while (rs.next()) {
			Students std = new Students();
			std.setStdid(rs.getInt(1));
			std.setStdname(rs.getString(2));
			std.setDob(rs.getDate(3));
			std.setParent(rs.getString(4));
			std.setContact(rs.getString(5));
			std.setCid(rs.getInt(6)); 
			studentList.add(std);
		}
		
		statement.close();
		connection.close();

	} catch (Exception ex) {
		System.out.println(ex.getMessage());
	}
	return studentList;
}
	

}
