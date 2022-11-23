package design_behavior_coomand;

/**
 * @author YanZhao
 * @description:命令者模式不关心谁下达的命令
 * 将请求封装一个对象，类间解耦调用者和接收者没有任何依赖关系
 * 调用者（客户） -> 接收者（小二） -> 命令(做各种菜系)
 * 客户点击按钮 -> 按钮（保存） -> 各种保存逻辑 （菜单、快捷键等等）
 * 缺点如果命令过多 命令的子类就变成N个，这个类就会变得非常大。
 * @date 2022年11月22日 10:19
 */

public class OldTest {
    public static void main(String[] args) {
        // 实现点菜逻辑，如果是广东菜则请广东厨师，依次类推，如果条件过多，每次都进行逻辑判断难以维护。

    }

    // 客户下单 -> 交给小儿 -> 厨师做菜
    public static void order(int status) {
        if (1 == status) {
            // 调用小儿 -> 在调用厨师
            System.out.println("广东厨师");
        }
        if (2 == status) {
            System.out.println("上海厨师");
        }
    }
}
