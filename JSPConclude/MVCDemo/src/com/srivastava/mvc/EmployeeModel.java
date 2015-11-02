package com.srivastava.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
	
	private Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mvc","root","root");
		return con;
	}
	
	public ArrayList<EmployeeDTO> searchBySalary(double salary) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> empList = new ArrayList<>();
		try{
			con = this.createConnection();
			pstmt = con.prepareStatement("select id , name,salary from employee where salary>?");
			pstmt.setDouble(1, salary);
			rs = pstmt.executeQuery();
			while(rs.next()){
				EmployeeDTO empDTO = new EmployeeDTO();
				empDTO.setId(rs.getInt("id"));
				empDTO.setName(rs.getString("name"));
				empDTO.setSalary(rs.getDouble("salary"));
				empList.add(empDTO);
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return empList;
	}

}
