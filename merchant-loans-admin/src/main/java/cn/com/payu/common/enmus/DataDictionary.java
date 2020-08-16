package cn.com.payu.common.enmus;

/**
 * 数据字典
 */
public interface DataDictionary {

    /**
     * 获取代码量
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取值
     *
     * @return
     */
    String getValue();

    enum PayMethod implements DataDictionary {
        method1 {
            @Override
            public Integer getCode() {
                return 1;
            }

            @Override
            public String getValue() {
                return "等额本息";
            }
        }, method2 {
            @Override
            public Integer getCode() {
                return 2;
            }

            @Override
            public String getValue() {
                return "等本等息";
            }
        }, method3 {
            @Override
            public Integer getCode() {
                return 3;
            }

            @Override
            public String getValue() {
                return "先息后本";
            }
        };

        public static String getValueByCode(Integer code) {
            for (PayMethod status : PayMethod.values()) {
                if (status.getCode().equals(code)) {
                    return status.getValue();
                }
            }
            return null;
        }
    }

    enum BindStatus implements DataDictionary {
        bound {
            @Override
            public Integer getCode() {
                return 1;
            }

            @Override
            public String getValue() {
                return "绑定";
            }
        }, unbound {
            @Override
            public Integer getCode() {
                return 2;
            }

            @Override
            public String getValue() {
                return "未绑定";
            }
        };

        public static String getValueByCode(Integer code) {
            for (BindStatus status : BindStatus.values()) {
                if (status.getCode().equals(code)) {
                    return status.getValue();
                }
            }
            return null;
        }
    }

    enum RepayStatus implements DataDictionary {
        initialize {
            @Override
            public Integer getCode() {
                return 0;
            }

            @Override
            public String getValue() {
                return "--";
            }
        },
        repayment {
            @Override
            public Integer getCode() {
                return 1;
            }

            @Override
            public String getValue() {
                return "尚未还清";
            }
        }, unrepayment {
            @Override
            public Integer getCode() {
                return 2;
            }

            @Override
            public String getValue() {
                return "已还清";
            }
        }, overdue {
            @Override
            public Integer getCode() {
                return 2;
            }

            @Override
            public String getValue() {
                return "已逾期";
            }
        };

        public static String getValueByCode(Integer code) {
            for (RepayStatus status : RepayStatus.values()) {
                if (status.getCode().equals(code)) {
                    return status.getValue();
                }
            }
            return null;
        }
    }

    enum DocumentFile implements DataDictionary {
        id_card_front {
            @Override
            public Integer getCode() {
                return 1;
            }

            @Override
            public String getValue() {
                return "身份证正面图片";
            }
        }, id_card_back {
            @Override
            public Integer getCode() {
                return 2;
            }

            @Override
            public String getValue() {
                return "身份证反面图片";
            }
        }, credit_report {
            @Override
            public Integer getCode() {
                return 3;
            }

            @Override
            public String getValue() {
                return "信用报告的文件";
            }
        }, income_proof {
            @Override
            public Integer getCode() {
                return 4;
            }

            @Override
            public String getValue() {
                return "收入证明的文件";
            }
        }, address_proof {
            @Override
            public Integer getCode() {
                return 5;
            }

            @Override
            public String getValue() {
                return "住址证明的文件";
            }
        }, assist_material {
            @Override
            public Integer getCode() {
                return 6;
            }

            @Override
            public String getValue() {
                return "其他辅助资料的文件";
            }
        }, apply_material {
            @Override
            public Integer getCode() {
                return 7;
            }

            @Override
            public String getValue() {
                return "申请资料的文件";
            }
        }, sign_video {
            @Override
            public Integer getCode() {
                return 8;
            }

            @Override
            public String getValue() {
                return "签约视频的文件";
            }
        };

        public static String getValueByCode(Integer code) {
            for (DocumentFile status : DocumentFile.values()) {
                if (status.getCode().equals(code)) {
                    return status.getValue();
                }
            }
            return null;
        }
    }
}
