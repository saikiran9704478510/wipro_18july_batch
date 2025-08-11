package LabSession29thJuly;
import java.sql.*;


import java.lang.ClassNotFoundException;

public class jdbcOperation {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String dbURL = "jdbc:mysql://localhost:3306/companydb";
		String username = "root";
		String password = "mysql";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection con = DriverManager.getConnection(dbURL, username, password);
		
		
		Statement st = con.createStatement();
		
		
		
		
		 String sql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";

         // Create PreparedStatement
         PreparedStatement pstmt = con.prepareStatement(sql);

         // 1st row
         pstmt.setInt(1, 101);
         pstmt.setString(2, "Alice");
         pstmt.setString(3, "HR");
         pstmt.setDouble(4, 50000);
        // pstmt.executeUpdate();

         // 2nd row
         pstmt.setInt(1, 102);
         pstmt.setString(2, "Bob");
         pstmt.setString(3, "IT");
         pstmt.setDouble(4, 65000);
         //pstmt.executeUpdate();

         // 3rd row
         pstmt.setInt(1, 103);
         pstmt.setString(2, "Charlie");
         pstmt.setString(3, "Sales");
         pstmt.setDouble(4, 60000);
         //pstmt.executeUpdate();

         String selectquery = "select * from employees;";
         ResultSet rs = st.executeQuery(selectquery);
 		
		
		
		
		while (rs.next()) {
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("department"));
			System.out.println(rs.getString("salary"));
			System.out.println("=================");
		}
		
		
		//question 2
		
		String queryById = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement pstmtById = con.prepareStatement(queryById);
        pstmtById.setInt(1, 102);

        ResultSet rs1 = pstmtById.executeQuery();
        System.out.println("Result for ID = 102:");
        while (rs1.next()) {
            System.out.println(rs1.getInt("id") + " | " +
                               rs1.getString("name") + " | " +
                               rs1.getString("department") + " | " +
                               rs1.getDouble("salary"));
        }
        
        // question 3
        
     // 2. SELECT WHERE department = 'IT'
        // ================================
        String queryByDept = "SELECT * FROM employees WHERE department = ?";
        PreparedStatement pstmtByDept = con.prepareStatement(queryByDept);
        pstmtByDept.setString(1, "IT");

        ResultSet rs2 = pstmtByDept.executeQuery();
        System.out.println("\nResult for department = 'IT':");
        while (rs2.next()) {
            System.out.println(rs2.getInt("id") + " | " +
                               rs2.getString("name") + " | " +
                               rs2.getString("department") + " | " +
                               rs2.getDouble("salary"));
        }

	}

}