import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class test6 {

    public static void main(String args[]) throws MalformedURLException, IOException {

        // String a = "abAB0123";
        // System.out.println(a.charAt(0));
        // System.out.println('a' & 0xffff);
        // System.out.println('z' & 0xffff);
        // System.out.println('A' & 0xffff);
        // System.out.println('Z' & 0xffff);
        System.out.println(String.format("%02X:%02X", 16, 10));
        List<Integer> list = new ArrayList<Integer>(10);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(10));
            if (i == 5) {
                list.add(5, null);
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print(" \n");
        list.subList(0, 1);
        list.subList(0, list.size());

        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print(" \n");
        System.out.print(Math.ceil(1.0));

    }
}
