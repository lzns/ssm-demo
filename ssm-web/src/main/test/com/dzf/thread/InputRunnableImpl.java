package com.dzf.thread;

/**
 * @author dingzf
 * @date 2018/3/14
 * @time 20:57
 */
public class InputRunnableImpl implements Runnable{
    private Resoure resoure;

    public InputRunnableImpl(Resoure resoure){
        this.resoure= resoure;
    }
    @Override
    public void run() {
        boolean flag = false;
        while (true){
            synchronized (resoure) {
                    if (resoure.isTt()){
                        try {
                            resoure.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (flag) {
                        resoure.setAge("12");
                        resoure.setName("秦红霞");
                        flag = false;
                        System.out.println(" in  notify " +resoure);
                    } else {
                        resoure.setAge("111111");
                        resoure.setName("mmmmmmmmmmmmmm");
                        flag = true;
                            System.out.println("in wait" +resoure);
                    }
                    resoure.setTt(true);
                    resoure.notify();
            }
        }
    }
}
