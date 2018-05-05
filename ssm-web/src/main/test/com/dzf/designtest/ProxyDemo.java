package com.dzf.designtest;

/**
 * <desc>
 *     代理模式：为其他对象提供一种代理以控制对这个对象的访问
 *
 * </desc>
 * @author dingzf
 * @date 2018/4/1
 * @time 17:56
 */
public class ProxyDemo {
    //客户端调用
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.print();
    }
}
abstract class Subject{
    public abstract void print();
}
class RealSubject extends Subject{
    @Override
    public void print() {
        System.out.println("我是真实的对象1");
    }
}
class Proxy extends Subject{
    private Subject subject;

    @Override
    public void print() {
        if(subject == null){
            subject = new RealSubject();
        }
        subject.print();//执行真实对象的方法或者行为
    }
}