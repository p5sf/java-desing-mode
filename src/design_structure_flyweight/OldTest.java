package design_structure_flyweight;

import design_behavior_visitor.User;
import design_behavior_visitor.UserVisitor;

/**
 * @author YanZhao
 * @description:减少重复的相似对象，如果创建每个对象则都要耗时
 * @date 2022年11月22日 22:37
 */

public class OldTest {
    public static void main(String[] args) {
        UserVisitor userVisitor = new UserVisitor();
        UserVisitor userVisitor1 = new UserVisitor();
        UserVisitor userVisitor2 = new UserVisitor();
    }
}
