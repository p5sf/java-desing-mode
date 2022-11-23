package desgin_behavior_state;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 20:47
 */

public class StateTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new GainState());
        context.handle("2");
    }
}
