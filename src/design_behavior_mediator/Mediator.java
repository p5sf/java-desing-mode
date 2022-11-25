package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义一个抽象中介者接口：用于与租客之间进行通信联系
 * @date 2022年11月22日 17:48
 */

public abstract class Mediator {

    // 进行卖家和买家联络
    public abstract void contact(String content, Trader trader);
}
