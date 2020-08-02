import java.sql.*;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		int prod_no;
		String prod_name;
		float prod_price;
		int quantity;
		float tax;
		float discount;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product no,product name,product price,quantity,tax,discount ");
		prod_no=sc.nextInt();
		prod_name=sc.next();
		prod_price=sc.nextFloat();
		quantity=sc.nextInt();
		tax=sc.nextFloat();
		discount=sc.nextFloat();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver load zala reeeee");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/super","root","nikhil");
			System.out.println("Connection established...");
		PreparedStatement pstmt=con.prepareStatement("insert into admin values(?,?,?,?,?,?)");
			
			pstmt.setInt(1, prod_no);
			pstmt.setString(2,prod_name);
			pstmt.setFloat(3,prod_price);
			pstmt.setInt(4,quantity);
			pstmt.setFloat(5,tax);
			pstmt.setFloat(6,discount);
			pstmt.execute();
			
			
			System.out.println("row inserted...");
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
}
