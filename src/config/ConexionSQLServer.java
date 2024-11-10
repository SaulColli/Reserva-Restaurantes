/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ThinkPad
 */
public class ConexionSQLServer {
    public ConexionSQLServer(){    
    }
    
    public Connection Conectar() throws ClassNotFoundException, SQLException{
        
        ConfigLoader config = new ConfigLoader();
        
        
        String database = config.getenv("DB_NAME");
        String server = config.getenv("DB_SERVER");
        String user = config.getenv("DB_USER");
        String password = config.getenv("DB_PASSWORD");
        String port = config.getenv("DB_PORT");
        System.out.println(port);
        System.out.println(database);
        Connection con = null;
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://" + server + ":" + port +";databaseName=" + database + ";user=" + user +";password=" + password + ";encrypt=true;trustServerCertificate=true";
            System.out.println(connectionURL);
            con = DriverManager.getConnection(connectionURL);
            System.out.println("Nos conectamos");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
        
        /*
        Statement st = con.createStatement(); 
        ResultSet rs = st.executeQuery("SELECT * FROM Cliente");
        
        
        System.out.print(rs.next());
        System.out.println(rs.getString("Nombre"));
*/
    }
}
