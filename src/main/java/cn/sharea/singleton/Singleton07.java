package cn.sharea.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时，不会加载内部类，lazy loading
 * @author ymm
 * @version 1.0.0
 * @date 2021/4/13
 */
public class Singleton07 {

    private Singleton07(){}


    // 静态内部类
    private static class Singleton07Holder{
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    public static Singleton07 getInstance(){
        return Singleton07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            // lambda表达式：只有一个方法的接口，函数式接口@FunctionalInterface
            new Thread(() -> System.out.println(Singleton07.getInstance().hashCode())).start();
        }
    }



}
