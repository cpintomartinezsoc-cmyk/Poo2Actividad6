package controlador;

import modelo.Pedido;

import java.util.ArrayList;

public class PedidoControlador {

    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public ArrayList<Pedido> listarPedidos() {
        return pedidos;
    }

    public Pedido buscarPorId(int id) {

        for (Pedido pedido : pedidos) {

            if (pedido.getId() == id) {
                return pedido;
            }
        }

        return null;
    }
}