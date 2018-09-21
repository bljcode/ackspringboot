package fan.spring.prove.bootdomain;



/**
 * Created by fanlingjie on 2018/9/6.
 */
public class MsgObject extends NetBaseObject {


    /**
     * 消息类型
     */
    Integer type;
    /**
     * 消息体
     */
    String message;


    /**
     * 获取 消息类型
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * 设置 消息类型
     */
    public void setType(Integer type) {
        this.type = type;
    }


    /**
     * 获取 消息体
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置 消息体
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
