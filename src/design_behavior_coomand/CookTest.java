package design_behavior_coomand;

/**
 * @author YanZhao
 * @description 小二（命令的调用者）、厨师（逻辑实现）菜品（命令实现）
 * @date 2022年11月22日 15:00
 */

public class CookTest {
    public static void main(String[] args) {
        // 菜品和厨师结合，每个具体的命令都拥有一个对应的实现类，进行组合。
        GuangDoneCuisine doneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine suCuisine = new JiangSuCuisine(new JiangSuCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(doneCuisine);
        xiaoEr.order(suCuisine);

        xiaoEr.placeOrder();
    }
}
