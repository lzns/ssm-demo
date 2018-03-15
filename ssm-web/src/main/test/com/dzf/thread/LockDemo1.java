package com.dzf.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <description>
 *     使用lock condition 完成多生产者，多消费者模式
 *
 * </description>
 * @author dingzf
 * @date 2018/3/15
 * @time 21:54
 */
public class LockDemo1 {
    public static void main(String[] args) {
        ResourecLock resourecLock = new ResourecLock();
        ProductorLock productorLock1 = new ProductorLock(resourecLock);
        ProductorLock productorLock2 = new ProductorLock(resourecLock);
        ConsumerLock consumerLock1 = new ConsumerLock(resourecLock);
        ConsumerLock consumerLock2 = new ConsumerLock(resourecLock);
        new Thread(productorLock1).start();
        new Thread(productorLock2).start();
        new Thread(consumerLock1).start();
        new Thread(consumerLock2).start();
    }
}

/**
 * 生产者
 */
class ProductorLock implements Runnable{
    private  ResourecLock resourecLock ;
    public ProductorLock(ResourecLock resourecLock){
        this.resourecLock = resourecLock;
    }
    @Override
    public void run() {
        Lock lock = resourecLock.getLock();
        Condition condition_consu = resourecLock.getCondition_consu();
        Condition condition_prod = resourecLock.getCondition_prod();
        while (true){
            try {
                lock.lock();
                while (!resourecLock.isFlag()){
                    try {
                        condition_prod.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                resourecLock.setName("秦红霞");
                resourecLock.setAge(resourecLock.getAge()+1);
                System.out.println("生产者 ------"+resourecLock.getAge());
                resourecLock.setFlag(false);
                condition_consu.signal();
            }finally {
                lock.unlock();
            }

        }
    }
}

/**
 * 消费者
 */
class ConsumerLock implements Runnable{
    private  ResourecLock resourecLock ;
    public ConsumerLock(ResourecLock resourecLock){
        this.resourecLock = resourecLock;
    }
    @Override
    public void run() {
        Lock lock = resourecLock.getLock();
        Condition condition_consu = resourecLock.getCondition_consu();
        Condition condition_prod = resourecLock.getCondition_prod();
        while (true){
            lock.lock();
            try {
                while (resourecLock.isFlag()){
                    try {
                        condition_consu.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                resourecLock.setFlag(true);
                resourecLock.out();
                condition_prod.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}

/**
 * 共有资源
 */
class ResourecLock{
    private String name;
    private Integer age = 0;
    private  boolean flag = true;
    //定义锁
    private  Lock lock = new ReentrantLock();
    //定义条件
    private  Condition condition_prod = lock.newCondition();
    private  Condition condition_consu = lock.newCondition();

    public String getName() {
        return name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public void out(){
        System.out.println("----消费者 --=====================--" + this.getAge());
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Condition getCondition_prod() {
        return condition_prod;
    }

    public void setCondition_prod(Condition condition_prod) {
        this.condition_prod = condition_prod;
    }

    public Condition getCondition_consu() {
        return condition_consu;
    }

    public void setCondition_consu(Condition condition_consu) {
        this.condition_consu = condition_consu;
    }
}