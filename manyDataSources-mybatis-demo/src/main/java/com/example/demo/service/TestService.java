package com.example.demo.service;

import com.example.demo.domain.Test;
import com.example.demo.mapper.secondDataSource.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GrassPrince on 2019/10/11 14:20
 */
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public Test findTestByData2(Integer data2) {
        return testMapper.findTestByData2(data2);
    };

    public Integer addTest(Test test) {
        return testMapper.addTest(test);
    }
}
