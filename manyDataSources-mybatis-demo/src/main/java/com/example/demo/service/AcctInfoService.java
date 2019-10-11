package com.example.demo.service;

import com.example.demo.domain.AcctInfo;
import com.example.demo.mapper.primaryDataSource.AcctInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GrassPrince on 2019/10/11 10:01
 */
@Service
public class AcctInfoService {

    @Autowired
    private AcctInfoMapper acctInfoMapper;

    /** 根据账号获取账户信息 */
    public AcctInfo findByAcctNo (Integer acctNo) {
        return acctInfoMapper.findByAcctNo(acctNo);
    };

    /** 获取金额大于某值的所有账户信息 8 */
    public List<AcctInfo> findAcctInfoListByMoney (Double acctMondy) {
        return acctInfoMapper.findAcctInfoListByMoney(acctMondy);
    };

    /** 创建单个账户信息 */
    public Integer addAcctInfo (AcctInfo acctInfo) {
        return acctInfoMapper.addAcctInfo(acctInfo);
    };

    /** 根据账号删除账户信息 */
    public Integer deleteAcctInfoByAcctNo (Integer acctNo) {
        return acctInfoMapper.deleteAcctInfoByAcctNo(acctNo);
    };

    /** 根据账号修改账户金额 */
    public Integer updateAcctInfoByAcctNo (AcctInfo acctInfo) {
        return acctInfoMapper.updateAcctInfoByAcctNo(acctInfo);
    };
}
