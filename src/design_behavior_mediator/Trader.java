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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // 得到其他租客发来的消息
    public abstract void getMessage(String message, String name);

    // 与其他租客通信
    public abstract void contactMessage(String message);

}
