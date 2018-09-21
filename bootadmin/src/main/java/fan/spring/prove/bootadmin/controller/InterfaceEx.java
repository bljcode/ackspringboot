package fan.spring.prove.bootadmin.controller;

import fan.spring.prove.bootdomain.MsgObject;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by fanlingjie on 2018/9/14.
 */
public interface InterfaceEx {

    /**
     * 下载加密的数据问题件
     * @param fileFlag 文件标识
     * @param response 输出流
     */
    void  download(String fileFlag, HttpServletResponse response);

    /**
     * msgObject:
     *  type:MsgObjectType.SYN_FILE.getValue()
     *   Map<String,String> message: key: fileFlag value:版本号
     * @return
     */
    MsgObject syncFileInfo(String appName);
}
