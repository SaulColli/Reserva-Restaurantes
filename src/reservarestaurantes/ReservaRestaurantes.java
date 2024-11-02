package reservarestaurantes;

import Interfaces.VistaBotones;
import Interfaces.VistaCliente;
import Interfaces.VistaReservas;
import javax.swing.*;
import java.awt.*;

public class ReservaRestaurantes extends javax.swing.JFrame {

    public ReservaRestaurantes() {
        initComponents(); // Inicializa los componentes generados por NetBeans
        setSize(1200, 600); // Establecer el tamaño del JFrame (ancho, alto)
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Configurar el layout del panelContenedor
        panelContenedor.setLayout(new CardLayout());
        panelContenedor.setBackground(Color.BLUE);

        // Agregar vistas al panelContenedor
        JPanel vistaCliente = new VistaCliente();
        JPanel otraVista = new VistaReservas(); // Otra vista para demostrar

        panelContenedor.add(vistaCliente, "VistaCliente"); // Agrega la vista del cliente
        panelContenedor.add(otraVista, "OtraVista"); // Agrega otra vista
    }

    private void mostrarVista(String vista) {
        CardLayout layout = (CardLayout) panelContenedor.getLayout();
        layout.show(panelContenedor, vista); // Cambia la vista según el nombre proporcionado
    }

    private void btnIrVistaClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        mostrarVista("VistaCliente"); // Cambia a la vista de cliente
    }
    
    private void btnIrOtraVistaActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarVista("OtraVista"); // Cambia a otra vista
    }

    // Método generado por NetBeans
    private void initComponents() {
        //panelBotones = new javax.swing.JPanel();
        panelContenedor = new javax.swing.JPanel();
        panelBotones = new VistaBotones();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservas de Restaurantes");
        setLayout(new BorderLayout()); // Configura el layout del JFrame
        // Ajustar el tamaño del JFrame aquí

        // Configurar el panel de botones
        JButton btnVistaCliente = panelBotones.getjButton1();
        JButton btnOtraVista = panelBotones.getjButton2();

        // Agregar acción a los botones
        btnVistaCliente.addActionListener(this::btnIrVistaClienteActionPerformed);
        
        btnOtraVista.addActionListener(this::btnIrOtraVistaActionPerformed);

        // Añadir botones al panel de botones
        panelBotones.add(btnOtraVista);
        panelBotones.add(btnVistaCliente);

        // Añadir paneles al JFrame
        add(panelContenedor, BorderLayout.CENTER); // Panel de contenido al centro
        add(panelBotones, BorderLayout.EAST); // Panel de botones a la izquierda

        pack(); // Ajusta el tamaño del JFrame
    }
    
    public static void main(String[] args) {
        System.out.println("Hola mundooooo");
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ReservaRestaurantes vista = new ReservaRestaurantes();
                vista.setVisible(true);
            }
        });
    }
    
    // Variables de instancia
    private VistaBotones panelBotones; // Panel para los botones
    private JPanel panelContenedor; // Panel para el contenido
}
