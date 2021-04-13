package cn.sharea.singleton;

/**
 * 和01相同
 *
 * @author ymm
 * @version 1.0.0
 * @date 2021/4/13
 */
public class Singleton02 {

    private static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02(){}

    public static Singleton02 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton02 instance = Singleton02.getInstance();
        Singleton02 instance1 = Singleton02.getInstance();
        System.out.println(instance == instance1); // tru
    }

}
