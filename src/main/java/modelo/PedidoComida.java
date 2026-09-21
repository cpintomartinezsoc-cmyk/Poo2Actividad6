package modelo;

public class PedidoComida extends Pedido {

    private String restaurante;

    public PedidoComida(int id, String direccionEntrega, String restaurante) {
        super(id, direccionEntrega);
        this.restaurante = restaurante;
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Pedido de comida " + id +
                        " | Restaurante: " + restaurante +
                        " | Dirección: " + direccionEntrega
        );
    }
}