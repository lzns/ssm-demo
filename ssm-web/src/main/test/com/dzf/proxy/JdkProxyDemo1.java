package com.dzf.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <dsc>
 *     JDK 的代理只能代理接口
 *
 * </dsc>
 * @author dingzf
 * @date 2018/3/15
 * @time 18:26
 */
public class JdkProxyDemo1 {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        JdkProxy<Service> jdkProxy = new JdkProxy<>(service);
        Service bind = jdkProxy.bind();
        bind.out();
        bind.out2();
    }
}

/**
 * interface
 */
interface Service{
   void out();
   void out2();
}

/**
 * 具体实现类
 */
class ServiceImpl implements Service{
    @Override
    public void out() {
        System.out.println("service 的实现类的out  method");
    }

    @Override
    public void out2() {
        System.out.println("service 的实现类的out2 method");
    }
}

class JdkProxy<T> implements InvocationHandler{

    private T target;

    public JdkProxy(T t){
        this.target = t;
    }

    public T  bind(){
       return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行jdk 动态代理之前 ");
        System.out.println("执行的方法的名字 ："+method.getName());
        System.out.println("这个被代理对象的字节码文件对象是："+method.getDeclaringClass());
        method.invoke(target,args);
        return null;
    }
}