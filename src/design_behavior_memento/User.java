package design_behavior_memento;

/**
 * @author YanZhao
 * @description：发起人角色（Originator）类，备忘录可以根据发起人对象的判断多少个发起人独享的内部状态
 * 主要功能：包含当前内部状态的备忘录对象、使用备忘录对象存储内部状态
 * @date 2022年11月23日 11:59
 */

public class User {

    // 要保存的信息（姓名可写对象）
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 保存信息到备忘录
    public Memento saveToMemento(){
        return new Memento(name);
    }

    // 从备忘录中恢复状态
    public void restoreFromMemento(Memento memento) {
        name = memento.getName();
    }
}
