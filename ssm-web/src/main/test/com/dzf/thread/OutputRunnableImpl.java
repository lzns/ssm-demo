package com.dzf.thread;

/**
 * @author dingzf
 * @date 2018/3/14
 * @time 20:58
 */
public class OutputRunnableImpl implements Runnable {

    private Resoure resoure;

    public OutputRunnableImpl(Resoure resoure){
        this.resoure= resoure;
    }

    @Override
    public void run() {
        while (true){
            synchronized (resoure) {
                    if(!resoure.isTt()){
                        try {
                            resoure.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("out  notify"+resoure);
                    resoure.setTt(false);
                    resoure.notify();
                }
                }

    }
}
