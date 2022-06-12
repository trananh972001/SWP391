/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Context;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    
    
    public Connection connection;
    
    public DBContext()
    {
        try {
            
            String username = "sa";
            String password = "sa";
            String url = "jdbc:sqlserver://ADMIN\\SQLEXPRESS01:1433;;databaseName=FERA_ONL_LEARNING";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().connection);
        } catch (Exception e) {
        }
    }
}
    