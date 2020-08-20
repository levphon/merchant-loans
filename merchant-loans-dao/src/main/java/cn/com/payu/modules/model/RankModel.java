package cn.com.payu.modules.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@AllArgsConstructor
public class RankModel {

    private String salesmanName;
    private String salesmanNo;
    private BigInteger cnt;

}
