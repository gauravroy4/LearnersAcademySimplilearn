package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Subjects;



public class SubjectDAO {
	
	public List<Subjects> getAllSubjects() 
	{
		List<Subjects> subjectList = new ArrayList<Subjects>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "0000");
			
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM subjects");
			while (rs.next()) {
				Subjects sub = new Subjects();
				sub.setSubid(rs.getInt(1));
				sub.setSubname(rs.getString(2));
				sub.setLanguage(rs.getString(3));
				subjectList.add(sub);
			}
			
			statement.close();
			connection.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return subjectList;
	}
	
}
