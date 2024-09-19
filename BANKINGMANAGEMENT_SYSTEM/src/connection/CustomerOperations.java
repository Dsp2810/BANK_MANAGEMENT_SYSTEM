package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CustomerOperations {
    public static void insertUser(String name, String email, String password, String phoneNumber) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Get the connection
            connection = DatabaseConnection.getConnection();

            // SQL query to insert data into the 'users' table
            String sql = "INSERT INTO users (name, email, password, phone_number, created_at) VALUES (?, ?, ?, ?, NOW())";

            // Create PreparedStatement object
            pstmt = connection.prepareStatement(sql);

            // Set the values for the query
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, phoneNumber);

            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the PreparedStatement and Connection
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        public static void deleteUser(int userId) {
            Connection connection = null;
            PreparedStatement pstmt = null;

            try {
                // Get the connection
                connection = DatabaseConnection.getConnection();

                // SQL query to delete the user based on user_id
                String sql = "DELETE FROM users WHERE user_id = ?";

                // Create PreparedStatement object
                pstmt = connection.prepareStatement(sql);

                // Set the user_id for the query
                pstmt.setInt(1, userId);

                // Execute the query
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("User was deleted successfully!");
                } else {
                    System.out.println("No user found with the given user_id.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the PreparedStatement and Connection
                try {
                    if (pstmt != null) pstmt.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
        public static void getAllUsers() {
            Connection connection = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                // Get the connection
                connection = DatabaseConnection.getConnection();

                // SQL query to select all users
                String sql = "SELECT * FROM users";

                // Create PreparedStatement object
                pstmt = connection.prepareStatement(sql);

                // Execute the query and get the result set
                rs = pstmt.executeQuery();

                // Print the column headers
                System.out.printf("%-10s %-20s %-30s %-10s %-15s %-20s\n", "user_id", "name", "email", "password", "phone_number", "created_at");
                System.out.println("---------------------------------------------------------------------------------------------");

                // Iterate through the result set and print each row
                while (rs.next()) {
                    int userId = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String phoneNumber = rs.getString("phone_number");
                    String createdAt = rs.getString("created_at");

                    // Print the user data
                    System.out.printf("%-10d %-20s %-30s %-10s %-15s %-20s\n", userId, name, email, password, phoneNumber, createdAt);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the ResultSet, PreparedStatement, and Connection
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        // Example of inserting a user
    	getAllUsers();
    	insertUser("Banti", "banti123@gmail.com", "password123", "1234567890");
//    	deleteUser(3);
//    	getAllUsers();
    }
}
