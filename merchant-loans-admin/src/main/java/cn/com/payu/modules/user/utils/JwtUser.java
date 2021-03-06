package cn.com.payu.modules.user.utils;

import com.glsx.plat.jwt.base.BaseJwtUser;
import lombok.Data;

@Data
public class JwtUser extends BaseJwtUser {

    private String phone;

    @Override
    public String getClazz() {
        return this.getClass().getCanonicalName();
    }

}
