package design_behavior_coomand;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanZhao
 * @description 调用者小二
 * 在调用者中，提供菜品的添加和菜单执行烹饪，通过外部将菜品和厨师传递进来进行调用
 * @date 2022年11月22日 14:50
 */

public class XiaoEr {

    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

    public void order(ICuisine iCuisine) {
        cuisineList.add(iCuisine);
    }

    public synchronized void placeOrder(){
        for (ICuisine iCuisine : cuisineList) {
            iCuisine.cook();
        }
        cuisineList.clear();
    }
}
