
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;

import org.apache.commons.io.IOUtils;


/**
  * @author windheaven(mail) 2013-5-20
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function create shop logo file and update database records
  */
public class CreateShoplogo_UpdateLogoSQL {
    public static Connection conn = null;

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // getConn();

        String folderName = "ALL-2013-5-20";
        String a = new String("E:\\java\\testSamples\\opt\\" + folderName);
        String dst = new String("D:/tmp/" + folderName);
        String sqlFilePath = new String("D:/tmp/" + folderName + ".sql");
        File sampleFolder = new File(a);
        File dstFolder = new File(dst);
        File sqlFile = new File(sqlFilePath);
        if (!dstFolder.exists()) {
            dstFolder.mkdirs();
        }

        TreeMap<String, ArrayList> images = new TreeMap<String, ArrayList>();

        for (File f : sampleFolder.listFiles()) {
            int index = f.getName().indexOf("(") == -1 ? f.getName().indexOf(".") : f.getName().indexOf("(");
            String shopid = (String) f.getName().subSequence(0, index);
            ArrayList<File> files = images.get(shopid);
            if (null == files) {
                images.put(shopid, new ArrayList<File>());
                files = images.get(shopid);
            }
            files.add(f);
        }
        System.out.println(images.keySet().size());
        BufferedWriter bw = new BufferedWriter(new FileWriter(sqlFile, true));
        // FileOutputStream bw = new FileOutputStream(sqlFile);

        for (String shopid : images.keySet()) {
            ArrayList<File> files = images.get(shopid);
            if (files.size() < 1) {
                System.err.printf("%d has no picture", shopid);
            }
            File f = files.get(0);
            File d = new File(dstFolder.getPath() + File.separator + f.getName().toLowerCase());

            if (!d.exists()) {
                System.out.printf("copying file from %15s to %15s    :    ", f.getName(), d.getName());
                byte[] buff = new byte[10240];
                FileInputStream fis = new FileInputStream(f);
                FileOutputStream fos = new FileOutputStream(d);

                while (fis.read(buff) != -1) {
                    fos.write(buff);
                }
                IOUtils.closeQuietly(fis);
                IOUtils.closeQuietly(fos);
            }
            // Statement st = conn.createStatement();
            String sql = "update  shopmember set shoplogo=" + "'/baiyun/logo/" + d.getName() + "' where id=" + shopid + ";";
            // st.executeUpdate(sql);
            // st.close();

            bw.write(sql);
            bw.newLine();
            System.out.printf("%s\n", sql);
        }
        bw.write("commit;");
        bw.flush();
        bw.close();

    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        if (null != conn)
            return conn;

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baiyun?user=root&password=654321", "root", "654321");
        return conn;
    }
}
