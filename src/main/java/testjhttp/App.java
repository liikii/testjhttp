package testjhttp;


import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {
//        System.setProperty("jsse.enableSNIExtension", "true");
        String url = "https://www.baidu.com";
//        HttpClient httpClient = new DefaultHttpClient();

        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpReq = new HttpGet(url);
        HttpPost httpReq = new HttpPost(url);
        try {
            HttpResponse response = httpClient.execute(httpReq);
            String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

            //System.out.println(response.getAllHeaders());
            System.out.println("\n=====================================");
            for (Header header : httpReq.getAllHeaders()) {
                System.out.println(header);
            }
            System.out.println("\n\n=====================================");
            System.out.println(response.getStatusLine());
            for (Header header : response.getAllHeaders()) {
                System.out.println(header);
            }
            System.out.println(result);
            System.out.println("send ok!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch http error");
        }
    }
}
