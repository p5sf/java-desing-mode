package design_behavior_observer;

/**
 * @author YanZhao
 * @description 具体实现业务 -监听价格发生变化
 * @date 2022年11月23日 14:16
 */

public class PriceSubject extends Subject{

    // 具体业务
    public void doSomething(){
        System.out.println("当价格发生变化");
    }
}
