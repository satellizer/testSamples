import java.util.Scanner;

class DataHub {
    int field1 = 0;
    int field2 = 1;
    int field3 = 2;

    public void increment() {
        field1++;
    }
}

public class test1_thread {

    public static void main(String[] args) throws Exception {

        final DataHub dataHub = new DataHub();

        Thread thread1 = new Thread() {
            public void run() {
                while (true) {
                    dataHub.increment();
                    System.out.println("thread1 is running: " + dataHub.field1);
                    // try {
                    // this.sleep(500);
                    if (dataHub.field1 > 20)
                        return;
                    // } catch (InterruptedException e) {
                    // // TODO Auto-generated catch block
                    // e.printStackTrace();
                    // }
                }

            }

        };
        Thread thread2 = new Thread() {
            public void run() {
                while (true) {
                    dataHub.increment();
                    System.out.println("thread2 is running: " + dataHub.field1);
                    // try {
                    // this.sleep(500);
                    if (dataHub.field1 > 20)
                        return;
                    // } catch (InterruptedException e) {
                    // // TODO Auto-generated catch block
                    // e.printStackTrace();
                    // }
                }
            }

        };
        Thread thread3 = new Thread() {
            public void run() {
                // while (true) {
                dataHub.increment();
                System.out.println("thread3 is running: " + dataHub.field1);
                // try {
                // this.sleep(500);
                if (dataHub.field1 > 20)
                    return;

                Scanner scanner = new Scanner(System.in);
                scanner.nextInt();
                // } catch (InterruptedException e) {
                // // TODO Auto-generated catch block
                // e.printStackTrace();
                // }
                // }
            }

        };
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println(thread1.isAlive());
        System.out.println(thread2.isAlive());
        System.out.println(thread3.isAlive());
        // while (true) {
        // System.out.println(thread1.getState());
        // System.out.println(thread2.getState());
        // System.out.println(thread3.getState());
        // System.out.println("monitor: " + dataHub.field1);
        // Thread.sleep(1000);
        // }
        Thread.sleep(1000);

        System.out.println("main thread stop!");
        System.out.println(thread1.isAlive());
        System.out.println(thread2.isAlive());
        System.out.println(thread3.isAlive());
    }

}
