package design_creator_builder.a02;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 11:44
 */

public class MobileDirector {

    /**
     * 具体创建一步手机
     */
    public IBuilderMobile createMobile(IBuilderMobile mobile) {
        mobile.buildBattery();
        mobile.buildCPU();
        mobile.buildScreen();
        mobile.buildScreen();
        return mobile;
    }
}
