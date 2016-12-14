package db_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class Comm2DB {
	public String doRegularQuery(String head) {
		StringBuffer buffer = new StringBuffer();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb?user=hj&password=test1234&useSSL=true");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT description FROM people where name LIKE \""+head+"%\";");
			while(rs.next()) {
				System.out.println(rs.getString("description"));
				buffer.append(rs.getString("description"));
				buffer.append("\n");
			}
			conn.close();
			
			
        } catch (SQLException ex) {
            // handle the error
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
			e.printStackTrace();
		}
		
		return(buffer.toString());
    
	}
    public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Comm2DB com = new Comm2DB();
		boolean isEnd = false;
		while(!isEnd) {
			try {
				System.out.print("input: ");
				String head = reader.readLine();
				if(head.equals("QUIT.")) isEnd = true;
				else {
					System.out.println(com.doRegularQuery(head));
				}
			} catch(Exception e) {
				System.out.println(e);
				isEnd = true;
			}
		}
	}
}
