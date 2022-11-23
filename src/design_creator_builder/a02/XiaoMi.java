package design_creator_builder.a02;

/**
 * @author YanZhao
 * @description
 * @date 2022年11月21日 11:41
 */

public class XiaoMi implements IBuilderMobile{
    private MobileProduct mobileProduct;

    public XiaoMi() {
        mobileProduct = new MobileProduct();
    }

    @Override
    public void buildCPU() {
        mobileProduct.setCPU("高通处理器");
    }

    @Override
    public void buildScreen() {
        mobileProduct.setScreen("OLED显示屏");

    }

    @Override
    public void buildBattery() {
        mobileProduct.setBattery("5500mAH电池");

    }

    @Override
    public void buildMemory() {
        mobileProduct.setMemory("8G内存");
    }


    /**
     * 创建手机
     * @return
     */
    public MobileProduct build(){
        return mobileProduct;
    }
}
