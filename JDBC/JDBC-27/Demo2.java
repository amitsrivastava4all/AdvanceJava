import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Demo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Empno");
		int empno = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Name");
		String name = scanner.nextLine();
		System.out.println("Enter the Salary ");
		double salary = scanner.nextDouble();
		//Insert
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/javabatch_db","root","root");
		Statement stmt = con.createStatement();
		// 					insert into emp(id,name,salary) values(1001,'Ram',9000);
		int noOfRecord = stmt.executeUpdate("insert into emp (id,name,salary) values("+empno+",'"+name+"',"+salary+")");
		if(noOfRecord>0){
			System.out.println("Record Added... "+noOfRecord);
		}
		else
		{
			System.out.println("Not Added..");
		}
		stmt.close();
		con.close();
	}

}
