/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoVu_SinhVien;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Win10
 */
public class JDBC {
    
    static public Connection conn()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/qlsv";
        Connection c = (Connection) DriverManager.getConnection(url, "root", "1234");
        return c;
    }
    
    public void putData(String sql)throws Exception{
        Connection c=conn();
        Statement s=(Statement) c.createStatement();
        s.executeUpdate(sql); 
    }
    
    public ResultSet getData(String get)throws Exception{
        Connection c=conn();
        Statement s=(Statement) c.createStatement();
        ResultSet rs=s.executeQuery(get);
        return rs;
    }
    public static void main(String []args) throws Exception{
        System.out.println(conn());
    }
}
