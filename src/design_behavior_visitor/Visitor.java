package design_behavior_visitor;


/**
 * 定义不同的访问者接口
 */
public interface Visitor {

    // 学生访问
    void visit(Student student);

    // 老师访问
    void visit(Teacher teacher);
}
