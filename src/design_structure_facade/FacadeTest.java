package design_structure_facade;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 22:15
 */

public class FacadeTest {
    public static void main(String[] args) {
        FacadeWay facadeWay = new FacadeWay();
        // 系统ABC访问
        facadeWay.visit();

        // 系统BC访问
        facadeWay.BC();
    }
}
