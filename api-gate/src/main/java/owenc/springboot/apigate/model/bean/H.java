package owenc.springboot.apigate.model.bean;

import java.io.Serializable;
import java.util.HashMap;

public class H extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = -4474534635082387980L;

    static String CODE = "code";
    static String MESSAGE = "message";
    static String DATA = "data";

    public static int CODE_SUCCESS = 1;
    public static int CODE_ERROR = 0;

    public static String MSG_SUCCESS = "操作成功!";
    public static String MSG_ERROR = "接口异常,操作失败!";
    public static String MSG_ERROR_PARAM = "参数异常,操作失败!";

    public H() {
        put(CODE, CODE_SUCCESS);
        put(MESSAGE, MSG_SUCCESS);
    }

    public H(int code,String msg) {
        put(CODE, code);
        put(MESSAGE, msg);
    }

    public static H success() {
        return success(MSG_SUCCESS);
    }
    public static H success(String msg) {
        H h = new H(CODE_SUCCESS, msg);
        return h;
    }

    public static H error() {
        return error(MSG_ERROR);
    }
    public static H error(String msg) {
        H h = new H(CODE_ERROR, msg);
        return h;
    }

    public H addData(Object data) {
        this.put(DATA, data);
        return this;
    }

    public H getData() {
        return this.getData();
    }
}
