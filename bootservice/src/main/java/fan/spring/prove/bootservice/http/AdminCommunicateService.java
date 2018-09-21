package fan.spring.prove.bootservice.http;


import fan.spring.prove.bootdomain.BootResult;
import fan.spring.prove.bootdomain.MsgObject;

/**
 * Created by fanlingjie on 2018/9/6.
 * 管理中心沟通类
 */
public interface AdminCommunicateService {

    /**
     * 发送消息体
     * @return
     */
    BootResult<MsgObject> sendMsgToAdmin(MsgObject msgObject);


}
