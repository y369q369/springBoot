package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by GrassPrince on 2019/10/11 14:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestServiceTest {

    @Autowired
    private TestService service;

    @Test
    public void findTestByData2() {
        Integer data2 = 123;
        com.example.demo.domain.Test test = service.findTestByData2(data2);
        log.info("test : {}", test.toString());
        Assert.assertNotNull(test);
    }

    @Test
    public void addTest() {
        com.example.demo.domain.Test test = new com.example.demo.domain.Test("asdsew", new Random().nextInt(10000));
        Integer flag = service.addTest(test);
        log.info("插入数量 : {}", flag);
        Assert.assertTrue(flag > 0);
    }
}