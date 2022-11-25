package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义具体房主
 * @date 2022年11月22日 17:51
 */

public class HouseOwner extends Trader {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("房主获取消息：" + message);
    }

    // 房主与中介通信
    public void contact(String message) {
        mediator.contact(message, this);
    }
}
