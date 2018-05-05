package com.dzf.designtest;

/**
 * <desc>
 * 设计模式：简单工厂
 * 重要： 在工厂里面生成的对象要求具有相同的属性和功能 即：继承自同一个类，或者实现同一个接口
 * </desc>
 *
 * @author dingzf
 * @date 2018/3/30
 * @time 21:58
 */
public class SimpleFactoryDemo {
    //此时main方法就是一个舞台
    public static void main(String[] args) {
        //在表演工厂里面实例化需要的对象
        //好比我们需要一个舞蹈者，当我们需要不同的功能的表演者的时候，可以通过改变参数来获取对应的对象
        Skiller skiller = SkillerFactory.getSkiller("dancer");
        skiller.show();
    }

}

abstract class Skiller {
    public abstract void show();
}

class Dancer extends Skiller {
    @Override
    public void show() {
        System.out.println("我来表演跳舞");
    }
}

class Singer extends Skiller {
    @Override
    public void show() {
        System.out.println("我来表演精彩的舞蹈");
    }
}

class Coder extends Skiller {
    @Override
    public void show() {
        System.out.println("我来表演专业写bug，让你们赞不绝口，哈哈哈~~");
    }
}

class SkillerFactory {
    public static Skiller getSkiller(String desc) {
        Skiller skiller = null;
        switch (desc) {
            case "dancer":
                skiller = new Dancer();
                break;
            case "singer":
                skiller = new Singer();
                break;
            case "coder":
                skiller = new Coder();
                break;
        }
        return  skiller;
    }

}