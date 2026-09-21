package vistas;

import controlador.PedidoControlador;
import modelo.Pedido;
import tareas.Repartidor;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JButton btnRegistrar;
    private JButton btnListar;
    private JButton btnEntrega;

    private PedidoControlador controlador;

    public VentanaPrincipal() {

        setTitle("SpeedFast");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controlador = new PedidoControlador();

        crearComponentes();
    }

    private void crearComponentes() {

        setLayout(null);

        JLabel titulo = new JLabel("Sistema de Gestión SpeedFast");
        titulo.setBounds(100, 20, 250, 30);
        add(titulo);

        btnRegistrar = new JButton("Registrar Pedido");
        btnRegistrar.setBounds(100, 60, 200, 30);
        add(btnRegistrar);

        btnListar = new JButton("Listar Pedidos");
        btnListar.setBounds(100, 100, 200, 30);
        add(btnListar);

        btnEntrega = new JButton("Asignar Repartidor");
        btnEntrega.setBounds(100, 140, 200, 30);
        add(btnEntrega);

        btnRegistrar.addActionListener(e -> {

            VentanaRegistroPedido ventana =
                    new VentanaRegistroPedido(controlador);

            ventana.setVisible(true);
        });

        btnListar.addActionListener(e -> {

            VentanaListaPedidos ventana =
                    new VentanaListaPedidos(controlador);

            ventana.setVisible(true);
        });

        btnEntrega.addActionListener(e -> iniciarEntrega());
    }

    private void iniciarEntrega() {

        String idTexto = JOptionPane.showInputDialog(
                this,
                "Ingrese el ID del pedido:"
        );

        if (idTexto == null) {
            return;
        }

        try {

            int id = Integer.parseInt(idTexto);

            Pedido pedido = controlador.buscarPorId(id);

            if (pedido == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "No existe un pedido con ese ID."
                );

                return;
            }

            String nombre = JOptionPane.showInputDialog(
                    this,
                    "Ingrese el nombre del repartidor:"
            );

            if (nombre == null || nombre.isEmpty()) {
                return;
            }

            Thread hilo = new Thread(
                    new Repartidor(nombre, pedido)
            );

            hilo.start();

            JOptionPane.showMessageDialog(
                    this,
                    "Entrega iniciada para el pedido " + id
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un número."
            );
        }
    }
}