package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.AssignClass;

public class AssignClassDAO {
		
	public List<AssignClass> getAllAssignClass() 
	{
		List<AssignClass> assignClassList = new ArrayList<AssignClass>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "0000");
			
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM assignclass");
			while (rs.next()) {
				AssignClass ac = new AssignClass();
				ac.setSno(rs.getInt(1));
				ac.setClassid(rs.getInt(2));
				ac.setSubjectid(rs.getInt(3));
				ac.setTeacherid(rs.getInt(4));
				assignClassList.add(ac);
			}
			
			statement.close();
			connection.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return assignClassList;
	}
	
	
	
	
}
