package cn.sharea.singleton;

/**
 * 懒汉式
 * 第一次使用时初始化，线程不安全
 * @author ymm
 * @version 1.0.0
 * @date 2021/4/13
 */
public class SingletonLazyLoading {

    private static SingletonLazyLoading INSTANCE;

    private SingletonLazyLoading(){}

    public static SingletonLazyLoading getInstance(){
        if (null == INSTANCE){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new SingletonLazyLoading();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            // lambda表达式：只有一个方法的接口，函数式接口@FunctionalInterface
            new Thread(() -> System.out.println(SingletonLazyLoading.getInstance().hashCode())).start();
        }
    }

}
