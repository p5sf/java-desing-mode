package design_behavior_coomand;

/**
 * @author YanZhao
 * @description 具体的命令实现-广东菜
 * @date 2022年11月22日 14:46
 */

public class GuangDoneCuisine implements ICuisine {

    private ICook iCook;

    public GuangDoneCuisine(ICook iCook) {
        this.iCook = iCook;
    }

    @Override
    public void cook() {
        iCook.doCooking();
    }
}
