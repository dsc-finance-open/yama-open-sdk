package com.dsc.financeopen.exception;

/**
 * @author lg
 * @date 2020/6/15
 */
public class OpenException extends RuntimeException {

    /**
     * 错误码
     */
    private String errCode;

    public OpenException(String message) {
        super(message);
    }

    public OpenException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public OpenException(Throwable cause) {
        super(cause);
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
