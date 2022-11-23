package design_creator_singleton;

import java.net.StandardSocketOptions;

/**
 * @author YanZhao
 * @description 内部类线程安全
 * 既保证懒加载，同时不会因为加锁方式耗费性能
 * @date 2022年11月21日 15:54
 */

public class Singleton_04 {

    private static class SingletonHolder{
        private static Singleton_04 instance = new Singleton_04();
    }
    private Singleton_04(){

    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }
}
