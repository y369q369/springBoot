package com.example.demo.domain;

import lombok.Data;

/**
 * Created by GrassPrince on 2019/10/11 9:45
 * 账户信息 : acct_info
 */
@Data
public class AcctInfo {
    /**
     * 名称
     */
    private String acctName;

    /**
     * 账号
     */
    private Integer acctNo;

    /**
     * 金额
     */
    private Double acctMoney;

    public AcctInfo(String acctName, Integer acctNo, Double acctMoney) {
        this.acctName = acctName;
        this.acctNo = acctNo;
        this.acctMoney = acctMoney;
    }

    public AcctInfo() {
    }
}
