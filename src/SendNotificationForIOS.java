import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class SendNotificationForIOS {
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Throwable {
        final AtomicInteger counter = new AtomicInteger(0);
        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    // TODO Auto-generated method stub

                    System.out.println(counter.incrementAndGet());
                    URL url = null;
                    HttpURLConnection conn = null;
                    url = new URL("http://10.123.76.169:8080/BaiYunAirport/sendNotification/sendNotificationForIOS!sendNotificationForIOS.action");
                    conn = (HttpURLConnection) url.openConnection();

                    System.out.println(conn.getResponseCode());
                    InputStream is = conn.getInputStream();

                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, 0, 10 * 60 * 1000);

    }
}
