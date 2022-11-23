package design_creator_prototype;

import design_behavior_memento.User;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

/**
 * @author YanZhao
 * @description 原型模式：用原型实例指定创建对象种类，并且通过拷贝这些原型创建新的对象
 * 主要解决：减少创建重复对象
 * @date 2022年11月23日 16:32
 */

public class PrototypeTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("小王");
        person.setAge(12);
        try {
            Person clone = person.clone();

            System.out.println(person == clone);        // false说明指向的是两个不同对象，互不影响
            System.out.println(person.getName() == clone.getName());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------");


        // 浅克隆
        ShallowClone shallowClone = new ShallowClone();
        shallowClone.setName("小二");
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        shallowClone.setList(list);

        try {
            ShallowClone clone = shallowClone.clone();
            System.out.println(clone.getList().get(0));
            System.out.println(clone == shallowClone);    // false 对象互不影响，改内容不会影响
            System.out.println(shallowClone.getList()==clone.getList());  // true 表示两个List使用的是同一个，会相互影响
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-------------------------------");

        // 深克隆
        DeepClone deepClone = new DeepClone();
        deepClone.setName("小王");
        ArrayList<String> deepList = new ArrayList<>();
        deepList.add("BBB");
        deepClone.setList(deepList);

        try {
            DeepClone clone = deepClone.clone();
            System.out.println(clone.getList().get(0));
            System.out.println(deepClone == clone);  // false 深拷贝，两个list互不影响
            System.out.println(deepClone.getList()==clone.getList());  // false 两个list互不影响
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
