package com.example.demo.service;

import com.example.demo.domain.AcctInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * Created by GrassPrince on 2019/10/11 10:28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AcctInfoServiceTest {

    @Autowired
    private AcctInfoService service;

    private Integer acctNo = 12342;


    @Test
    public void findByAcctNo() {
        AcctInfo acctInfo = service.findByAcctNo(acctNo);
        log.info("acctIno : {}", acctInfo.toString());
        Assert.assertNotEquals(null, acctInfo);
    }

    @Test
    public void findAcctInfoListByMoney() {
        Double money = 30.0;
        List<AcctInfo> acctInfoList = service.findAcctInfoListByMoney(money);
        log.info("acctInfoList : {}", acctInfoList.toString());
        Assert.assertNotEquals(null, acctInfoList);
    }

    @Test
    public void addAcctInfo() {
        //AcctInfo acctInfo = new AcctInfo("god", new Random().nextInt(10000000), new Random().nextDouble());
        AcctInfo acctInfo = new AcctInfo("测试", 123456, new Random().nextDouble());
        Integer flag = service.addAcctInfo(acctInfo);
        log.info("插入数量 : {}", 0);
        Assert.assertTrue(flag > 0);
    }

    @Test
    public void deleteAcctInfoByAcctNo() {
        Integer flag = service.deleteAcctInfoByAcctNo(123456);
        log.info("删除数量 : {}", 0);
        Assert.assertTrue(flag > 0);
    }

    @Test
    public void updateAcctInfoByAcctNo() {
        AcctInfo acctInfo = new AcctInfo("测试", 12342, (double) new Random().nextInt(20));
        Integer flag = service.updateAcctInfoByAcctNo(acctInfo);
        log.info("修改数量 : {}", 0);
        Assert.assertTrue(flag > 0);
    }
}