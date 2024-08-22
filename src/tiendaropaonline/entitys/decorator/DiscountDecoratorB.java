/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaropaonline.entitys.decorator;

import tiendaropaonline.interfaces.IComponent;

public class DiscountDecoratorB extends Decorator {
    public DiscountDecoratorB(IComponent component) {
        super(component);
    }

    @Override
    public double getDiscount() {
        return component.getDiscount() * 0.8; // 20% de descuento adicional
    }
}
