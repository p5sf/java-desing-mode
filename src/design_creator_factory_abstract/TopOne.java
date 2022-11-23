package design_creator_factory_abstract;

/**
 * @author YanZhao
 * @description:抽奖的具体实现-抽一等奖
 * @date 2022年11月20日 20:48
 */

public class TopOne implements lottery{
    @Override
    public String levelAward(Integer times) {
        return "抽了" + times + "次" + "抽到一等奖";
    }

    @Override
    public int times() {
        return 2;
    }
}
