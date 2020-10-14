/*
package com.xg.demo.enums;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.SendResponse;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class test {
    private static final String registrationToken =
            "APA91bFh9y5dRphP_XNBTsM1m8CtTpeeiRWvAo2HFMpTzeO5UvJCUb05lKEvkpvK6eC6HwGwec9zrnwUi9OoXvi2LeLDgf4hFdTNSn1qH7WF5W2y6Jr6yXV7Z88KaIF2xfconkgXPZtz";

    @Before
    public void before() throws Exception {
        System.out.println("========== 测试方法 before ==========");

        */
/*String path = this.getClass().getResource("/chris900403-firebase-adminsdk-ny2vm-d42251b276.json").getPath();
        System.out.println(path);*//*


        InputStream serviceAccount = new FileInputStream("E:/rediste/src/test/java/com/xg/demo/enums/bctalk-firebase-adminsdk-sihle.json");
        // InputStream serviceAccounts =
                this.getClass()
                        .getResourceAsStream("/com/xg/demo/enums/bctalk-firebase-adminsdk-sihle.json");
        // FileInputStream serviceAccount =
        //         new FileInputStream("path/to/serviceAccountKey.json");

        HttpTransport httpTransport = new NetHttpTransport.Builder()
                .setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1087)))
                .build();

        FirebaseOptions options = new FirebaseOptions.Builder()
              //  .setHttpTransport(httpTransport)
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bctalk-d6472.firebaseio.com")
                .build();
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        FirebaseApp.initializeApp(options);

    }

    */
/**
     * 向特定设备发送消息
     *//*

    @Test
    public void test() throws FirebaseMessagingException {
        System.out.println("========== 测试方法 test ==========");
        // This registration token comes from the client FCM SDKs.
        // String registrationToken = "YOUR_REGISTRATION_TOKEN";

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = FirebaseMessaging.getInstance().send(message);
        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
    }

    */
/**
     * 向多台设备发送消息
     *//*

    @Test
    public void testMultiDev() throws FirebaseMessagingException {
        System.out.println("========== 测试方法 testMultiDev ==========");
        // Create a list containing up to 100 registration tokens.
        // These registration tokens come from the client FCM SDKs.
        List<String> registrationTokens = Arrays.asList(
                // "YOUR_REGISTRATION_TOKEN_1",
                // ...
                registrationToken
        );

        MulticastMessage message = MulticastMessage.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .addAllTokens(registrationTokens)
                .build();
        BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
        // See the BatchResponse reference documentation
        // for the contents of response.
        System.out.println(response.getSuccessCount() + " messages were sent successfully");
        if (response.getFailureCount() > 0) {
            List<SendResponse> responses = response.getResponses();
            List<String> failedTokens = new ArrayList<>();
            for (int i = 0; i < responses.size(); i++) {
                if (!responses.get(i).isSuccessful()) {
                    // The order of responses corresponds to the order of the registration tokens.
                    failedTokens.add(registrationTokens.get(i));
                }
            }

            System.out.println("List of tokens that caused failures: " + failedTokens);
        }
    }

    */
/**
     * 向主题发送消息
     *//*

    @Test
    public void testSendToTopic() throws FirebaseMessagingException {
        System.out.println("========== 测试方法 testSendToTopic ==========");
        // The topic name can be optionally prefixed with "/topics/".
        String topic = "highScores";

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setTopic(topic)
                .build();

        // Send a message to the devices subscribed to the provided topic.
        String response = FirebaseMessaging.getInstance().send(message);
        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
    }

    */
/**
     * 向条件发送消息
     *//*

    @Test
    public void testSendByCondition() throws FirebaseMessagingException {
        System.out.println("========== 测试方法 testSendByCondition ==========");
        // Define a condition which will send to devices which are subscribed
        // to either the Google stock or the tech industry topics.
        String condition = "'stock-GOOG' in topics || 'industry-tech' in topics";

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .setNotification(new Notification(
                        "$GOOG up 1.43% on the day",
                        "$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day."))
                .setCondition(condition)
                .build();

        // Send a message to devices subscribed to the combination of topics
        // specified by the provided condition.
        String response = FirebaseMessaging.getInstance().send(message);
        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
    }

    @Test
    public void testSendByBatch() throws FirebaseMessagingException {
        System.out.println("========== 测试方法 testSendByBatch ==========");
        // Create a list containing up to 100 messages.
        List<Message> messages = Arrays.asList(
                Message.builder()
                        .setNotification(new Notification("Price drop", "5% off all electronics"))
                        .setToken(registrationToken)
                        .build(),
                // ...
                Message.builder()
                        .setNotification(new Notification("Price drop", "2% off all books"))
                        .setTopic("readers-club")
                        .build()
        );

        BatchResponse response = FirebaseMessaging.getInstance().sendAll(messages);
        // See the BatchResponse reference documentation
        // for the contents of response.
        System.out.println(response.getSuccessCount() + " messages were sent successfully");
    }

    @Test
    public void testSendMultiPlatform() {
        System.out.println("========== 测试方法 testSendMultiPlatform ==========");
        Message message = Message.builder()
                .setNotification(new Notification(
                        "$GOOG up 1.43% on the day",
                        "$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day."))
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000)
                        .setNotification(AndroidNotification.builder()
                                .setIcon("stock_ticker_update")
                                .setColor("#f45342")
                                .build())
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setBadge(42)
                                .build())
                        .build())
                .setTopic("industry-tech")
                .build();
    }

}


*/
