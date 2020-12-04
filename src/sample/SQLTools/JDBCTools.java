package sample.SQLTools;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sample.Model.*;
import com.mysql.cj.jdbc.Driver;
import sample.system.SystemControl;

public class JDBCTools {
    public static Connection getConnect() {
        Connection conn = null;
        String url;
        Properties p = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream("sql.properties");
            p.load(in);
            url = "jdbc:mysql://" + p.getProperty("host") + ":"
                    + p.getProperty("port") + "/" + p.getProperty("database");
                    //+ "?/useUnicode=true&characterEncoding=utf-8";
//            System.out.println(url);
            in.close();
            conn = DriverManager.getConnection(url, p.getProperty("user"), p.getProperty("password"));
        }
        catch (FileNotFoundException f){
            System.out.println("Property file not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
        return conn;
    }

    public static boolean insertUser(String sql) {
        boolean f = false;
        Connection conn = JDBCTools.getConnect();
        Statement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            int n = stmt.executeUpdate(sql);
            if (n > 0)
                f = true;
            conn.close();
            stmt.close();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
        return f;
    }

    public static User getUser(String name, String password) {
        User user = null;
        Connection conn = JDBCTools.getConnect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from UserList where name=? and password=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String tpName = rs.getString(1);
                String tpPwd = rs.getString(2);
                user = new User(tpName, tpPwd);
            }
            conn.close();
            stmt.close();
            rs.close();
        }
        catch  (SQLException s) {
            s.printStackTrace();
        }
        return user;
    }

    public static User checkUser(String name) {
        User user = null;
        Connection conn = JDBCTools.getConnect();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from UserList where name=?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String tpName = rs.getString(1);
                String tpPwd = rs.getString(2);
                user = new User(tpName, tpPwd);
            }
            conn.close();
            stmt.close();
            rs.close();
        }
        catch  (SQLException s) {
            s.printStackTrace();
        }
        return user;
    }
}
