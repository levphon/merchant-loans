package cn.com.payu.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author payu
 */
@Setter
@Getter
public class ApiException extends RuntimeException {

    protected static final int MIN_AUTO_CODE = 10000;

    protected Long errorCode;

    protected Object data;

    public ApiException(Long errorCode, String message, Object data, Throwable e) {
        super(message, e);
        this.errorCode = errorCode;
        this.data = data;
    }

    public ApiException(Long errorCode, String message, Object data) {
        this(errorCode, message, data, null);
    }

    public ApiException(Long errorCode, String message) {
        this(errorCode, message, null, null);
    }

    public ApiException(String message, Throwable e) {
        this(null, message, null, e);
    }

    public ApiException(Throwable e) {
        super(e);
    }

    public ApiException() {

    }

    public static ApiException create(String message) {
        int value = (int) (MIN_AUTO_CODE + Math.round((Integer.MAX_VALUE - MIN_AUTO_CODE) * Math.random()));
        return create(value, message);
    }

    public static ApiException create(long errorCode, String message) {
        return new ApiException(errorCode, message);
    }

}