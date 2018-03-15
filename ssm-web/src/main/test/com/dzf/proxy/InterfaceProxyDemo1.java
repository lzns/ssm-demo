package com.dzf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <description>
 *     实现接口无实现类，调用方法能够返回数据
 * </description>
 * @author dingzf
 * @date 2018/3/15
 * @time 22:45
 */
public class InterfaceProxyDemo1 {
    public static void main(String[] args) {
        InterfaceProxy interfaceProxy = new InterfaceProxy();

        UserMapper instance = interfaceProxy.getInstance(UserMapper.class);
        User userById = instance.getUserById(12);
        System.out.println(userById);

    }
}

interface UserMapper{
   User getUserById(Integer id);
}
class User{
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class InterfaceProxy implements InvocationHandler{

    public <T> T getInstance(Class<T> tClass){
       return (T) Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }
        return new User((Integer)args[0],"青红",12);
    }
}
