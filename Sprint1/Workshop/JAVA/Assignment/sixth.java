import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sixth {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employees";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void insertEmployee(int id, String name, int salary) {
        String SQL = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void retrieveEmployees() {
        String SQL = "SELECT id, name, salary FROM employees";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Example usage
        insertEmployee(1, "John Doe", 5000);
        retrieveEmployees();
    }
}
