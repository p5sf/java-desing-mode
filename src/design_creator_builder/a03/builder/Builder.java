package design_creator_builder.a03.builder;


import design_creator_builder.a03.director.DecorationPackageMenu;
import design_creator_builder.a03.director.IMenu;
import design_creator_builder.a03.product.*;

/**
 * @Description 建造者-封装对象得到一个产品
 * @Date 2021-12-27 17:57
 */

public class Builder {
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new AimeiCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShenXiangFloor());
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new OupuCeiling())
                .appendCoat(new LiBangCoat())
                .appendFloor(new DerFloor());
    }

    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new OupuCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat());          // 涂料，立邦
    }
}
