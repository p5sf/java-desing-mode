package design_creator_builder.a02;

/**
 * @author YanZhao
 * @description 构建手机产品，有CPU、屏幕、电池、内存
 * @date 2022年11月21日 11:30
 */

public class MobileProduct {
    private String CPU;

    private String screen;

    private String battery;

    private String memory;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
