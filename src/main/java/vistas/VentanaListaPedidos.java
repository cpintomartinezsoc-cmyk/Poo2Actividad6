package vistas;

import controlador.PedidoControlador;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaListaPedidos extends JFrame {

    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JButton btnActualizar;

    private PedidoControlador controlador;

    public VentanaListaPedidos(PedidoControlador controlador) {

        this.controlador = controlador;

        setTitle("Lista de Pedidos");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        crearComponentes();
        cargarDatos();
    }

    private void crearComponentes() {

        setLayout(null);

        modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Repartidor");

        tabla = new JTable(modeloTabla);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 20, 540, 150);

        add(scroll);

        btnActualizar = new JButton("Actualizar");

        btnActualizar.setBounds(200, 190, 150, 30);

        add(btnActualizar);

        btnActualizar.addActionListener(e -> cargarDatos());
    }

    private void cargarDatos() {

        modeloTabla.setRowCount(0);

        for (Pedido pedido : controlador.listarPedidos()) {

            modeloTabla.addRow(
                    new Object[]{
                            pedido.getId(),
                            pedido.getDireccionEntrega(),
                            pedido.getEstado(),
                            pedido.getRepartidor()
                    }
            );
        }
    }
}