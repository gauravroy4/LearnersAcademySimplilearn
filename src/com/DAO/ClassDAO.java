package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Classes;


public class ClassDAO {
	
	public List<Classes> getAllClasses() 
	{
		List<Classes> classList = new ArrayList<Classes>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "0000");
			
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM class");
			while (rs.next()) {
				Classes cls = new Classes();
				cls.setClassid(rs.getInt(1));
				cls.setClassname(rs.getString(2));
				cls.setSection(rs.getString(3));
				classList.add(cls);
			}
			
			statement.close();
			connection.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return classList;
	}

}
