package design_behavior_strategy;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 16:22
 */

public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context(new LotteryCoupon());
        String result = context.executeStrategy(10);
        System.out.println("执行策略：" + result);
    }
}
