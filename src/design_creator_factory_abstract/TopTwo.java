package design_creator_factory_abstract;

/**
 * @author YanZhao
 * @description 抽奖的具体实现-抽二等奖
 * @date 2022年11月20日 20:49
 */

public class TopTwo implements lottery{
    @Override
    public String levelAward(Integer times) {
        return "抽了" + times + "次" + "抽到二等奖";
    }

    @Override
    public int times() {
        return 1;
    }
}
