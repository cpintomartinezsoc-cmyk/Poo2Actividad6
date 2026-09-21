package vistas;

import controlador.PedidoControlador;
import modelo.Pedido;
import modelo.PedidoComida;
import modelo.PedidoEncomienda;
import modelo.PedidoExpress;

import javax.swing.*;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox<String> cmbTipo;
    private JButton btnGuardar;

    private PedidoControlador controlador;

    public VentanaRegistroPedido(PedidoControlador controlador) {

        this.controlador = controlador;

        setTitle("Registrar Pedido");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        crearComponentes();
    }

    private void crearComponentes() {

        setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 30, 100, 30);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(130, 30, 200, 30);
        add(txtId);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 70, 100, 30);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(130, 70, 200, 30);
        add(txtDireccion);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 110, 100, 30);
        add(lblTipo);

        cmbTipo = new JComboBox<>(
                new String[]{
                        "Comida",
                        "Encomienda",
                        "Express"
                }
        );

        cmbTipo.setBounds(130, 110, 200, 30);
        add(cmbTipo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, 150, 200, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> guardarPedido());
    }

    private void guardarPedido() {

        if (txtId.getText().isEmpty()
                || txtDireccion.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debe completar todos los campos."
            );

            return;
        }

        try {

            int id = Integer.parseInt(txtId.getText());

            String direccion = txtDireccion.getText();

            String tipo = cmbTipo.getSelectedItem().toString();

            Pedido pedido;

            if (tipo.equals("Comida")) {

                pedido = new PedidoComida(
                        id,
                        direccion,
                        "Restaurante SpeedFast"
                );

            } else if (tipo.equals("Encomienda")) {

                pedido = new PedidoEncomienda(
                        id,
                        direccion,
                        direccion
                );

            } else {

                pedido = new PedidoExpress(
                        id,
                        direccion,
                        "Compra Express"
                );
            }

            controlador.agregarPedido(pedido);

            JOptionPane.showMessageDialog(
                    this,
                    "Pedido registrado correctamente."
            );

            txtId.setText("");
            txtDireccion.setText("");

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un número."
            );
        }
    }
}