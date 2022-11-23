package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义具体交易者租客B
 * @date 2022年11月22日 17:51
 */

public class TraderB extends Trader {

    public TraderB(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void getMessage(String message, String name) {

    }

    @Override
    public void contactMessage(String message) {

    }

    public void getMessage(String message) {
        System.out.println("租客B" + message);
    }

    // 租客B与中介通信
    public void contact(String message) {
        mediator.contact(message, this);

    }
}
