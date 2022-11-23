package desgin_behavior_state;

/**
 * @author YanZhao
 * @description 环境上下文，内部维护一个当前状态并负责具体状态的切换
 * 对状态进行统一管理
 * @date 2022年11月22日 20:32
 */

public class Context {

    private State state;

    // 修改状态
    public void setState(State state) {
        this.state = state;
    }

    // 对状态进行管理，调用状态的具体业务逻辑方法
    public void handle(String status){
        state.handle(status);
    }


}
