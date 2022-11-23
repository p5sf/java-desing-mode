package desgin_behavior_state;

/**
 * @author YanZhao
 * @description 具体状态类
 * @date 2022年11月22日 20:31
 */

public class GainState implements State{
    @Override
    public void handle(String status) {
        System.out.println("收获状态" + status);
    }
}
