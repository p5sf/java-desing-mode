package design_behavior_visitor;

/**
 * @author YanZhao
 * @description 访问者模式
 * @date 2022年11月22日 21:53
 */

public class VisitorTest {
    public static void main(String[] args) {
        Student student = new Student();

        UserVisitor userVisitor = new UserVisitor();
        // student.accept(new UserVisitor());
        userVisitor.visit(student);

    }
}
