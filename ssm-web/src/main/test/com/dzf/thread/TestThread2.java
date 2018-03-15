package com.dzf.thread;

/**
 * @author dingzf
 * @date 2018/3/14
 * @time 21:37
 */
public class TestThread2 {
    public static void main(String[] args) {
        Resoure obj = new Resoure();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            synchronized (obj){
                                if(obj.isTt()){
                                    try {
                                        obj.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    //我们只需要在每次唤醒的时候控制的状态
                                    System.out.println(Thread.currentThread().getName()+":1");
                                    obj.setTt(true);
                                    obj.notify();
                                }
                                }
                            }
                        }
                }
        ).start();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            synchronized (obj){
                                if (!obj.isTt()) {
                                    try {
                                        obj.wait();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else{
                                    obj.setTt(false);
                                    System.out.println(Thread.currentThread().getName()+":2");
                                    obj.notify();
                                }

                            }
                        }
                    }
                }
        ).start();
    }
}
