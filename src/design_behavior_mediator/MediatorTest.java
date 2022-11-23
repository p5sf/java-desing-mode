package design_behavior_mediator;

/**
 * @author YanZhao
 * 中介者模式使各个对象之间不需要相互引用，从而减少耦合，没有中介者，对象相互引用，而变成中介者就变成星型结构
 * 优点：把多对多的租客关系变成中介者一对多关系，使对象更容易理解，租客的交互都封装在中介者对象集中管理
 * 缺点：过度集中化，如果租客过多交互就变复杂，在具体中介包含了大量租客之间的交互细节，导致中介者对象十分臃肿
 * @description 抽象中介者角色（mediator）、具体中介者角色（ConcreteMediator维护各个具体对象的引用）
 * 抽象同事类角色（colleague）定义各个同事类对象共有的方法、并声明了一些抽象方法供子类实现，同时维护一个对抽象中介者的类引用
 * 具体同事类角色
 * @date 2022年11月22日 18:17
 */

public class MediatorTest {
    public static void main(String[] args) {
        // 定义中介者
        ConcreteMediator mediator = new ConcreteMediator();
        // 定义具体交易者
        TraderA traderA = new TraderA("张三", mediator);
        TraderB traderB = new TraderB("张三", mediator);
        // 中介者知晓每个具体的交易者
        mediator.setTraderA(traderA);
        mediator.setTraderB(traderB);
        traderA.contact("-");
    }
}
