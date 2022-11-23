package design_behavior_coomand;

/**
 * @author YanZhao
 * @description 具体的命令实现江苏菜
 * @date 2022年11月22日 14:58
 */

public class JiangSuCuisine implements ICuisine{

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
