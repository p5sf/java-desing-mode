package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义具体交易者房客 负责和房东进行通信
 * @date 2022年11月22日 17:51
 */

public class Tenant extends Trader {

    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("房客获取消息:" + message);
    }


    @Override
    public void contact(String message) {
        mediator.contact(message, this);
    }
}
