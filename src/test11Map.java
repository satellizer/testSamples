import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class test11Map {
    public static void main(String[] args) {
        class A {
            int a;
            char b;

            public A(int a, char b) {
                this.a = a;
                this.b = b;
            }
        }
        A a = new A(1, 'a');
        A b = new A(2, 'b');
        A c = new A(3, 'c');

        HashMap<Integer, A> m = new HashMap<Integer, A>();
        m.put(a.a, a);
        m.put(b.a, b);
        m.put(c.a, c);

        TreeMap<Integer, A> tm = new TreeMap<Integer, A>();
        tm.put(a.a, a);
        tm.put(b.a, b);
        tm.put(c.a, c);

        List<A> list = new LinkedList<A>();
        list.addAll(tm.values());

        for (A tmp : list) {
            System.out.print(tmp.b);
            if (tmp.a == 1)
                tm.remove(tmp.a);
        }
        for (A tt : tm.values()) {
            System.out.println(tt.b);
        }

    }
}
