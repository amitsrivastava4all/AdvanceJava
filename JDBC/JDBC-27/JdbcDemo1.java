import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JdbcDemo1 {

	public static ArrayList<Employee> fetchEmployees(String empno) throws ClassNotFoundException, SQLException {
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
		PreparedStatement pstmt = con.prepareStatement("select id,name,salary from emp where id=?");
		pstmt.setInt(1, Integer.parseInt(empno));
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

}
