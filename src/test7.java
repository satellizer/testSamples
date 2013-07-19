import java.io.File;
import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        File dir = new File("C:\\Users\\Administrator\\Desktop\\3");
        while (true) {
            String filename = s.nextLine();
            System.out.println(filename);
            String number = s.nextLine();
            System.out.println(number);
            int i = 1;
            for (File f : dir.listFiles()) {
                if (f.getName().startsWith(filename)) {
                    System.out.print(f.getName() + "==>");
                    File tmp = new File(f.getParentFile().getPath() + "/" + number + "-" + i++ + ".JPG");
                    f.renameTo(tmp);
                    System.out.println(tmp.getName());
                }
            }
        }
    }
}
