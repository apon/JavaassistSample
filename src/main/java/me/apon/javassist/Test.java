package me.apon.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Test {
    public static void main(String[] args) throws Exception{
        hello();
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
}
