package test_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {
        //The code below is to check to make sure you have a database connection with MySQL
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/?user=hbemployee";
        String user = "hbemployee";
        String password = "hbemployee"; // You can change the password to check to see if it throws an exception.
        try{
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful!!!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
