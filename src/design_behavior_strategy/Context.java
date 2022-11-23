package design_behavior_strategy;

/**
 * @author YanZhao
 * @description 策略控制类，外部可以传递不同的策略实现
 * @date 2022年11月22日 16:10
 */

public class Context {

    private CouponStrategy strategy;

    public Context(CouponStrategy strategy) {
        this.strategy = strategy;
    }

    // 执行策略控制方法,统一的方法执行策略计算
    public String executeStrategy(int nums) {
        return strategy.disCount(nums);
    }
}
