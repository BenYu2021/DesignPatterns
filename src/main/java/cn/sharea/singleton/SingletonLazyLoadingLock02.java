package cn.sharea.singleton;

/**
 * @author ymm
 * @version 1.0.0
 * @date 2021/4/13
 */
public class SingletonLazyLoadingLock02 {

    private static SingletonLazyLoadingLock02 INSTANCE;

    private SingletonLazyLoadingLock02(){}

    // synchronized 加锁，效率低
    public static  SingletonLazyLoadingLock02 getInstance(){

        if (null == INSTANCE){

            // 双重检查
            synchronized(SingletonLazyLoadingLock02.class) {

                if (null == INSTANCE) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new SingletonLazyLoadingLock02();
                }
            }


        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            // lambda表达式：只有一个方法的接口，函数式接口@FunctionalInterface
            new Thread(() -> System.out.println(SingletonLazyLoadingLock02.getInstance().hashCode())).start();
        }
    }

}
