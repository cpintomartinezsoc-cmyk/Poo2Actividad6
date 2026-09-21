package tareas;

import modelo.EstadoPedido;
import modelo.Pedido;

public class Repartidor implements Runnable {

    private String nombre;
    private Pedido pedido;

    public Repartidor(String nombre, Pedido pedido) {
        this.nombre = nombre;
        this.pedido = pedido;
    }

    @Override
    public void run() {

        pedido.setRepartidor(nombre);
        pedido.setEstado(EstadoPedido.EN_REPARTO);

        System.out.println(
                nombre + " comenzó la entrega del pedido "
                        + pedido.getId()
        );

        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        pedido.setEstado(EstadoPedido.ENTREGADO);

        System.out.println(
                nombre + " entregó el pedido "
                        + pedido.getId()
        );
    }
}