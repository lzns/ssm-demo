package com.dzf.designtest;

/**
 * <p>
 *
 *    装饰设计模式：
 *   1.核心：动态的为一个对象添加一些额外的功能，就增加功能而言，比生成子类更加的灵活
 * </p>
 *
 * @author dingzf
 * @date 2018/3/28
 * @time 21:46
 */
public class DecoratorDemo1 {
    public static void main(String[] args) {
        //HashMap
        CreateComponent t = new CreateComponent();
        DecoratorOne decoratorOne = new DecoratorOne();
        DecoratorTwo decoratorTwo= new DecoratorTwo();
        decoratorOne.setComponent(t);
        decoratorTwo.setComponent(decoratorOne);
        decoratorTwo.a();
    }
}

abstract class  Component{
    //初始的功能
    public abstract void a();
}
class CreateComponent extends Component{
    @Override
    public void a() {
        System.out.println("我会用java");
    }
}
abstract  class Decorator extends Component{
    private Component component;
    public  void setComponent(Component component){
        this.component= component;
    }

    @Override
    public void a() {
        if (component!=null){
            component.a();
        }
    }
}
class DecoratorOne extends Decorator{
    @Override
    public void a() {
        System.out.println("我是秦虹下，我会做饭");
        super.a();
    }
}
class DecoratorTwo extends Decorator{
    @Override
    public void a() {
        System.out.println("我会吃水果");
        super.a();
    }
}