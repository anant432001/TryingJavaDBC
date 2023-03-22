import java.sql.*;
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo"; //Name of DataBase
        String username = "root";   //SQL UserName
        String password = "4321@anant"; //SQL Password
        String query = "select * from Persons;"; //Query To Perform
        
        // Load driver class
        Class.forName(driverClassName);
        
        // Obtain a connection
        Connection con = DriverManager.getConnection(url, username, password);
        
        // Obtain a statement
        Statement st = con.createStatement();
 
        // Execute the query
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String fname = rs.getString("FirstName");
            String lname = rs.getString("LastName");
            System.out.println("Full Name = "+fname+" "+lname);
        }
        
        // Closing the connection as per the requirement with connection is completed
        st.close();
        con.close();
    }
}