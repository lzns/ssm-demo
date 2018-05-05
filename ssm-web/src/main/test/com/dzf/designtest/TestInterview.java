package com.dzf.designtest;

import java.util.Calendar;

/**
 * @author dingzf
 * @date 2018/4/8
 * @time 11:50
 */
public class TestInterview {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);

        String str3 = new String ("abc");
        String str4 = new String ("abc");
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));

        A ab = new B();
        ab = new B();
        Calendar calendar = Calendar.getInstance();
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(calendar.get(Calendar.YEAR) + "-"+(calendar.get(Calendar.MONTH)+1)+"-"+days);
    }
}

abstract class A {
    static {
        System.out.println("1");
    }
    public A(){
        System.out.println("2");
    }
}
class B extends A {
    private C c;
    static {
        System.out.println("B");
    }
    public B( ){
        System.out.println("C");
    }
}
class  C {
    static{
        System.out.println("wo shi c");
    }
    public C(){
        System.out.println("c constract ");
    }
}