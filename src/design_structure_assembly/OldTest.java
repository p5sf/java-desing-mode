package design_structure_assembly;

/**
 * @author YanZhao
 * @description 组合模式 ABC、AB 、AC
 * @date 2022年11月21日 20:55
 */

public class OldTest {
    public static void main(String[] args) {
        if ("A" == "A") {
            if ("B" == "C") {
                if ("C" == "C") {
                    System.out.println("ABC");
                }
            }
        }
        if ("A"=="A"){
            if ("C" == "C") {
                System.out.println("AC");
            }
        }
    }
}
