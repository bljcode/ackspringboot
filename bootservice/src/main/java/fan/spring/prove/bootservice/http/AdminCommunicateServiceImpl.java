package fan.spring.prove.bootservice.http;


import com.alibaba.fastjson.JSONObject;
import fan.spring.prove.bootdomain.BootResult;
import fan.spring.prove.bootdomain.MsgObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fanlingjie on 2018/9/6.
 */
@Service("AdminCommunicateService")
public class AdminCommunicateServiceImpl implements AdminCommunicateService {

    private static final Logger logger = LoggerFactory.getLogger(AdminCommunicateServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    private static final String url ="http://localhost/object";

    @Override
    public BootResult<MsgObject> sendMsgToAdmin(MsgObject msgObject) {
        try{
            logger.info("发送消息：" + JSONObject.toJSONString(msgObject));
            MsgObject re = restTemplate.postForObject(url,msgObject,MsgObject.class);
            return BootResult.getSuccessResult(re);
        }catch (RestClientException exception){
            logger.error("发送消息异常",exception);
            return BootResult.getFailResult("发送消息异常");
        }
    }


    public BootResult<MsgObject> getMsgFromAdmin(MsgObject msgObject) {
        try {
            logger.info("获取消息，请求信息：" + JSONObject.toJSONString(msgObject));
            MsgObject re = restTemplate.getForObject(url,MsgObject.class,msgObject);
            return BootResult.getSuccessResult(re);
        }catch (RestClientException exception){
            logger.error("获取消息异常",exception);
            return BootResult.getFailResult("获取消息异常");
        }
    }
}
