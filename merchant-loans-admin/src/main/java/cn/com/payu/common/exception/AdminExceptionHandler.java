package cn.com.payu.common.exception;

import com.glsx.plat.core.web.R;
import com.glsx.plat.exception.ExceptionLevel;
import com.glsx.plat.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author payu
 */
@Slf4j
@RestControllerAdvice
public class AdminExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(AdminException.class)
    public R handleAdminException(AdminException e) {
        return R.error(e.getMessage());
    }

    /**
     * 引入Feign服务的话
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(FeignException.class)
//    public R handleFeignException(FeignException e) {
//        return R.error(e.status(), e.getMessage());
//    }


    @ExceptionHandler(WxErrorException.class)
    public R handleWxException(WxErrorException e) {
        log.error("调用微信服务时发生错误：" + e.getMessage());
        return R.error(e.getError().getErrorCode(), "微信接口调用错误：" + e.getError().getErrorMsg());
    }

    @Override
    protected void saveException(Exception e, ExceptionLevel level) {
        super.saveException(e, level);
    }

}
