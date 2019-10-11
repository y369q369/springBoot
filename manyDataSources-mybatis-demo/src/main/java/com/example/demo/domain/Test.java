package com.example.demo.domain;

import lombok.Data;

/**
 * Created by GrassPrince on 2019/10/11 14:12
 */
@Data
public class Test {
    private String data1;
    private Integer data2;

    public Test(String data1, Integer data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public Test() {
    }
}
