package tiendaropaonline.entitys;

import java.util.ArrayList;
import java.util.List;
import tiendaropaonline.interfaces.IComand;

public class Invoker {

    private List<IComand> comandos = new ArrayList<>();

    public void agregarComando(IComand comando) {
        comandos.add(comando);
    }

    public void ejecutarComando() {
        for (IComand comand : comandos) {
            comand.ejecutar();
        }
    }
}
