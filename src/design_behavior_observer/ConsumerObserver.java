package design_behavior_observer;

/**
 * @author YanZhao
 * @description:具体观察者(订阅者)，接受被观察者发送状态改变通知
 * @date 2022年11月23日 14:18
 */

public class ConsumerObserver implements Observer{
    @Override
    public void update(String state) {
        System.out.println("消费者收到消息的逻辑信息-" + state);
    }
}
