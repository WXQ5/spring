package com.abc.ssm.spring;

import java.math.BigDecimal;

public class CalcullatorImp implements Calculator {
    @Override
    public void add() {
        System.out.println("add 加法");
    }

    @Override
    public void sub() {
        System.out.println("sub 减法");
    }

    @Override
    public void mul() {
        System.out.println("mul 乘法");
    }

    @Override
    public void div() {
        System.out.println("div 除法");
    }
}
