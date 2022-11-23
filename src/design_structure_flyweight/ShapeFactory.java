package design_structure_flyweight;

import desgin_behavior_state.State;

import java.util.HashMap;

/**
 * @author YanZhao
 * @description:创建享元工厂，从池中获取管理对象
 * @date 2022年11月22日 22:39
 */

public class ShapeFactory {
    // 定义一个池容器
    private static HashMap<String, Shape> pool = new HashMap<>();

    // 工厂：判断池中是否有对象，有对象则直接返回，没有则创建然后放在池中
    public static Shape getShape(String color) {
        Shape circle = pool.get(color);
        if (circle == null) {
            circle = new Circle();
            pool.put(color, circle);
            System.out.println("新创建一个circle对象-> 颜色为：" + color);
        }
        return circle;
    }
}
