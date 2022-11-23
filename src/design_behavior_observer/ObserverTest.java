package design_behavior_observer;

/**
 * @author YanZhao
 * @description 观察者模式：当状态发生变化，所有相关依赖的都会变化
 * 当对象间存在一对多关系则使用观察者模式，当一个对象被修改时，则会自动通知依赖它的对象
 * 案例：当价格发生变化，消费者和管理员都感兴趣，第一时间通知他们
 * @date 2022年11月23日 13:47
 */

public class ObserverTest {
    public static void main(String[] args) {
        // 创建一个主题
        PriceSubject subject = new PriceSubject();
        // 添加观察者
        AdminObserver observer = new AdminObserver();
        ConsumerObserver consumerObserver = new ConsumerObserver();

        // 添加观察者（订阅）
        subject.addObserver(observer);
        subject.addObserver(consumerObserver);


        // 取消订阅
        subject.deleteObserver(consumerObserver);
        // 添加监听活动
        subject.doSomething();
        // 通知所有观察者
        subject.notifyObserver("价格发生变化了！！");

    }
}
