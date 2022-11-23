package design_creator_builder.a02;


/**
 * 建造手机
 */
public interface IBuilderMobile {

    /**
     * 建造CPU
     */
    void buildCPU();

    /**
     * 建造屏幕
     */
    void buildScreen();

    /**
     * 建造电池
     */
    void buildBattery();


    /**
     * 建造内存
     */
    void buildMemory();
}
