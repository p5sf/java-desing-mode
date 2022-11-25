package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义抽象租客角色
 * @date 2022年11月22日 17:50
 */

public abstract class Trader {
    private String name;
    protected Mediator mediator;

    public Trader(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void getMessage(String message);
    public void contact(String message) {
        mediator.contact(message, this);
    }
}
