package design_behavior_observer;

import java.util.Vector;

/**
 * @author YanZhao
 * @description 定义观察者数组，并实现增删改查，定义谁能观察谁不能观察
 * 定义了观察者订阅与取消订阅方法以及当状态发生变化使的通知方法
 * @date 2022年11月23日 14:13
 */

public class Subject {

    //观察者数组
    private Vector<Observer> oVector = new Vector<>();

    //增加一个观察者
    public void addObserver(Observer observer) {
        this.oVector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        this.oVector.remove(observer);
    }

    //通知所有观察者
    public void notifyObserver(String state) {
        for(Observer observer : this.oVector) {
            observer.update(state);
        }
    }

}
