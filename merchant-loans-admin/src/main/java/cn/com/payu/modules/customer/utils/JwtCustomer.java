package cn.com.payu.modules.customer.utils;

import com.glsx.plat.jwt.base.BaseJwtUser;
import lombok.Data;

@Data
public class JwtCustomer extends BaseJwtUser {

    private String phone;
    private String wxOpenid;

    @Override
    public String getClazz() {
        return this.getClass().getCanonicalName();
    }

}
