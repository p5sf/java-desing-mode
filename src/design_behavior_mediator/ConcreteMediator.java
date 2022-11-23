package design_behavior_mediator;

/**
 * @author YanZhao
 * @description 定义具体中介者，用于协调各个租客之间的协作关系
 * @date 2022年11月22日 18:11
 */

public class ConcreteMediator extends Mediator{

    private TraderA traderA;
    private TraderB traderB;

    public void setTraderA(TraderA traderA) {
        this.traderA = traderA;
    }

    public void setTraderB(TraderB traderB) {
        this.traderB = traderB;
    }

    @Override
    public void contact(String content, Trader trader) {
        if (trader == traderA) {
            traderA .getMessage(content);
        }else {
            traderB.getMessage(content);

        }

    }
}
