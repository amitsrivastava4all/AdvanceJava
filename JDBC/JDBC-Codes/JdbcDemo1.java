import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JdbcDemo1 {

	public static ArrayList<Employee> fetchEmployees(EmpDTO empDTO) throws ClassNotFoundException, SQLException {
		boolean isWhere = false;
		StringBuilder sql = new StringBuilder("select id, name ,salary from emp");
		ArrayList<Employee> empList = new ArrayList<>();
		boolean isFound = false;
		/*Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the Empno to Search");
		String empno = scanner.next();*/
		// Load the Driver or Loading a Driver Class
		//oracle.jdbc.driver.OracleDriver
		Class.forName("com.mysql.jdbc.Driver");
		// Step -2 Create Connection
		//jdbc:oracle:thin:@hostname:portno:dbname
		//jdbc:mysql://hostname:port/dbname
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/javabatch_db","root","root");
		
		// Step-3 Do Query
		/*
		 * Dynamic SQL Logic Starts Here
		 */
		if(empDTO.getId()>0){
			sql.append(" where id=").append(empDTO.getId());
			isWhere= true;
		}
		if(empDTO.getName()!=null && empDTO.getName().trim().length()>0){
			if(isWhere){
			sql.append(" and name='").append(empDTO.getName()).append("'");
			}
			else
			{
				sql.append(" where name='").append(empDTO.getName()).append("'");
				isWhere = true;
			}
		}
		if(empDTO.getSalary()>0){
			if(isWhere){
				sql.append(" and salary>").append(empDTO.getSalary());
				}
				else
				{
					sql.append(" where salary>").append(empDTO.getSalary());
					isWhere = true;
				}
		}
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		//boolean result = pstmt.execute("create database amit"); //ddl 
		
		ResultSet rs = pstmt.executeQuery(); //select
		//int r = pstmt.executeUpdate();  // DML(insert , update,delete)
		//Statement stmt = con.createStatement();
		// Step-4 Execute Query and Take The Result
		//ResultSet rs = stmt.executeQuery("select id, name ,salary from emp where id="+empno);
		// Step - 5 Traverse the Records
		while(rs.next()){
			isFound = true;
			Employee empObject = new Employee();
			empObject.setId(rs.getInt("id"));
			empObject.setName(rs.getString("name"));
			empObject.setSalary(rs.getDouble("salary"));
			empList.add(empObject);
			//rs.deleteRow();
			//rs.rowInserted();
			//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
		}
		if(!isFound){
			System.out.println("No Record Found...");
		}
		// Step -6 Close all the Open Resources
		rs.close();
		pstmt.close();
		con.close();
		return empList;
	}

	
	public static ArrayList<Employee> anyEmployees(String any) throws ClassNotFoundException, SQLException {
		boolean isWhere = false;
		StringBuilder sql = new StringBuilder("select id, name ,salary from emp");
		ArrayList<Employee> empList = new ArrayList<>();
		boolean isFound = false;
		/*Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the Empno to Search");
		String empno = scanner.next();*/
		// Load the Driver or Loading a Driver Class
		//oracle.jdbc.driver.OracleDriver
		Class.forName("com.mysql.jdbc.Driver");
		// Step -2 Create Connection
		//jdbc:oracle:thin:@hostname:portno:dbname
		//jdbc:mysql://hostname:port/dbname
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/javabatch_db","root","root");
		
		// Step-3 Do Query
		/*
		 * Dynamic SQL Logic Starts Here
		 */
		if(!isString(any)){
			sql.append(" where id=").append(Integer.parseInt(any));
			isWhere= true;
		}
		if(isString(any)){
			if(isWhere){
			sql.append(" or name='").append(any).append("'");
			}
			else
			{
				sql.append(" where name='").append(any).append("'");
				isWhere = true;
			}
		}
		if(!isString(any)){
			if(isWhere){
				sql.append(" or salary>").append(any);
				}
				else
				{
					sql.append(" where salary>").append(any);
					isWhere = true;
				}
		}
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		//Statement stmt = con.createStatement();
		// Step-4 Execute Query and Take The Result
		//ResultSet rs = stmt.executeQuery("select id, name ,salary from emp where id="+empno);
		// Step - 5 Traverse the Records
		while(rs.next()){
			isFound = true;
			Employee empObject = new Employee();
			empObject.setId(rs.getInt("id"));
			empObject.setName(rs.getString("name"));
			empObject.setSalary(rs.getDouble("salary"));
			empList.add(empObject);
			//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
		}
		if(!isFound){
			System.out.println("No Record Found...");
		}
		// Step -6 Close all the Open Resources
		rs.close();
		pstmt.close();
		con.close();
		return empList;
	}

	public static boolean isString(String data){
		boolean isStringChar = false;
		for(char z : data.toCharArray()){
			if(Character.isAlphabetic(z)){
				isStringChar = true;
				break;
			}
		}
		return isStringChar;
	}
}
