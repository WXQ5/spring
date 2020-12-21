package com.abc.ssm.spring;



import java.util.*;

//要使用lombda函数（箭头函数）接口里面只能由一个类；
interface IUSB{
    void useUSB(int num);
}
interface IADD{
    int add(int a,int b);
}
interface MyMath{
    int cal(CalType type,int a,int b);
}
enum CalType{
    ADD("加法"),SUB("减法"),MUL("乘法"),DIV("除法");
    private String msg;

    CalType(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
public class LombdaTest {
    public static void main(String[] args) {
     /*   //不带参数

        //带参数 无返回值
        IUSB usb = (num)->{
            System.out.println("使用的是有"+num+"个端口的USB");
            System.out.println("use usb%%%%%%%%%%%%");
        };
        usb.useUSB(6);

        //带参数 有返回值
        IADD add1 = (a,b)->a+b;
        add1.add(20,30);

        MyMath math = (type,a,b)->{
            return 0;
        };*/
        List<Integer> list = Arrays.asList(4,5,2,6,9,3,5,6,7,4,2,15464,8,2);
       /*
            list.sort((a1,a2)->a1-a2);
           list.forEach(num-> System.out.println(num));
       */
        //流的方式来处理输出数据
        //list.stream().sorted().forEach(System.out::println);

        /*System.out.println("**********************");
        list.stream().distinct().map(x->x*x).map(x->x/4).forEach(x-> System.out.print(x+" "));
        */

       /* List<Integer> list1 = list.stream().map(x->x*2).filter(x->x<9).sorted().collect(Collectors.toList());
        list1.forEach(x-> System.out.println(x+"  "));*/

        List<String> strs = Arrays.asList("aaa","bbb","ccc","cba","bca","","");

        /*IntSummaryStatistics iss = list.stream().mapToInt(x->x).summaryStatistics();
        System.out.println(iss.getMax());
        System.out.println(iss.getMin());
        System.out.println(iss.getSum());
        System.out.println(iss.getAverage());
        System.out.println(iss.getCount());
        System.out.println(iss);*/

        List test = Arrays.asList(100,"Hello",true,2.2,3.4,"",200,false,"world");

        test.stream().filter(x->x instanceof Number).forEach(y-> System.out.println(y));
    }
}
