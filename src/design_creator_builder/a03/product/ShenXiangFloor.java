package design_creator_builder.a03.product;

import java.math.BigDecimal;

/**
 * @Description 具体的产品 -圣象地板
 * @Date 2021-12-27 17:43
 */

public class ShenXiangFloor implements Matter {
    public String scene() {
        return "地板";
    }

    public String brand() {
        return "圣象";
    }

    public String model() {
        return "A+";
    }

    public BigDecimal price() {
        return new BigDecimal(119);
    }

    public String desc() {
        return "圣象集团是全球领先的专业木地板制造商，北京2008年奥运会家装和公装地板供应商";
    }
}
