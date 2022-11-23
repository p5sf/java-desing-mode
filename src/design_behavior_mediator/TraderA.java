package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义具体租客A
 * @date 2022年11月22日 17:51
 */

public class TraderA extends Trader {

    public TraderA(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void getMessage(String message, String name) {
        System.out.println("租客A" + this.getName() + "被" + name + "联系");
    }

    @Override
    public void contactMessage(String message) {

    }

    public void getMessage(String message) {
        System.out.println("租客A" + message);
    }

    // 租客A与中介通信
    public void contact(String message) {
        mediator.contact(message, this);
    }
}
