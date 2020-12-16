package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       CalculatorProxy calculatorProxy = new CalculatorProxy();
       calculatorProxy.add();
       calculatorProxy.sub();
       calculatorProxy.mul();
       calculatorProxy.div();
    }
}
