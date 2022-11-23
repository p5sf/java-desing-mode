package design_creator_singleton;

/**
 * @author YanZhao
 * @description 懒汉模式（线程不安全）
 * @date 2022年11月21日 15:48
 */

public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01(){

    }

    public static Singleton_01 getInstance() {
        if (instance != null) {
            return instance;
        }
        return new Singleton_01();
    }
}
