package com.dzf.thread;

/**
 * <des>
 *     生产者消费者 之多线程  多生产者 多消费者
 *     需要循环判断标记，必须使用while 循环判断标记
 * </des>
 *
 * @author dingzf
 * @date 2018/3/14
 * @time 23:04
 */
public class ProductorConsumerExample {
    public static void main(String[] args) {
        Resoure resoure = new Resoure();
        Productor p1 = new Productor(resoure);
        Productor p2 = new Productor(resoure);
        Consumer con1 = new Consumer(resoure);
        Consumer con2 = new Consumer(resoure);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(con1).start();
        new Thread(con2).start();
        new Thread(con2).start();
    }
}
class Productor implements Runnable{
    private    Resoure resoure;
    public Productor(Resoure resoure){
        this.resoure = resoure;
    }
    @Override
    public void run() {
        while (true){
            resoure.setName("生产者-");
        }
    }
}
class Consumer implements Runnable{
    private    Resoure resoure;
    public Consumer(Resoure resoure){
        this.resoure = resoure;
    }
    @Override
    public void run() {
        while (true) {
            resoure.out();
        }
    }
}