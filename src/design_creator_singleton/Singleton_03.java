package design_creator_singleton;

/**
 * @author YanZhao
 * @description 饿汉模式（线程安全）
 * @date 2022年11月21日 15:53
 */

public class Singleton_03 {
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03(){

    }

    public static Singleton_03 getInstance() {
        return instance;
    }
}
