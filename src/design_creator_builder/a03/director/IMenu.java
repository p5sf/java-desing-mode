package design_creator_builder.a03.director;


import design_creator_builder.a03.product.Matter;

/**
 * @Date 2021-12-29 19:54
 * @Description 产品类：要构建的复杂对象，可以是抽象类或者具体类
 */
public interface IMenu {

    /**
     * 吊顶
     */
    IMenu appendCeiling(Matter matter);

    /**
     * 涂料
     */
    IMenu appendCoat(Matter matter);

    /**
     * 地板
     */
    IMenu appendFloor(Matter matter);


    /**
     * 明细 具体的方法
     */
    String getDetail();
}
