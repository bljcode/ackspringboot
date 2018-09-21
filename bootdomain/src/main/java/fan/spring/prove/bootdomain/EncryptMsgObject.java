package fan.spring.prove.bootdomain;

/**
 * Created by fanlingjie on 2018/9/6.
 * 带加密解密的MsgObject对象
 * message加密、解密
 */
public class EncryptMsgObject {
    /**
     * 加密标识字段
     * 默认 1
     */
    int flag = 1;
    /**
     * 加密后的信息,MsgObject的json串加密后的字符串
     */
    String message;


    /**
     * 获取 加密标识字段
     */
    public int getFlag() {
        return this.flag;
    }

    /**
     * 设置 加密标识字段
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * 获取 加密信息
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 设置 加密信息
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
