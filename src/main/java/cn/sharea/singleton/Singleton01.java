package cn.sharea.singleton;

/**
 * 饿汉式
 * 类加载到内存后，实例化一个单例，JVM保证线程暗杀
 * 简单实用，推荐使用
 * 缺点：不管用到与否，类装载时就完成实例化
 *
 * @author ymm
 * @version 1.0.0
 * @date 2021/4/13
 */
public class Singleton01 {

    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01 instance = Singleton01.getInstance();
        Singleton01 instance1 = Singleton01.getInstance();
        System.out.println(instance == instance1); // true
    }


}
