import java.util.Hashtable;
import java.util.concurrent.Semaphore;

abstract class Base {
    abstract void f();

    void g() {
    };

    private int a;

}

class A extends Base {
    void f() {
        System.out.println("A()");
    }
}

class B extends A {
    void f() {
        System.out.println("B()");
    }
}

interface C {
    int a = 1;// final
    static int b = 2;

    void h();
}

interface D extends C {
}

class E extends B implements D {

    @Override
    public void h() {

        System.out.println(a + b);

    }

}

public class test5 {

    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        a.f();
        b.f();

    }
}
