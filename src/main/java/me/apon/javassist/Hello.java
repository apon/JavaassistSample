package me.apon.javassist;

public class Hello {

    public void say(){

        System.out.println("Hello.say():");

    }

    public String sayHi(String name) {
        try {
            Thread.sleep(15);//模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "Hi, " + name;
    }
}
