package com.example.demo.mapper.primaryDataSource;

import com.example.demo.domain.AcctInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GrassPrince on 2019/10/11 9:51
 */
public interface AcctInfoMapper {

    /** 根据账号获取账户信息 */
    AcctInfo findByAcctNo (@Param("acctNo") Integer acctNo);

    /** 获取金额大于某值的所有账户信息 8 */
     List<AcctInfo> findAcctInfoListByMoney (@Param("acctMoney") Double acctMondy);

     /** 创建单个账户信息 */
     Integer addAcctInfo (AcctInfo acctInfo);

    /** 根据账号删除账户信息 */
    Integer deleteAcctInfoByAcctNo (@Param("acctNo") Integer acctNo);

    /** 根据账号修改账户金额 */
    Integer updateAcctInfoByAcctNo (AcctInfo acctInfo);
}
