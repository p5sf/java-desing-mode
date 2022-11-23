package desgin_behavior_state;

/**
 * @author YanZhao
 * @description:实现的具体逻辑
 * @date 2022年11月22日 20:29
 */

public class OrderState implements State{

    @Override
    public void handle(String status) {
        System.out.println("订单状态" + status);
    }
}
