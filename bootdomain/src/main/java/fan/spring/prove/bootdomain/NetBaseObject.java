package fan.spring.prove.bootdomain;

import java.io.Serializable;

/**
 * Created by fanlingjie on 2018/9/6.
 */
public class NetBaseObject implements Serializable {

    /**
     * 消息标识
     * 可用于防重等
     */
    Long uuid;


    /**
     * 消息标识
     */
    public Long getUuid() {
        return this.uuid;
    }

    /**
     * 消息标识
     */
    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }
}
