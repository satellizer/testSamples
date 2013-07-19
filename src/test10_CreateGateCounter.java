import java.nio.CharBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test10_CreateGateCounter {
    public static Connection conn = null;

    public static void main(String[] args) throws Exception {

        getConn();
        Statement stat = conn.createStatement();

        CharBuffer cb = CharBuffer.allocate(1000);

        /*
         * { // B区登机口 B01-B18 for (int i = 1; i <= 18; i++) { cb.clear(); cb.append("insert into shopmember(id,shoptype,shopname) values ("); cb.append(11000 + i + ",1022,'"); cb.append("B区登机口-B"); if (i < 10) cb.append("0" + i); else cb.append(i + ""); cb.append("');"); System.out.println(new
         * String(cb.array(), 0, cb.position())); stat.execute(new String(cb.array(), 0, cb.position())); } // B到登机 B201-B235 for (int i = 201; i <= 235; i++) { cb.clear(); cb.append("insert into shopmember(id,shoptype,shopname) values ( "); cb.append(11000 + i + ",1022,'"); cb.append("B区登机口-B"); if
         * (i < 10) cb.append("0" + i); else cb.append(i + ""); cb.append("');"); System.out.println(new String(cb.array(), 0, cb.position())); stat.execute(new String(cb.array(), 0, cb.position())); }
         * 
         * // A区国际登机口 A01-A04 for (int i = 1; i <= 4; i++) { cb.clear(); cb.append("insert into shopmember(id,shoptype,shopname) values ( "); cb.append(10000 + i + ",1023,'"); cb.append("A区国际登机口-A"); if (i < 10) cb.append("0" + i); else cb.append(i + ""); cb.append("');"); System.out.println(new
         * String(cb.array(), 0, cb.position())); stat.execute(new String(cb.array(), 0, cb.position())); } // A区国际登机 A101-A112 for (int i = 101; i <= 112; i++) { cb.clear(); cb.append("insert into shopmember(id,shoptype,shopname) values ( "); cb.append(10000 + i + ",1023,'");
         * cb.append("A区国际登机口-A"); if (i < 10) cb.append("0" + i); else cb.append(i + ""); cb.append("');"); System.out.println(new String(cb.array(), 0, cb.position())); stat.execute(new String(cb.array(), 0, cb.position())); }
         * 
         * // A区国内登机 A07-A13 for (int i = 7; i <= 18; i++) { cb.clear(); cb.append("insert into shopmember(id,shoptype,shopname) values ( "); cb.append(10000 + i + ",1024,'"); cb.append("A区国内登机口-A"); if (i < 10) cb.append("0" + i); else cb.append(i + ""); cb.append("');"); System.out.println(new
         * String(cb.array(), 0, cb.position())); stat.execute(new String(cb.array(), 0, cb.position())); } // A区国内登机 A113-A133 for (int i = 113; i <= 133; i++) { cb.clear(); cb.append("insert into shopmember(id,shoptype,shopname) values ( "); cb.append(10000 + i + ",1024,'");
         * cb.append("A区国内登机口-A"); if (i < 10) cb.append("0" + i); else cb.append(i + ""); cb.append("');"); System.out.println(new String(cb.array(), 0, cb.position())); stat.execute(new String(cb.array(), 0, cb.position())); } // A区到达口 E1-E3 for (int i = 1; i <= 3; i++) { cb.clear();
         * cb.append("insert into shopmember(id,shoptype,shopname) values ( "); cb.append(14000 + i + ",1021,'"); cb.append("A区到达口-E"); cb.append(i + ""); cb.append("');"); System.out.println(new String(cb.array(), 0, cb.position())); stat.execute(new String(cb.array(), 0, cb.position())); } //
         * B区到达口 W1-W3 for (int i = 1; i <= 3; i++) { cb.clear(); cb.append("insert into shopmember(id,shoptype,shopname) values ( "); cb.append(22000 + i + ",1020,'"); cb.append("B区到达口-W"); cb.append(i + ""); cb.append("');"); System.out.println(new String(cb.array(), 0, cb.position()));
         * stat.execute(new String(cb.array(), 0, cb.position())); } }
         */
        // //洗手间
        // for (int i = 1; i <= 50; i++) {
        // cb.clear();
        // cb.append("insert into shopmember(id,shoptype,shopname) values ( ");
        // cb.append(300000 + i + ",1019,'");
        // cb.append("洗手间");
        // cb.append("');");
        // System.out.println(new String(cb.array(), 0, cb.position()));
        // stat.execute(new String(cb.array(), 0, cb.position()));
        // }
        // }

        // //地铁
        // for (int i = 1; i <= 2; i++) {
        // cb.clear();
        // cb.append("insert into shopmember(id,shoptype,shopname) values ( ");
        // cb.append(400000 + i + ",1018,'");
        // cb.append("地铁");
        // cb.append("');");
        // System.out.println(new String(cb.array(), 0, cb.position()));
        // stat.execute(new String(cb.array(), 0, cb.position()));
        // }
        // 值机柜台
        for (int i = 1; i <= 26; i++) {
            cb.clear();
            cb.append("insert into shopmember(id,shoptype,shopname) values ( ");
            cb.append(500000 + i + ",1017,'");
            cb.append("值机柜台-" + (char) ('A' - 1 + i));
            cb.append("');");
            System.out.println(new String(cb.array(), 0, cb.position()));
            stat.execute(new String(cb.array(), 0, cb.position()));
        }
    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        if (null != conn)
            return conn;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baiyun?user=root&password=654321", "root", "654321");
        return conn;
    }
}
