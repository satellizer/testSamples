import java.io.File;

public class test3 {
    public static void main(String[] args) {

        // int a = Integer.MAX_VALUE - 100;
        // long b = Long.MAX_VALUE;
        // for (; a < b; a++)
        // System.out.println("!");
        File f = new File("d:/a.txt");
        while (true) {
            System.out.println(f.lastModified());
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
