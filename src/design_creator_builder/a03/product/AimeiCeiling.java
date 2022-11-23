package design_creator_builder.a03.product;

import java.math.BigDecimal;

/**
 * @Date 2021-12-29 20:09
 * @Description 具体的吊顶 -艾美吊顶
 */

public class AimeiCeiling implements Matter {

    public String scene() {
        return "吊顶";
    }

    public String brand() {
        return "装修公司自带";
    }

    public String model() {
        return "二级顶";
    }

    public BigDecimal price() {
        return new BigDecimal(260);
    }

    public String desc() {
        return "艾美吊顶描述。。。";
    }
}
