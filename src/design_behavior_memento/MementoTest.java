package design_behavior_memento;

/**
 * @author YanZhao
 * @description:备忘录模式：相当于快照，可以恢复某个状态，将某个状态保存，也可以恢复某个状态，提供回滚操作 缺点：如果类的成员过多，势必会占用较大资源
 * @date 2022年11月23日 11:53
 */

public class MementoTest {
    public static void main(String[] args) {
        // 发起人角色
        User user = new User();
        // 负责人角色
        CareTaker careTaker = new CareTaker();
        user.setName("张三");
        user.setName("李四");
        // 保存状态到备忘录中
        careTaker.add(user.saveToMemento());  // 保存的是李四
        user.setName("王五");
        // 保存状态到备忘录
        careTaker.add(user.saveToMemento()); // 保存的是王五
        user.setName("老六");
        System.out.println("最近名称" + user.getName());

        // 恢复状态
        user.restoreFromMemento(careTaker.get(0));
        System.out.println("第一" + user.getName());
        user.restoreFromMemento(careTaker.get(1));
        System.out.println("第二" + user.getName());
    }
}
