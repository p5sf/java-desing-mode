package desgin_behavior_state;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 20:30
 */

public class DeliverState implements State{
    @Override
    public void handle(String status) {
        System.out.println("发货状态" + status);
    }
}
