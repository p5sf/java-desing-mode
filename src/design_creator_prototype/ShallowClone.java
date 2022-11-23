package design_creator_prototype;

import java.util.List;

/**
 * @author YanZhao
 * @description 浅克隆
 * @date 2022年11月23日 16:46
 */

public class ShallowClone implements Cloneable {

    private String name;
    private int age;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected ShallowClone clone() throws CloneNotSupportedException {
        return (ShallowClone) super.clone();
    }
}
