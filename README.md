<img width="488" height="157" alt="image" src="https://github.com/user-attachments/assets/e4b3565f-f210-4cee-ac43-b91791d97880" />

# 🖥️ Actividad Formativa – Diseñando interfaces gráficas para aplicaciones en Java

---

## 👤 Datos del estudiante

**Nombre:** Camilo Pinto

**Carrera:** Analista Programador

**Asignatura:** Desarrollo Orientado a Objetos II

**Semana:** 6

**Caso:** SpeedFast


---

## 📌 Descripción

En esta actividad se continúa desarrollando el sistema de entregas **SpeedFast**, incorporando una interfaz gráfica utilizando **Java Swing**.

La aplicación permite registrar pedidos, visualizar los pedidos existentes y asignar repartidores para iniciar una entrega.

La interfaz gráfica permite interactuar directamente con los objetos y datos del sistema mediante ventanas, formularios, botones y tablas.

---

## 🏗️ Estructura del proyecto

```text
src/main/java
│
├── main
│   └── Main.java
│
├── controlador
│   └── PedidoControlador.java
│
├── interfaz
│   ├── Cancelable.java
│   ├── Despachable.java
│   └── Rastreable.java
│
├── modelo
│   ├── EstadoPedido.java
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoEncomienda.java
│   └── PedidoExpress.java
│
├── tareas
│   └── Repartidor.java
│
└── vistas
    ├── VentanaPrincipal.java
    ├── VentanaRegistroPedido.java
    └── VentanaListaPedidos.java
```

---

## 📦 Descripción de las clases

### `Pedido`

Clase abstracta que representa los pedidos de SpeedFast. Contiene información general como el ID, dirección, estado y repartidor asignado.

### `PedidoComida`

Representa los pedidos de comida realizados a través de SpeedFast.

### `PedidoEncomienda`

Representa los pedidos correspondientes a encomiendas.

### `PedidoExpress`

Representa los pedidos que utilizan el servicio de entrega express.

### `EstadoPedido`

Enum utilizado para controlar los diferentes estados de un pedido:

* `PENDIENTE`
* `EN_REPARTO`
* `ENTREGADO`

### `PedidoControlador`

Administra la lista de pedidos del sistema.

Permite agregar, listar y buscar pedidos.

### `Repartidor`

Representa la tarea realizada por un repartidor. Implementa `Runnable` y permite simular el inicio y finalización de una entrega mediante un `Thread`.

### `VentanaPrincipal`

Es la ventana principal de SpeedFast.

Permite acceder a las funciones de registro de pedidos, listado de pedidos y asignación de repartidores.

### `VentanaRegistroPedido`

Contiene el formulario utilizado para registrar nuevos pedidos.

Permite ingresar el ID, dirección y seleccionar el tipo de pedido.

### `VentanaListaPedidos`

Muestra los pedidos registrados mediante un `JTable`.

También permite actualizar la información mostrada.

### Interfaces

El proyecto mantiene las interfaces utilizadas anteriormente:

* `Cancelable`
* `Despachable`
* `Rastreable`

---

## 🖥️ Interfaz gráfica

La aplicación utiliza componentes de **Java Swing**, entre ellos:

* `JFrame`
* `JLabel`
* `JTextField`
* `JComboBox`
* `JButton`
* `JTable`
* `DefaultTableModel`
* `JOptionPane`

Estos componentes permiten que el usuario interactúe con el sistema mediante ventanas gráficas.

---

## ▶️ Ejecución

La aplicación comienza desde la clase `Main`.

Al ejecutar el programa se abre la ventana principal de **SpeedFast**.

Desde esta ventana se pueden realizar las siguientes acciones:

### Registrar pedido

Permite ingresar:

* ID del pedido.
* Dirección de entrega.
* Tipo de pedido.

Al guardar, el pedido se agrega a la lista del sistema.

### Listar pedidos

Muestra los pedidos registrados en una tabla.

La información incluye:

* ID.
* Dirección.
* Estado.
* Repartidor.

### Asignar repartidor

Permite seleccionar un pedido mediante su ID e ingresar el nombre del repartidor.

Luego se inicia una entrega utilizando un `Thread`.

El estado del pedido cambia desde `PENDIENTE` a `EN_REPARTO` y finalmente a `ENTREGADO`.


---

📁 Repositorio


Proyecto: Sistema de gestión de entregas SpeedFast

https://github.com/cpintomartinezsoc-cmyk/Poo2Actividad6.git

Entrega: 21/09/2026)

---

