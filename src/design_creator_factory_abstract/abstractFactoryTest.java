package design_creator_factory_abstract;

/**
 * @author YanZhao
 * @description 测试抽象类 具体实现
 * 主要解决一个产品族，存在不同类型的产品
 * @date 2022年11月20日 23:52
 */

public class abstractFactoryTest {
    public static void main(String[] args) {
        activityFactoryImpl factory = new activityFactoryImpl();
        Award award = factory.getAward("兑换卡");
        String name = award.name();
        int times = award.times();
        System.out.println("获取发送奖品的名称" + name + "获取多少张：" + times);

        lottery lottery = factory.getLottery(1);
        String level = lottery.levelAward(1);
        System.out.println("获取一等奖" + level);


    }
}
