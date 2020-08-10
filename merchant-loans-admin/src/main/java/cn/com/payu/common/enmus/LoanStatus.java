package cn.com.payu.common.enmus;

import lombok.Getter;

/**
 * @author payu
 */

@Getter
public enum LoanStatus {

    INIT(0, "新增进件"),
    //    BIZ_SERVICE_CHECK(1, "业务客服审核"),//对方已经作废的状态
    RC_FIRST_TRIAL(2, "待审核（风控初审）"),
    RC_RETRIAL(3, "待审批（风控复审）"),
    //    REJECTED(4, "已驳回"),//我方用不到
    UNPASS(5, "不通过"),
    REVOKED(6, "已撤销"),
    WAITING_SIGN(7, "待签约"),
    FINANCIAL_AUDIT(15, "财务审核"),
    WAITING_LOAN(8, "待放款"),
    ALREADY_INVALID(9, "已作废"),
    REPAYING(10, "还款中"),
    REFUSE_LOAN(11, "拒绝放款"),
    SETTLED(12, "已结清"),
    WAITING_CONFIRM(13, "待确认"),
    ALREADY_CONFIRM(14, "已确认");

    private Integer code;
    private String name;

    LoanStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (LoanStatus status : LoanStatus.values()) {
            if (status.code.equals(code)) {
                return status.name;
            }
        }
        return null;
    }

}
