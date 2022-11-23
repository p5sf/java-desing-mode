package desgin_behavior_state;

/**
 * @author YanZhao
 * @description:定义抽象状态类
 * 定义各个状态的处理流程，可定义多个行为
 * @date 2022年11月22日 20:28
 */

public interface State {

    public void handle(String status);
}
