package tiendaropaonline.entitys.decorator;

import tiendaropaonline.interfaces.IComponent;

public class DecoratorConcretoDiscountA extends Decorator{

    public DecoratorConcretoDiscountA(IComponent component) {
        super(component);
    }
@Override
    public double getDiscount() {
       return component.getDiscount();
    }

    @Override
    public String getProd() {
        return component.getProd();
    }
}
