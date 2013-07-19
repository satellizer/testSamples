import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
  * @Function remove space in the file name
  */
public class Updatelogoname {
    public static Connection conn = null;

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        String a = "E:\\java\\testSamples\\Z";
        File folder = new File(a);

        for (File f : folder.listFiles()) {
            if (f.getName().indexOf(" ") > 0) {
                File tmp = new File(f.getParent() + "\\" + f.getName().replace(" ", ""));
                System.out.println(f.renameTo(tmp));
            }
        }

    }

}
