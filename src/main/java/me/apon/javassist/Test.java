package me.apon.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Test {
    public static void main(String[] args) throws Exception{
//        hello();
        sayHi();
    }

    public static void hello() throws Exception{
        ClassPool cp = ClassPool.getDefault();
        //获取要修改的类
        CtClass cc = cp.get("me.apon.javassist.Hello");
        //获取要修改的方法
        CtMethod m = cc.getDeclaredMethod("say");
        //在say方法结束前插入代码
        m.insertAfter("System.out.println(\"hello world!\");");
        //保存.class文件
        cc.writeFile();
        //测试调用
        Class c = cc.toClass();
        Hello hello = (Hello) c.newInstance();
        hello.say();
    }
    public static void sayHi() throws Exception{
        ClassPool cp = ClassPool.getDefault();
        //获取要修改的类
        CtClass cc = cp.get("me.apon.javassist.Hello");
        //获取要修改的方法
        CtMethod m = cc.getDeclaredMethod("sayHi");
        //定义局部变量
        m.addLocalVariable("time",CtClass.longType);
        m.insertBefore("time = System.currentTimeMillis();");
        //在sayHi方法结束前插入代码
        m.insertAfter("time =  System.currentTimeMillis() - time;System.out.println(\"耗时：\"+time+\"毫秒\");");
        //保存.class文件
        cc.writeFile();
        //测试调用
        Class c = cc.toClass();
        Hello hello = (Hello) c.newInstance();
        String str = hello.sayHi("apon");
        System.out.println(str);
    }
}
