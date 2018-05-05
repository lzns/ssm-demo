package com.dzf.designtest;

/**
 * <desc>
 *     开放封闭原则代码演示
 * </desc>
 * @author dingzf
 * @date 2018/3/30
 * @time 23:34
 */
public class OpenClosePrinciple {
    public static void main(String[] args) {
        //第一版
        Person person1 = new Person();
        person1.show();
        //第二版违反了开放封闭原则
        Person2 person2 = new Person2();
        person2.show();
        //改造,将变化的抽象出来，防止以后出现同样的变化
        person3 person3 = new person3();
        person3.setSkill(new SkillImpl());
        person3.shwo();
    }
}

/**
 * 刚开始类是这样的，第一版代码
 */
class Person{
    /**
     * 展示会的技能
     */
    public void show(){
        System.out.println("我会跳舞");
    }
}

/**
 * 第二版代码，我们发现这个我们违反了开发封闭原则，我们就把变化的抽象出来
 */
class Person2{
    /**
     * 展示会的技能
     */
    public void show(){
        System.out.println("我会跳舞");
        System.out.println("我会唱歌");
    }
}

/**
 * 第三版
 */
class person3{
    private Skill skill;

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void shwo(){
        if(skill!=null){
            skill.show();
        }
    }
}
abstract class Skill{
    public abstract void show();
}
class SkillImpl extends Skill{
    public void show(){
        System.out.println("我会跳舞");
        System.out.println("我会唱歌");
        System.out.println("我会写bug");
    }
}