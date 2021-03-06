package cn.com.payu.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author payu
 */
@Setter
@Getter
public class AdminException extends RuntimeException {

    private int errorCode;

    public AdminException() {
    }

    public AdminException(String message) {
        super(message);
    }

    public AdminException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AdminException(Throwable cause) {
        super(cause);
    }

    public AdminException(String message, Throwable cause) {
        super(message, cause);
    }

}
