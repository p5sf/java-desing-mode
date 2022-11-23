package design_behavior_observer;

/**
 * @author YanZhao
 * @description 观察者一般是一个接口，每一个实现该接口都是具体的观察者
 * @date 2022年11月23日 14:14
 */

public interface Observer {

    // 更新操作
    public void update(String state);
}
