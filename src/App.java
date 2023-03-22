// package jdbc;
// package com.mysql.cj.jdbc;
// import com.mysql.jdbc.Driver;
import java.sql.*;
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo"; //Name of DataBase
        String username = "root";
        String password = "4321@anant";
        // String query = "INSERT INTO PERSONS VALUES ('7', 'Rakshit', 'Yadav');";
        // String query1 = "USE DEMO;INSERT INTO PERSONS VALUES ('7', 'Rakshit', 'Yadav');";
        // String query2 = "select FirstName from Persons where PersonID = 3;";
        String query3 = "select * from Persons;";
        // Load driver class
        Class.forName(driverClassName);
        System.out.println("Hello Ji!");
        // Obtain a connection
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Kya Ji!");
        // Obtain a statement
        Statement st = con.createStatement();
 
        // Execute the query
        ResultSet rs = st.executeQuery(query3);
        while(rs.next()){
            String fname = rs.getString("FirstName");
            String lname = rs.getString("LastName");
            System.out.println("Full Name = "+fname+" "+lname);
        }
        // String name = rs.getString("FirstName");
        // System.out.println("name = "+name);
        // st.executeQuery(query);
        // System.out.println(rs);
        // Closing the connection as per the requirement with connection is completed
        st.close();
        con.close();
    }
}