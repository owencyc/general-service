package owenc.springboot.apigate.model.bean;

import java.io.Serializable;

public class ResponseBase implements Serializable {
    private static final long serialVersionUID = -8674813636454969394L;

    public String code;
    public String exception;
    public String msg;
    public String result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
