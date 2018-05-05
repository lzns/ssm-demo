package com.dzf.test1;

/**
 * @author dingzf
 * @date 2018/3/16
 * @time 22:15
 */
public class TestDemo1 extends Thread {

    //这里注意加volatile关键字和不加的运行结果  加了volatile ，被volatile修饰的变量，
    // 保证每次修改了变量需要立即写回到主内存中去，同时通知通知所有的对改变量的缓存失效，保证缓存的一致性，
    private boolean isRunning = true;
    //private volatile boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        String a = "23";
        System.out.println("进入run方法..");
        int i = 0;
        while (isRunning) {//加了volatile标识的变量在主内存中的可见性将发挥作用
            //..
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        TestDemo1 rt = new TestDemo1();
        rt.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
       /* while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Test2 test2 = Test2.getInstance();
                    System.out.println(test2);
                }
            }).start();
        }*/
    }
}

class Test2 {
    private volatile static Test2 test2 = null;

    private Test2() {
    }

    public static Test2 getInstance() {
        if (test2 == null) {
            synchronized (Test2.class) {
                if (test2 == null) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test2 = new Test2();
                }
            }
        }
        return test2;
    }
}

class QHX {
    private String name;
    private String age;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "QHX{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        /*QHX qhx = new QHX();
        qhx.setAge("12");
        qhx.setName("暴力少年");
        qhx.setFlag(true);
       new Thread(new Qhxrunnable(qhx)).start();
       Thread.sleep(1000);
       qhx.setAge("-------------");
       qhx.setFlag(false);
        System.out.println(qhx);*/
        new Test3().start();
    }

}

class Qhxrunnable implements Runnable {
    private QHX qhx;

    public Qhxrunnable(QHX qhx) {
        this.qhx = qhx;
    }

    @Override
    public void run() {
        while (qhx.isFlag())
            System.out.println(qhx);
    }
}

class Test3 extends Thread {
    int i = 0;

    public  int incrate(){
        return  i++;
    }
    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int z = 0; z < 1000; z++) {
                       incrate();
                    }
                }
            }

            ).start();
        }
    }
}