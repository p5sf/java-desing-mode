package design_creator_prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanZhao
 * @description:深克隆
 * @date 2022年11月23日 16:44
 */

public class DeepClone implements Cloneable {

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
    protected  DeepClone clone() throws CloneNotSupportedException {
        DeepClone clone1 = (DeepClone) super.clone();
        List<String> list1=new ArrayList<>();
        for (String list2 : list){
            list1.add(list2);
        }
        clone1.setList(list1);
        return clone1;
    }
}
