package fan.spring.prove.bootdomain;

/**
 * Created by fanlingjie on 2018/9/6.
 */
@SuppressWarnings("unchecked")
public class BootResult<T> {

    private final static boolean SUCCESS = true;
    private final static boolean FAIL = false;

    /**
     * 是否成功
     */
    private Boolean isSuccess;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据对象
     */
    private T data;


    public static BootResult getSuccessResult() {
        return getResult(SUCCESS,"success",null);
    }
    public static <T> BootResult getSuccessResult(T data){
        return getResult(SUCCESS,"success",data);
    }
    public static <T> BootResult getSuccessResult(String msg, T data){
        return getResult(SUCCESS,msg,data);
    }
    public static BootResult getFailResult(String msg) {
        return getResult(FAIL,msg,null);
    }

    private static <T> BootResult getResult(boolean isSuccess, String msg, T data){
        BootResult result = new BootResult();
        result.setIsSuccess(isSuccess);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    /**
     * 获取 是否成功
     */
    public Boolean getIsSuccess() {
        return this.isSuccess;
    }

    /**
     * 设置 是否成功
     */
    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * 获取 返回信息
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * 设置 返回信息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取 数据对象
     */
    public T getData() {
        return this.data;
    }

    /**
     * 设置 数据对象
     */
    public void setData(T data) {
        this.data = data;
    }
}
