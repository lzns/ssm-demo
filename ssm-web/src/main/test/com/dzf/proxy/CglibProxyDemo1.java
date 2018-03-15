package com.dzf.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <des>
 *     cglib 是基于类代理的
 *     要点:
 *      1.实现了methodInterceptor
 * </des>
 * @author dingzf
 * @date 2018/3/15
 * @time 18:27
 */
public class CglibProxyDemo1 {
    public static void main(String[] args) {
        CglibService proxy = MyMethodInterceptoer.getCglibProxy(CglibService.class);
        proxy.out();
        proxy.out2();
    }

}

/**
 * 代理类
 */
class MyMethodInterceptoer implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 执行之前");
        methodProxy.invokeSuper(o,objects);
        System.out.println("cglib 执行之后");
        return null;
    }
    public static <T> T getCglibProxy(Class<T> clas){
        Enhancer enhancer = new Enhancer();
        //设置要代理的类
        enhancer.setSuperclass(clas);
        //设置回调
        enhancer.setCallback(new MyMethodInterceptoer());
        return (T) enhancer.create();
    }
}
class CglibService{

    public void out(){
        System.out.println("cglibService out method");
    }

    public void out2(){
        System.out.println("cglibService out2 method");
    }
}