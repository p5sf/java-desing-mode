package design_behavior_coomand;

/**
 * @author YanZhao
 * @description 具体的实现者（江苏厨师）
 * @date 2022年11月22日 14:50
 */

public class JiangSuCook implements ICook{
    @Override
    public void doCooking() {
        System.out.println("江苏厨师做菜");

    }
}
