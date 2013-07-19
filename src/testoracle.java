import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;

public class testoracle {
    public static Connection conn = null;

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        getConn();

        Statement st = conn.createStatement();
        ResultSet rs = st
                .executeQuery("select t.*, t.rowid  from m_subscribenotification t where pushtoken =       '21f33b460682f715e5496f995a2b85d0a806641e24353fe8b870abd7a81fcd40'       and t.createdate>to_date('2013-05-07 19:30:00','yyyy-mm-dd hh24:mi:ss')  order by t.createdate desc");
        while (rs.next()) {
            System.out.println(rs.getString("content"));
        }

    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        if (null != conn)
            return conn;

        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:gbiaps/gbiaps@10.123.82.227:1521:test11g", "gbiaps", "gbiaps");
        return conn;
    }
}
