package tiendaropaonline.entitys.comand;

import java.util.ArrayList;
import java.util.List;
import tiendaropaonline.interfaces.IComand;

public class Invoker {
    private List<IComand> comandos = new ArrayList<>();

    public void agregarComando(IComand comando) {
        comandos.add(comando);
    }

    public void ejecutarComando() {
        for (IComand comando : comandos) {
            comando.ejecutar();
        }
    }
}
