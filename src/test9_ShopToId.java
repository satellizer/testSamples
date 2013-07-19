import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


/**
  * @author windheaven(mail) 2013-5-20
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function convert the letter to number from the file name and make a sequence for them
  */
public class test9_ShopToId {

    public static void main(String[] args) throws Exception {
        String fileFolder = "ALL-2013-5-20";
        File dir = new File(fileFolder + "");
        File optdir = new File("opt/" + fileFolder);
        if (!optdir.exists()) {
            optdir.mkdirs();
        }

        Map<String, Long> record = new TreeMap<String, Long>();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        for (File tmp : dir.listFiles()) {
            int left = tmp.getName().indexOf("(");
            int dot = tmp.getName().indexOf(".");
            String newName = convert(tmp.getName().substring(0, left > -1 ? left : dot).trim());
            if (null == record.get(newName)) {
                record.put(newName, new Long(1));
            }
            Long l = record.get(newName);
            File newFile = new File(optdir.getPath() + File.separator + newName + "(" + l + ")" + ".jpg");
            if (newFile.exists()) {
                continue;
            }
            record.put(newName, record.get(newName) + 1);
            System.out.printf("%15s => %15s\n", tmp.getName(), newFile.getName());
            fis = new FileInputStream(tmp);
            fos = new FileOutputStream(newFile);

            byte[] buffer = new byte[4096];
            while (-1 != fis.read(buffer)) {
                fos.write(buffer);
            }
            fis.close();
            fos.close();
        }

        // File dir = new File("a");
        //
        // Set<String> record = new HashSet<String>();
        // for (File tmp : dir.listFiles()) {
        // int index = tmp.getName().indexOf("(");
        // record.add(tmp.getName().substring(0, index>-1?index:tmp.getName().indexOf('.')).trim());
        // }
        // List<String> r = new ArrayList<String>();
        //
        // for (String s : record) {
        // r.add(s);
        // }
        // Collections.sort(r);
        // for (String s : r) {
        // System.out.println(s);
        // }

    }

    // C9118->129118
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
        return sb.toString().trim();
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

}
