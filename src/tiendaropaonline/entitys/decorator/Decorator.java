package tiendaropaonline.entitys.decorator;

import tiendaropaonline.interfaces.IComponent;

public abstract class Decorator implements IComponent {
    protected IComponent component;

    public Decorator(IComponent component) {
        this.component = component;
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
