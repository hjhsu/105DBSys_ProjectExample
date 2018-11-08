<%@ page contentType="text/html; charset=big5" import="java.sql.*, java.util.*" %> 
<form name="form1" method="post" action="" >
文字輸出欄位: <input name="MyHead">
<input type="submit" value="送出">
</form>
<%
	String head = request.getParameter("MyHead");
	if (head != null) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb?user=hj&password=test1234&useSSL=true&serverTimezone=CST");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT description FROM people where name LIKE \""+head+"%\";");
			while(rs.next()) {
				out.println(rs.getString("description")+"<p>");
			}
			conn.close();
			
		} catch (SQLException ex) {
			// handle the error
			out.println("SQLException: " + ex.getMessage());
			out.println("SQLState: " + ex.getSQLState());
			out.println("VendorError: " + ex.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>

