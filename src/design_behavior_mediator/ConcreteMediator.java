package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义具体中介者，定义了房东的信息和租房者的对象，通过中介对象实现了房东和房客之间的通信，让它们通过中介进行通信
 * @date 2022年11月22日 18:11
 */

public class ConcreteMediator extends Mediator{

    // 中介必须知道所有房主和房客的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setTraderB(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void contact(String message, Trader trader) {
        if (trader == houseOwner) {
            tenant.getMessage(message);
        }
        if (trader == tenant) {
            houseOwner.getMessage(message);
        }
    }
}
