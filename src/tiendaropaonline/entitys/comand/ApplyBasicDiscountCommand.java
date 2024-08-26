
package tiendaropaonline.entitys.comand;

import tiendaropaonline.entitys.decorator.DiscountDecoratorA;
import tiendaropaonline.interfaces.IComand;
import tiendaropaonline.interfaces.IComponent;

public class ApplyBasicDiscountCommand implements IComand {
    private IComponent product;

    public ApplyBasicDiscountCommand(IComponent product) {
        this.product = product;
    }

    @Override
    public void ejecutar() {
        IComponent discountedProduct = new DiscountDecoratorA(product);
        double discountedPrice = discountedProduct.getDiscount();
        System.out.println("Precio con descuento básico: $" + discountedPrice);
    }
}


