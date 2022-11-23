package design_structure_flyweight;

import java.util.Random;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月22日 22:55
 */

public class ShapeTest {
    private static final String colors[] ={ "Red", "Green", "Blue", "White", "Black" };
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            Circle circle =  (Circle)ShapeFactory.getShape(getRandomColor());// 总共创建五个对象
            circle.setD(getRandomD());
            circle.draw();
        }


    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }

    private static int getRandomD() {
        return (int)(Math.random()*100 );
    }

}
