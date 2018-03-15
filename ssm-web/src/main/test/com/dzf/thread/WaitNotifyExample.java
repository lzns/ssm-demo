package com.dzf.thread;

/**
 * <p>
 *     线程中的通讯，其实就是操作共享资源
 *     等待唤醒机制
 *     1.注意wait 和Notify 或者 notifyAll 都必须使用在同步中 ，对持有监视器（锁）的线程进行操作
 *     2.wait 和 notify 的调用者必须是同一个对像
 *
 *     加同步的条件
 *     1.需要至少两个线程操作同一个共享资源
 *     注意点：
 *      1.共享的资源都要加上锁，
 *      2.必须确保是同一把锁
 *  为什么wait notify 定义在object
 *   因为锁对象任意，这些方法是操作同步线程的，只有同一锁上的等待线程，可以被同一个锁上的notify唤醒
 * </p>
 * @author dingzf
 * @date 2018/3/14
 * @time 20:53
 */
public class WaitNotifyExample {
    public static void main(String[] args) {
        Resoure resoure = new Resoure();
        new Thread(new InputRunnableImpl(resoure)).start();
        new Thread(new OutputRunnableImpl(resoure)).start();
    }
}