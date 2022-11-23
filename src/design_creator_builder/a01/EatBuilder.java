package design_creator_builder.a01;

/**
 * @author YanZhao
 * @description 建造者
 * @date 2022年11月21日 11:14
 */

public class EatBuilder {

    public Drink getCoca(){
        return new Coca();
    }
    public Drink getTea(){
        return new Tea();
    }
    public Food getMeat(){
        return new Meat();
    }

    public Food getFruits(){
        return new Fruits();
    }

    public Food getVegetable(){
        return new Vegetable();
    }
}
