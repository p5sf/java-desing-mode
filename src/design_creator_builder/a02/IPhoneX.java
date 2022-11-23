package design_creator_builder.a02;

/**
 * @author YanZhao
 * @description 构建IPhoneX
 * @date 2022年11月21日 11:37
 */

public class IPhoneX implements IBuilderMobile{

    private MobileProduct mobileProduct;

    public IPhoneX() {
        mobileProduct = new MobileProduct();
    }

    @Override
    public void buildCPU() {
        mobileProduct.setCPU("A11处理器");
    }

    @Override
    public void buildScreen() {
        mobileProduct.setScreen("OLED显示屏");

    }

    @Override
    public void buildBattery() {
        mobileProduct.setBattery("4500mAH电池");

    }

    @Override
    public void buildMemory() {
        mobileProduct.setMemory("16G内存");
    }

    /**
     * 创建手机
     * @return
     */
    public MobileProduct build(){
        return mobileProduct;
    }
}
