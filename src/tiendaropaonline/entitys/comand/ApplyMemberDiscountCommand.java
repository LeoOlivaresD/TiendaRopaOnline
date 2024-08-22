
package tiendaropaonline.entitys.comand;

import tiendaropaonline.entitys.decorator.DiscountDecoratorB;
import tiendaropaonline.interfaces.IComand;
import tiendaropaonline.interfaces.IComponent;

public class ApplyMemberDiscountCommand implements IComand {
    private IComponent product;

    public ApplyMemberDiscountCommand(IComponent product) {
        this.product = product;
    }

    @Override
    public void ejecutar() {
        IComponent discountedProduct = new DiscountDecoratorB(product);
        double discountedPrice = discountedProduct.getDiscount();
        System.out.println("Precio con descuento de miembro: $" + discountedPrice);
    }
}
