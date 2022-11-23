package design_creator_singleton;

/**
 * @author YanZhao
 * @description 懒汉模式（线程安全）在方法上加锁耗资源
 * @date 2022年11月21日 15:50
 */

public class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02(){

    }

    public static synchronized Singleton_02 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }
}
