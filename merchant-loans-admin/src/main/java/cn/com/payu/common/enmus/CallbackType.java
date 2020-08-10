package cn.com.payu.common.enmus;

import lombok.Getter;

/**
 * @author payu
 */
@Getter
public enum CallbackType {

    APPLY_SUCCESS(1, "进件成功"),
    RC_PASS(2, "风控审核通过"),
    RC_UNPASS(3, "风控审核不通过"),
    RC_REFUSE(4, "风控拒绝进件"),
    SIGNED(5, "进件已签约"),
    LOANED(6, "进件已放款"),
    SETTLED(7, "进件已结清贷款"),
    REFUSE_LOAN(8, "拒绝放款"),
    VOLUNTARY_REPAYMENT(9, "主动还款回调"),
    APPLY_DATA_CHECK(100, "进件数据校验回调");

    private Integer code;
    private String name;

    CallbackType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (CallbackType status : CallbackType.values()) {
            if (status.code.equals(code)) {
                return status.name;
            }
        }
        return null;
    }
}
