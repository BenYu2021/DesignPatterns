package cn.sharea.singleton;

/**
 * 不仅可以解决线程同步问题，还可以防止反序列化
 * @author ymm
 * @version 1.0.0
 * @date 2021/4/13
 */
public enum SingletonEnum {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingletonEnum.INSTANCE.hashCode());
            }).start();
        }
    }

}
