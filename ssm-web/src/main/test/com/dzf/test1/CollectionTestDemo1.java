package com.dzf.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingzf
 * @date 2018/3/18
 * @time 22:56
 */
public class CollectionTestDemo1 {
    private static String atr;
    private static TestDemo1 tt;
    public static void main(String[] args) {
        List<Test33> list = new ArrayList<>();
        list.add(new Test33());
        list.add(new Test33());
        list.add(new Test33());
        list.add(new Test33());
        /*for (Test33 test33 : list) {

        }*/
        System.out.println(list);
       /* List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);
        Collections.shuffle(list);
        System.out.println(list);*/
    }
    public CollectionTestDemo1(){
        System.out.println("构造器初始化。。。。");
    }
}
class Test32{
    public static String str;
    public Test32(){
        System.out.println("构造器初始化。。。");
    }
    public static void getInfo(){
        System.out.println("静态方法执行中。。。");
    }
    public Test33 getTest33(){
        return new Test33() {};
    }
}

 class Test33 {
     @Override
     public String toString() {
         //return "test33" + this; 这样写会发生递归调用。调用tostrng的方法，会去调用this的tostrng，一直循环
         return super.toString();
     }
     public void ates(){
         Thread t = new Thread();
     }
 }