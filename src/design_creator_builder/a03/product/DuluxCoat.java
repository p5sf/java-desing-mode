package design_creator_builder.a03.product;

import java.math.BigDecimal;

/**
 * @Description 具体产品 -多乐士涂料
 * @Date 2021-12-27 17:42
 */

public class DuluxCoat implements Matter {
    public String scene() {
        return "涂料";
    }

    public String brand() {
        return "多乐士";
    }

    public String model() {
        return "第二代";
    }

    public BigDecimal price() {
        return new BigDecimal(719);
    }

    public String desc() {
        return "多乐⼠是阿克苏诺⻉尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100个国家，每年全球有5000万户家庭使⽤多乐⼠油漆。";
    }
}
