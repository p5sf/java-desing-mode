package design_creator_factory_abstract;

/**
 * @author YanZhao
 * @description:抽象工厂，定义多个工厂，例如发送奖品和抽奖活动
 * 不但工厂是抽象的，产品也是抽象的。这个抽象工厂对应多个实际工厂，每个工厂负责多个实际产品
 * 定义好了抽象工厂和两个抽象产品-抽奖和发送奖品
 * @date 2022年11月20日 20:40
 */

public interface activityFactory {

    /**
     * 定义两个产品 -发送奖励和抽奖
     * @return
     */
    public abstract Award getAward(String type);

    public abstract lottery getLottery(int status);
}
