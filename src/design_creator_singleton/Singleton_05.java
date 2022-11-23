package design_creator_singleton;

/**
 * @author YanZhao
 * @description 双重校验
 * 方法级锁的优化，减少部分实例的耗时，同时也满足了懒加载
 * @date 2022年11月21日 15:57
 */

public class Singleton_05 {
    private static Singleton_05 instance;

    private Singleton_05(){

    }

    public static Singleton_05 getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton_05.class) {
            if (instance == null) {
                instance = new Singleton_05();
            }
            return instance;
        }
    }
}
