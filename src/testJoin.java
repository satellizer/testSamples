public class testJoin {

    public static void main(String[] args) throws Exception {

        final DataHub dataHub = new DataHub();

        Thread thread1 = new Thread() {
            public void run() {
                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("thread1 is running: " + dataHub.field1++);

            }

        };

        thread1.start();
        System.out.println(thread1.getState());
        thread1.join();

    }

}
