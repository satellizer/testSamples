import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.CharBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;


/**
  * @author windheaven(mail) 2013-5-20
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function create shopmember record from the key value file
  */
public class test8_CreateShopmember {
    public static Connection conn = null;

    
    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      * @throws Exception
      */
    public static void main(String[] args) throws Exception {

        // getConn();
        // Statement stat = conn.createStatement();
        File file = new File("shopmember.txt");
        File opt = new File("shopmember.sql");
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(opt);
        BufferedReader bis = new BufferedReader(fr);

        String line = bis.readLine();
        String floor;
        CharBuffer cb = CharBuffer.allocate(4 * 4 * 4 * 4);
        HashSet<String> shopids = new HashSet<String>();
        while (null != line) {
            String[] arr = line.split(",");
            blank: if (line.startsWith(",") || line.indexOf("商铺") > 0) {
                line = bis.readLine();
                continue;
            } else

            if (line.endsWith(",")) {
                floor = arr[0];
                line = bis.readLine();
                continue;
            }
            if (arr.length != 2)
                continue;
            String noS[] = arr[0].split("/");
            for (int i = 0; i < noS.length; i++) {
                cb.clear();
                cb.append("insert into shopmember(id,shopname) values ( ");
                String t = convert(noS[i]);
                if (t.equals(""))
                    continue;
                cb.append(t);
                if (shopids.contains(t)) {
                    System.err.println("dulplicated id!" + t);
                    continue;
                }
                shopids.add(t);
                // System.out.println(revert(t));
                cb.append(",'");
                cb.append(arr[1]);
                cb.append("');");
                // System.out.println(new String(cb.array(), 0, cb.position()));
                fw.write(cb.array(), 0, cb.position());
                fw.write("\n");
            }
            line = bis.readLine();
        }
        bis.close();
        fr.close();
        fw.close();

    }

    public static String convert(String src) {
        LinkedList<Character> l = new LinkedList<Character>();
        for (char c : src.toCharArray())
            if (c > 0x00 && c < 0xff) {
                int l1 = c & 0xDF;
                if ((0x41 <= l1 && l1 <= 0x5A)) {
                    for (char cc : Integer.toString(l1 - 'A' + 10).toCharArray())
                        l.push(cc);
                } else {
                    l.push(c);
                }
            }
        StringBuffer sb = new StringBuffer();
        // for (Iterator i = l.iterator(); i.hasNext();)
        // sb.append(i.next());
        while (0 < l.size()) {
            sb.append(l.pollLast());
        }
        return sb.toString();
    }

    // C9118/C9110,盛天下茶庄
    public static String revert(String dst) {

        if (null == dst || dst.trim().equals(""))
            return null;
        char[] arr = dst.toCharArray();
        if (2 > arr.length)
            return null;
        for (char c : arr) {
            if (c < '0' || c > '9')
                return null;
        }
        char f = '0';
        f = (char) ((arr[0] - f - 1) * 10 + (arr[1] - f) + 'A');
        for (int i = 0; i < arr.length; i++) {
            if (i > 1) {
                arr[i - 1] = arr[i];
            } else if (i == 0) {
                arr[0] = f;
            }
        }
        return new String(arr, 0, arr.length - 1);
    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        if (null != conn)
            return conn;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baiyun?user=root&password=654321", "root", "654321");
        return conn;
    }
}
