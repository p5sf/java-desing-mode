package design_creator_builder.a03.product;

import java.math.BigDecimal;

/**
 * @Description 定义物料接口:提供基本信息
 * @Date 2021-12-27 17:35
 */
public interface Matter {
    String scene();     // 定义场景：地板、地砖、涂料、吊顶

    String brand();

    String model();

    BigDecimal price();

    String desc();
}
