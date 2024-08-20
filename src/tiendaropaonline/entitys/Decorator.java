package tiendaropaonline.entitys;

import tiendaropaonline.interfaces.IComponent;

public abstract class Decorator implements IComponent{
    protected IComponent component;
    
    //Contrcutor
    public Decorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
    
}
