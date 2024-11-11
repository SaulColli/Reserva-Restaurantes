package reservarestaurantes;

import Interfaces.VistaBotones;
import Interfaces.VistaCliente;
import Interfaces.VistaMesero;
import Interfaces.VistaReservas;
import javax.swing.*;
import java.awt.*;
import config.ConexionSQLServer;
import java.sql.SQLException;

public class ReservaRestaurantes extends javax.swing.JFrame {
    JPanel vistaCliente;
    JPanel otraVista;
    JPanel vistaMesero;
    
    public ReservaRestaurantes() {
        initComponents(); // Inicializa los componentes generados por NetBeans
        setSize(1200, 600); // Establecer el tamaño del JFrame (ancho, alto)
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Configurar el layout del panelContenedor
        panelContenedor.setLayout(new CardLayout());

        // Agregar vistas al panelContenedor
        vistaCliente = new VistaCliente();
        otraVista = new VistaReservas(); // Otra vista para demostrar
        vistaMesero = new VistaMesero();

        panelContenedor.add(vistaCliente, "VistaCliente"); // Agrega la vista del cliente
        panelContenedor.add(otraVista, "OtraVista"); 
        panelContenedor.add(vistaMesero, "VistaMesero");
        
//        panelBotones.setPreferredSize(new Dimension(200, getHeight())); // Ancho fijo de 200px
        revalidate(); // Ajusta el layout
    }

    public void mostrarVista(String nombreVista, JPanel nuevaVista) {
        // Obtener el CardLayout y el panelContenedor
        CardLayout layout = (CardLayout) panelContenedor.getLayout();

        // Remover la vista actual, si existe
        panelContenedor.removeAll();

        // Crear la nueva instancia de la vista a mostrar
        panelContenedor.add(nuevaVista, "VistaReserva"); // Agregar la nueva vista al panelContenedor

        // Hacer que el CardLayout muestre la nueva vista
        layout.show(panelContenedor, nombreVista);

        // Opcionalmente, si necesitas hacer un refresh de la vista, puedes usar revalidate y repaint
        nuevaVista.revalidate();
        nuevaVista.repaint();
    }


    private void btnIrVistaClienteActionPerformed(java.awt.event.ActionEvent evt) {         
        vistaCliente = new VistaCliente();
        mostrarVista("VistaCliente", vistaCliente); // Cambia a la vista de cliente
//        setSize(vistaCliente.getWidth()+panelBotones.getWidth(), vistaCliente.getHeight());
//        
//        System.out.println(panelContenedor.getSize());
//        System.out.println(panelBotones.getSize());
//        System.out.println(getSize());
//        System.out.println(vistaCliente.getSize());
    }
    
    private void btnIrOtraVistaActionPerformed(java.awt.event.ActionEvent evt) {
        otraVista = new VistaReservas();
        mostrarVista("OtraVista", otraVista); // Cambia a otra vista
    }
    
    private void btnIrVistaMeseroActionPerformed(java.awt.event.ActionEvent evt) {
        vistaMesero = new VistaMesero();
        mostrarVista("VistaMesero", vistaMesero); // Cambia a otra vista
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
        JButton btnVistaMesero = panelBotones.getjButton3();
        
        // Agregar acción a los botones
        btnVistaCliente.addActionListener(this::btnIrVistaClienteActionPerformed); // mUESTRA VISTA CLIENTE
        btnOtraVista.addActionListener(this::btnIrOtraVistaActionPerformed); // MUESTRA VISTA BOTONES
        btnVistaMesero.addActionListener(this::btnIrVistaMeseroActionPerformed);

        // Añadir botones al panel de botones
        panelBotones.add(btnOtraVista);
        panelBotones.add(btnVistaCliente);
        panelBotones.add(btnVistaMesero);

        // Añadir paneles al JFrame
        add(panelContenedor, BorderLayout.CENTER); // Panel de contenido al centro
        add(panelBotones, BorderLayout.EAST); // Panel de botones a la izquierda

        pack(); // Ajusta el tamaño del JFrame
    }
    
    public static void main(String[] args) { 
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
