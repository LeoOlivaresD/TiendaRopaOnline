package tiendaropaonline.entitys;

import tiendaropaonline.interfaces.IComponent;

public class DecoratorConcreto extends Decorator {

    public DecoratorConcreto(IComponent component) {
        super(component);
    }

    public void operator() {
        super.operation();
    }
}
