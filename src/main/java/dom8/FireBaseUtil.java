/*
package dom8;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.protobuf.ServiceException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Component
public class FireBaseUtil {

    @Autowired
    private FirebaseConfigMapper configMapper;//查找多个应用秘钥mapp（多应用及秘钥保存于数据库）
    //保存多个初始化的FirebaseApp实例，避免多次初始化
    private Map<String, FirebaseApp> firebaseAppMap = new ConcurrentHashMap<>();

    private final Logger logger = LoggerFactory.getLogger(FireBaseUtil.class);
    */
/**
     * 获取实例
     * @param channelCode 渠道名作为应用名，获取初始化配置
     * @return
     *//*

    private FirebaseMessaging getMessageInstance(String channelCode){
        try {
            FirebaseApp firebaseApp = firebaseAppMap.get(channelCode);
            if (firebaseApp == null){
                FirebaseConfigDO firebaseConfigDO = configMapper.findByChannelCode(channelCode);
                if (firebaseConfigDO == null){
                    return null;
                }
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(new ByteArrayInputStream(firebaseConfigDO.getAccountJson().getBytes())))
                        .setDatabaseUrl(firebaseConfigDO.getDatabaseUrl())
                        .build();
                firebaseApp = FirebaseApp.initializeApp(options,channelCode);
                firebaseAppMap.put(channelCode,firebaseApp);
            }
            return FirebaseMessaging.getInstance(firebaseApp);
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }

    */
/**
     * 主题订阅
     * @param channelCode 渠道名，用作实例化的应用名
     * @param token
     * @param topic
     *//*

    @Async
    public void subTopic(String channelCode, String token, FirebaseTopicEnum topic){
        List<String> tokens = new ArrayList<>();
        tokens.add(token);
        subTopic(channelCode,tokens,topic);
    }

    public void subTopic(String channelCode, List<String> tokends, FirebaseTopicEnum topic){
        FirebaseMessaging instance = getMessageInstance(channelCode);
        if (instance == null)
            return;
        try {
            instance.subscribeToTopic(tokends, topic.getTopic());
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }


    */
/**
     * 取消订阅
     * @param channelCode 渠道名，用作实例化的应用名
     * @param token
     * @param topic
     *//*

    public void unSubTopic(String channelCode, String token, FirebaseTopicEnum topic){
        List<String> tokens = new ArrayList<>();
        tokens.add(token);
        unSubTopic(channelCode,tokens,topic);
    }
    @Async
    public void unSubTopic(String channelCode, List<String> tokends, FirebaseTopicEnum topic){
        FirebaseMessaging instance = getMessageInstance(channelCode);
        if (instance == null)
            return;
        try {
            instance.unsubscribeFromTopic(tokends,topic.getTopic());
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }


    */
/**
     * 单推
     * @param channelCode 渠道号
     * @param token 注册token
     * @param pushData 推送数据
     *//*

    public void pushSingle(String channelCode, String token, PushDataBO pushData){
        FirebaseMessaging messageInstance = getMessageInstance(channelCode);
        if (messageInstance == null)
            return;
        try {
            messageInstance.send(messageBuild(pushData, token, null));
            logger.info("设备推送成功 : "+token);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }


    */
/**
     * 主题推送
     * @param channelCode 渠道
     * @param topicEnum 主题
     * @param pushData 消息内容
     *//*

    @Async
    public void pushTopic(String channelCode, FirebaseTopicEnum topicEnum, PushDataBO pushData){
        FirebaseMessaging messageInstance = getMessageInstance(channelCode);
        if (messageInstance == null)
            return;
        try {
            messageInstance.send(messageBuild(pushData, null, topicEnum));
            logger.info("主题推送成功 ：" + topicEnum.getName());
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 创建消息
     * @param pushData 消息内容
     * @param token 单设备推送携带，否则未null
     * @param topicEnum 主题推送携带，否则未null，自定义的主题枚举
     * @return
     *//*

    private Message messageBuild(PushDataBO pushData,String token,FirebaseTopicEnum topicEnum){
        Message.Builder builder = Message.builder()
                .setNotification(new Notification(pushData.getTitle(), pushData.getBody()))
                .putData("pushType", pushData.getPushType().getType())
                .putData("openData", pushData.getOpenData()==null?"default":pushData.getOpenData());
        if (token != null){//单设备推送
            builder.setToken(token);
        }else {//订阅主题推送
            builder.setTopic(topicEnum.getTopic());
        }
        return builder.build();
    }
}*/
