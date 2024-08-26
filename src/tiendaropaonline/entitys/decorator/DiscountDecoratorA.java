
package tiendaropaonline.entitys.decorator;

import tiendaropaonline.interfaces.IComponent;

public class DiscountDecoratorA extends Decorator {
    public DiscountDecoratorA(IComponent component) {
        super(component);
    }

    @Override
    public double getDiscount() {
        return component.getDiscount() * 0.9; // 10% de descuento adicional
    }
}



