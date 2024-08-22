package tiendaropaonline.entitys.comand;

import tiendaropaonline.interfaces.IComand;

public class ComandoConcreto implements IComand {

    private Reciever reciever;

    public ComandoConcreto(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void ejecutar() {
        reciever.action();
    }
}
