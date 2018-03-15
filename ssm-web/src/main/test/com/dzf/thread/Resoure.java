package com.dzf.thread;

/**
 * <des>
 *     共享资源
 * </des>
 * @author dingzf
 * @date 2018/3/14
 * @time 20:59
 */
public class Resoure {
    private String name;
    private String age;
    private  boolean tt = false;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private  Integer count =0 ;
    public boolean isTt() {
        return tt;
    }

    public void setTt(boolean tt) {
        this.tt = tt;
    }

    public String getName() {
        return name;
    }

    public synchronized void out(){
        while (!tt){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者---------------"+count);
        tt= false;
        this.notifyAll();
    }
    public synchronized void setName(String name) {
        while (tt){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count = ++count;
        this.name = name + "-"+(count);
        System.out.println(this.name);
        tt = true;
        this.notifyAll();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Resoure{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
