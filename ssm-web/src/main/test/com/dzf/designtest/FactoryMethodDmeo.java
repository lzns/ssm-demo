package com.dzf.designtest;

/**
 * <desc>
 *     工厂方法：定义一个创建对象的接口，让子类来决定实例化哪一个类，工厂方法使一个类的实例延迟到子类。
 * </desc>
 * @author dingzf
 * @date 2018/4/1
 * @time 21:42
 */
public class FactoryMethodDmeo {
    //客户端
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductImplOneFactory();
        Product product = productFactory.getInstance();
        product.operation();
    }
}

abstract class Product {
    public abstract void operation();
}

class ProductImplOne extends Product {
    @Override
    public void operation() {
        System.out.println("我是产品1号");
    }
}

class ProductImplTwo extends Product {
    @Override
    public void operation() {
        System.out.println("我是产品2号");
    }
}

interface ProductFactory {
    //定义创建对象的接口，再子类中去实例化目标对像
    public Product getInstance();
}
class ProductImplOneFactory implements ProductFactory {
    //子类实例化目标对象
    @Override
    public Product getInstance() {
        return new ProductImplOne();
     }
}
class ProductImplTwoFactory implements ProductFactory{
    //子类实例化目标对象
    @Override
    public Product getInstance() {
        return new ProductImplTwo();
    }
}
