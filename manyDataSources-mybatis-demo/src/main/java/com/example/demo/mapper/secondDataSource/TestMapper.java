package com.example.demo.mapper.secondDataSource;

import com.example.demo.domain.Test;
import org.apache.ibatis.annotations.Param;

/**
 * Created by GrassPrince on 2019/10/11 13:31
 */
public interface TestMapper {

    Integer addTest(Test test);

    Test findTestByData2(@Param("data2") Integer data2);
}
