package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class BasicsGetIndustryTypeListReq extends AbstractApiReq {

    private Integer pid;//	否	int	10	一级行列类别ID(父类别)，默认为0：获取一级行列类别，若传递该字段则获取二级行列类别

}
