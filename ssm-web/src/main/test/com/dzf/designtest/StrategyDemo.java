package com.dzf.designtest;

/**
 * <desc>
 *   策略模式：定义了一系列的算法，让这些算法之间可以互相的替换
 * <p>
 * </desc>
 *
 * @author dingzf
 * @date 2018/4/1
 * @time 11:23
 */
public class StrategyDemo {
    //客户端
    public static void main(String[] args) {
      Context context1 = new Context("strategyOne");
      context1.operate();
      Context context2 = new Context("strategyTwo");
      context2.operate();
      Context context3 = new Context("strategyThree");
      context3.operate();
    }
}


/**
 * 策略模式中的上下文对象，引用策略模式中的策略类
 */
class Context{
    private SupperStrategy supperStrategy;
    public Context(String supperStrategy) {
        switch (supperStrategy){
            case "strategyOne" :
                this.supperStrategy = new StrategyOne();
                break;
            case "strategyTwo" :
                this.supperStrategy = new StrategyTwo();
                break;
            case "strategyThree" :
                this.supperStrategy = new StrategyThree();
                break;
        }
    }
    public void operate(){
        if(supperStrategy!=null){
            supperStrategy.getResult();
        }
    }
}

/**
 * 策略类
 */
abstract class SupperStrategy {
    public abstract void getResult();
}

/**
 * 策略子类1
 */
class StrategyOne extends SupperStrategy {
    @Override
    public void getResult() {
        System.out.println("我会策略1号");
    }
}
/**
 * 策略子类2
 */
class StrategyTwo extends SupperStrategy {
    @Override
    public void getResult() {
        System.out.println("我会策略2号");
    }
}
/**
 * 策略子类3
 */
class StrategyThree extends SupperStrategy {
    @Override
    public void getResult() {
        System.out.println("我会策略3号");
    }
}



