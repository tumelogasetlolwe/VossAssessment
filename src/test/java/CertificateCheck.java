import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HttpsURLConnection;

public class CertificateCheck {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int delay = 0; // Delay before the first run
        int period = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

        timer.scheduleAtFixedRate(new SSLCheckTask(), delay, period);
    }

    static class SSLCheckTask extends TimerTask {
        @Override
        public void run() {
            String url = "https://www.ultimateqa.com";
            try {
                URL serverURL = new URL(url);
                HttpsURLConnection connection = (HttpsURLConnection) serverURL.openConnection();
                connection.connect();
                Certificate[] certificates = connection.getServerCertificates();
                X509Certificate cert = (X509Certificate) certificates[0];
                Date expirationDate = cert.getNotAfter();
                System.out.println("SSL certificate for " + url + " expires on " + expirationDate);
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}