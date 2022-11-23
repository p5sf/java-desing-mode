package design_structure_flyweight;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 22:51
 */

public class Circle implements Shape {

    private int d;

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public void draw() {
        System.out.println("圆形周长：" + d);
    }
}


