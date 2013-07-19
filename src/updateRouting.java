import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @(#) updateRouting.java
 * @Author:windheaven(mail) 2013-5-6
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-5-6
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function useless
  */
public class updateRouting {
    public static Connection conn = null;

    public static final String SQL = "update routing set route=? where sid=? and eid=?;";

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        getConn();
        PreparedStatement st = conn.prepareStatement("select sid,eid,route from routing ");
        ResultSet rs = st.executeQuery();
        while (rs.next() != false) {
            long sid = rs.getLong("sid");
            long eid = rs.getLong("eid");
            String route = rs.getString("route");
            String tmp = process(route, 820, 789, 430);
            tmp = process(tmp, 823, 237, 205);
            tmp = process(tmp, 824, 243, 249);
            tmp = process(tmp, 827, 304, 290);
            tmp = process(tmp, 828, 306, 289);
            tmp = process(tmp, 829, 289, 306);
            tmp = process(tmp, 830, 290, 304);
            tmp = process(tmp, 826, 249, 243);
            tmp = process(tmp, 819, 205, 237);
            tmp = process(tmp, 815, 430, 789);
            if (!(tmp.equals(route))) {
                System.out.println(tmp);
                PreparedStatement s = conn.prepareStatement(SQL);
                s.setString(1, tmp);
                s.setLong(2, sid);
                s.setLong(3, eid);
                int code = s.executeUpdate();
                System.out.println(code);
            }
        }
        // String route = "1;2;3;789;820;123;815;430";
        // System.out.println(route = process(route, 820, 789, 430));
        // System.out.println(route = process(route, 823, 237, 205));
        // System.out.println(route = process(route, 824, 243, 249));
        // System.out.println(route = process(route, 827, 304, 290));
        // System.out.println(route = process(route, 828, 306, 289));
        // System.out.println(route = process(route, 829, 289, 306));
        // System.out.println(route = process(route, 830, 290, 304));
        // System.out.println(route = process(route, 826, 249, 243));
        // System.out.println(route = process(route, 819, 205, 237));
        // System.out.println(route = process(route, 815, 430, 789));

    }

    public static String process(String route, long id, long preid, long replaceid) {
        int index_preid_id = route.indexOf(preid + ";" + id);
        int index_id_preid = route.indexOf(id + ";" + preid);

        if (index_preid_id > -1) {
            return route.replace(preid + ";" + id, replaceid + ";" + id);
        }
        if (index_id_preid > -1) {
            return route.replace(id + ";" + preid, id + ";" + replaceid);
        }
        return route;
    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        if (null != conn)
            return conn;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baiyun?user=root&password=654321", "root", "654321");
        return conn;
    }
}
