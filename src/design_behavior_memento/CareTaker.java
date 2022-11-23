package design_behavior_memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanZhao
 * @description:负责人角色
 * 主要功能：负责保存备忘录对象、不检查备忘录对象内容
 * @date 2022年11月23日 12:05
 */

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
