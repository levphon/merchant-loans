package cn.com.payu.modules.salesman.dto;

import cn.com.payu.modules.entity.Salesman;
import com.google.common.base.Converter;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

@Data
public class SalesmanDTO {

    private Long id;

    /**
     * 业务员名称
     */
    @NotBlank(message = "业务员名不能为空")
    private String name;

    /**
     * 业务员编号
     */
    @NotBlank(message = "业务员编号不能为空")
    private String sNo;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    /**
     * 省份code
     */
    @NotBlank(message = "省份不能为空")
    private String provCode;

    /**
     * 城市code
     */
    @NotBlank(message = "城市不能为空")
    private String cityCode;

    /**
     * 县区code
     */
    @NotBlank(message = "县区不能为空")
    private String areaCode;

    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空")
    private String address;

    public Salesman convertTo() {
        DTOConverter convert = new DTOConverter();
        return convert.convert(this);
    }

    public SalesmanDTO convertFor(Salesman salesman) {
        DTOConverter convert = new DTOConverter();
        return convert.reverse().convert(salesman);
    }

    private static class DTOConverter extends Converter<SalesmanDTO, Salesman> {
        @Override
        protected Salesman doForward(SalesmanDTO source) {
            Salesman target = new Salesman();
            BeanUtils.copyProperties(source, target);
            return target;
        }

        @Override
        protected SalesmanDTO doBackward(Salesman source) {
            SalesmanDTO target = new SalesmanDTO();
            BeanUtils.copyProperties(source, target);
            return target;
        }
    }

}
