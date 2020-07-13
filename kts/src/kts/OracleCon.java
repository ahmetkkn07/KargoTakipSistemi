package kts;

import java.sql.*;

class OracleCon {

    public Connection con = null;
   
    public Connection OracleCon(Connection con) 
    {      
        con = null;
        String url = "jdbc:oracle:thin:@" + DatabaseInfo.serverName + ":" + DatabaseInfo.portNumber +  ":" + DatabaseInfo.sid;
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }       
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Driver Bulunamadı.");  
        }
        
        try 
        {
            con = DriverManager.getConnection(url, DatabaseInfo.userName, DatabaseInfo.password);
            //System.out.println("Bağlantı Başarılı...");
            return con;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Bağlantı Başarısız...");
            ex.printStackTrace();
        }
       return con;
    }
   
}