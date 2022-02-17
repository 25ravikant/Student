package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    Connection conn = null;
    public static Connection sqlConnect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo?useSSL=true","root","root");
            return conn;
        } catch ( Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
