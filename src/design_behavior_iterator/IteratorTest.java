package design_behavior_iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YanZhao
 * @description 迭代器模式：支持不同的方式遍历一个聚合对象，在同一个聚合可以有多个遍历
 * 缺点：因为他将存储数据和遍历数据的职责分离了，增加了新的聚合类需要增加新的迭代器类，增加系统的复杂性
 * @date 2022年11月23日 15:13
 */

public class IteratorTest {
    public static void main(String[] args) {
        List<user> list=new ArrayList<>();
        list.add(new user("yyy",16));
        list.add(new user("qqq",12));
        list.add(new user("ddd",18));
        Container container=new ContainerImpl(list);
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()){
            user user = (user) iterator.next();
            System.out.println(user.getAge()+user.getName());
        }
    }
}
