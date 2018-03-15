package com.dzf.enumDemo;

/**
 * <des>
 *     注意定义枚举类的时候，必须先定义enum实例
 *     也可以定义常量
 * </des>
 * @author dingzf
 * @date 2018/3/15
 * @time 20:21
 */
public enum MyEnum {
    MAN("秦红霞",12),FEMALE("侵害公司",10),ELSE;
    private String name;
    private Integer age;
    //枚举类的构造方法，默认强制私有
     MyEnum(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    MyEnum(){}

    public static String getName(Integer index){
        MyEnum[] values = MyEnum.values();
        for (MyEnum value : values) {
            if(value.getAge() == index){
                return value.getName();
            }
        }
        return  null;
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
}
class Test{
    public static void main(String[] args) {
        String name = MyEnum.getName(10);
        System.out.println(name);
        MyEnum.ELSE.setName("李四");
        String elseName = MyEnum.ELSE.getName();
        System.out.println(elseName);
    }
}