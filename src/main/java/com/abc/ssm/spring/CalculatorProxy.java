package com.abc.ssm.spring;
import org.springframework.transaction.annotation.Transactional;
//使用代理模式 代理类
public class CalculatorProxy implements Calculator{
    private Calculator calculator;

    public CalculatorProxy() {
        calculator = new CalcullatorImp();
    }
    @Override
    public void add() {
        System.out.println("验证参数");
        System.out.println("前置日志");
        calculator.add();
        System.out.println("后置日志");
    }

    @Override
    public void sub() {
        System.out.println("验证参数");
        System.out.println("前置日志");
        calculator.sub();
        System.out.println("后置日志");
    }

    @Override
    public void mul() {
        System.out.println("验证参数");
        System.out.println("前置日志");
        calculator.mul();
        System.out.println("后置日志");

    }

    @Override
    public void div() {
        System.out.println("验证参数");
        System.out.println("前置日志");
        calculator.div();
        System.out.println("后置日志");
    }
}
