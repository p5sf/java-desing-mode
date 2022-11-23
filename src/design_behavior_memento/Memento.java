package design_behavior_memento;

/**
 * @author YanZhao
 * @description：包含要被恢复对象的状态
 * 备忘录角色Memento：将发起人对象传入的信息存储起来
 * @date 2022年11月23日 11:55
 */

public class Memento {
    // 备忘录信息（保存的姓名可写对象）
    private String name;

    public Memento(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
