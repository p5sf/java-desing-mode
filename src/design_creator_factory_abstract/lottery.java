package design_creator_factory_abstract;


/**
 * 工厂-抽奖活动
 */
public interface lottery {

    /**
     * 抽奖-抽到几等奖
     *
     * @param times
     * @return
     */
    String levelAward(Integer times);


    /**
     * 抽奖次数
     */

    int times();
}
