import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class NullImageShop {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String a = "E:/Files/CellPhone/image/正佳final_320X240/7";
        File folder = new File(a);

        Set<String> shopids = new HashSet<String>();
        for (File f : folder.listFiles()) {
            shopids.add(f.getName().substring(0, f.getName().indexOf("-")));
        }
        String txt = "E:/Files/CellPhone/image/正佳final/7/207.txt";
        File txtfile = new File(txt);
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream(txtfile);
        byte[] buff = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (fis.read(buff) != -1) {
            baos.write(buff);
        }
        Reader reader = new StringReader(new String(baos.toByteArray(), "utf-8"));
        p.load(reader);

        List<String> nullimage = new ArrayList<String>();
        for (Object s : p.keySet()) {
            if (!shopids.contains(s)) {
                if (!((String) s).endsWith("#")) {
                    // System.out.println(s + "=" + p.getProperty((String) s));
                    nullimage.add((String) s);
                }
            }
        }
        Collections.sort(nullimage);
        for (String s : nullimage) {
            System.out.println(s + "=" + p.getProperty((String) s));
        }
    }
}
