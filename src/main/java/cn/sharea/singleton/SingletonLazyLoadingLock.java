package cn.sharea.singleton;

/**
 * @author ymm
 * @version 1.0.0
 * @date 2021/4/13
 */
public class SingletonLazyLoadingLock {

    private static SingletonLazyLoadingLock INSTANCE;

    private SingletonLazyLoadingLock(){}

    // synchronized 对函数加锁，效率低
    public static synchronized SingletonLazyLoadingLock getInstance(){
        if (null == INSTANCE){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new SingletonLazyLoadingLock();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            // lambda表达式：只有一个方法的接口，函数式接口@FunctionalInterface
            new Thread(() -> System.out.println(SingletonLazyLoadingLock.getInstance().hashCode())).start();
        }
    }

}
