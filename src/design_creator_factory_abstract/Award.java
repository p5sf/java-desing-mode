package design_creator_factory_abstract;

/**
 * 发送奖品活动-抽象产品 具体的实现
 */

public interface Award {

    /**
     * 获取奖品名称
     * @return
     */
    String name();

    /**
     * 获取奖品个数
     * @return
     */
    int times();

}
