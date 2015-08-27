import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load the Driver or Loading a Driver Class
		//oracle.jdbc.driver.OracleDriver
		Class.forName("com.mysql.jdbc.Driver");
		// Step -2 Create Connection
		//jdbc:oracle:thin:@hostname:portno:dbname
		//jdbc:mysql://hostname:port/dbname
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/javabatch_db","root","root");
		
		// Step-3 Do Query
		Statement stmt = con.createStatement();
		// Step-4 Execute Query and Take The Result
		ResultSet rs = stmt.executeQuery("select id, name ,salary from emp");
		// Step - 5 Traverse the Records
		while(rs.next()){
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
		}
		
		// Step -6 Close all the Open Resources
		rs.close();
		stmt.close();
		con.close();

	}

}
