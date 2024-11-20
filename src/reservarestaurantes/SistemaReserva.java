/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservarestaurantes;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Mesero;
import Entidades.Reserva;
import config.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author noeal
 */
public class SistemaReserva {
    public SistemaReserva(){
    } 
    
    public int inputEntero(String mensaje){
        String input = "";
        boolean esNumeroValido = false;

        while (!esNumeroValido) {
            input = JOptionPane.showInputDialog(mensaje);

            // Verificar que la entrada no sea nula y que sea numérica
            if (input != null && input.matches("\\d+")) {
                esNumeroValido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }
        }

        int idCliente = Integer.parseInt(input);
        return idCliente;
    }
    
    public void crearCliente(String nombre, String primerApe, String segundoApe, String telefono,int tipo){
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlCrear = "INSERT INTO Cliente VALUES(?,?,?,?,?)";
        
        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlCrear);
            pst.setString(1, nombre);
            pst.setString(2, primerApe);
            pst.setString(3, segundoApe);
            pst.setString(4, tipo + "");
            pst.setString(5, telefono);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El cliente ha sido registrado");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente. Error en el query");
        }
    }
    
    public ArrayList<Cliente> obtenerListaCliente(){
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlQuery = "SELECT * FROM Cliente";

        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // Crear un nuevo objeto Cliente con los datos de la base de datos
                int idCliente = rs.getInt("IdCliente");
                String nombre = rs.getString("Nombre");
                String primerApellido = rs.getString("PrimerApellido");
                String segundoApellido = rs.getString("SegundoApellido");
                String tipoCliente = rs.getString("TipoCliente");
                String telefono = rs.getString("telefono");

                // Crear un nuevo cliente
                Cliente cliente = new Cliente(idCliente, nombre, primerApellido, segundoApellido, tipoCliente, telefono);
                clientes.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de clientes.");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta de la lista de clientes.");
        }
        
        return clientes;
    }
    
    public ArrayList<Mesa> obtenerListaMesa() {
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlQuery = "SELECT * FROM Mesa";  // Consulta para obtener todas las mesas

        // Crear un ArrayList para almacenar las mesas
        ArrayList<Mesa> mesas = new ArrayList<>();

        try {
            // Conectar a la base de datos
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();  // Ejecutar la consulta

            // Iterar sobre el resultado de la consulta y mapear cada fila a un objeto Mesa
            while (rs.next()) {
                // Obtener los datos de la base de datos para cada mesa
                int idMesa = rs.getInt("IdMesa");
                int capacidadPersonas = rs.getInt("CapacidadPersonas");
                String descripcionZona = rs.getString("DescripcionZona");

                // Crear un objeto Mesa con los datos obtenidos
                Mesa mesa = new Mesa(idMesa, capacidadPersonas, descripcionZona);

                // Agregar la mesa al ArrayList
                mesas.add(mesa);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de mesas.");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta de la lista de mesas.");
        }

        // Retornar la lista de mesas
        return mesas;
    }
    
    public ArrayList<Mesero> obtenerListaMesero() {
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlQuery = "SELECT * FROM Mesero";  // Consulta para obtener todos los meseros

        // Crear un ArrayList para almacenar los meseros
        ArrayList<Mesero> meseros = new ArrayList<>();

        try {
            // Conectar a la base de datos
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();  // Ejecutar la consulta

            // Iterar sobre el resultado de la consulta y mapear cada fila a un objeto Mesero
            while (rs.next()) {
                // Obtener los datos de la base de datos para cada mesero
                int idMesero = rs.getInt("IdMesero");
                String nombre = rs.getString("Nombre");
                String primerApellido = rs.getString("PrimerApellido");
                String segundoApellido = rs.getString("SegundoApellido");
                String turno = rs.getString("Turno");

                // Crear un objeto Mesero con los datos obtenidos
                Mesero mesero = new Mesero(idMesero, nombre, primerApellido, segundoApellido, turno);

                // Agregar el mesero al ArrayList
                meseros.add(mesero);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de meseros.");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta de la lista de meseros.");
        }

        // Retornar la lista de meseros
        return meseros;
    }
    
    public ArrayList<Mesero> obtenerListaMeseroPorString(String valor) {
        ConexionSQLServer con = new ConexionSQLServer();
        // Consulta SQL para buscar meseros cuyo Nombre, PrimerApellido, SegundoApellido o Turno coincidan con la palabra clave
        String sqlQuery = "SELECT * FROM Mesero WHERE CONCAT(IdMesero, ' ', Nombre, ' ', PrimerApellido, ' ', SegundoApellido) LIKE ?";

        // Crear un ArrayList para almacenar los meseros encontrados
        ArrayList<Mesero> meseros = new ArrayList<>();

        try {
            // Conectar a la base de datos
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlQuery);

            // Asignar la palabra clave con el formato '%valor%' para la búsqueda parcial
            String searchPattern = "%" + valor + "%";
            pst.setString(1, searchPattern);

            ResultSet rs = pst.executeQuery(); // Ejecutar la consulta

            // Iterar sobre el resultado de la consulta y mapear cada fila a un objeto Mesero
            while (rs.next()) {
                // Obtener los datos de la base de datos para cada mesero
                int idMesero = rs.getInt("IdMesero");
                String nombre = rs.getString("Nombre");
                String primerApellido = rs.getString("PrimerApellido");
                String segundoApellido = rs.getString("SegundoApellido");
                String turno = rs.getString("Turno");

                // Crear un objeto Mesero con los datos obtenidos
                Mesero mesero = new Mesero(idMesero, nombre, primerApellido, segundoApellido, turno);

                // Agregar el mesero al ArrayList
                meseros.add(mesero);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al buscar meseros por palabra clave.");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta para buscar meseros.");
        }

        // Retornar la lista de meseros encontrados
        return meseros;
    }

    
    public ArrayList<Reserva> obtenerListaReserva(String valor) {
    ConexionSQLServer con = new ConexionSQLServer();

    // Consulta SQL corregida
    String sqlQuery = "SELECT Reserva.IdReserva, Reserva.FechaHoraReserva, Reserva.Estado, Reserva.Turno, Reserva.Preferencia,"
            + "CONCAT(Cliente.Nombre, ' ', Cliente.PrimerApellido, ' ', Cliente.SegundoApellido) AS ClienteNombreCompleto,"
            + "CONCAT(Mesero.Nombre, ' ', Mesero.PrimerApellido, ' ', Mesero.SegundoApellido) AS MeseroNombreCompleto,"
            + "Reserva.IdMesa "
            + "FROM Reserva "
            + "INNER JOIN Cliente ON Reserva.IdCliente = Cliente.IdCliente "
            + "INNER JOIN Mesero ON Reserva.IdMesero = Mesero.IdMesero "
            + "WHERE CONCAT(Cliente.Nombre, ' ', Cliente.PrimerApellido, ' ', Cliente.SegundoApellido, ' ', Mesero.Nombre, ' ', Mesero.PrimerApellido, ' ', Mesero.SegundoApellido, ' ', Reserva.Turno) "
            + "LIKE ?";

    ArrayList<Reserva> reservas = new ArrayList<>();

    try {
        Connection cn = con.Conectar();
        PreparedStatement pst = cn.prepareStatement(sqlQuery);
        pst.setString(1, "%" + valor + "%"); // Establecer el parámetro correctamente
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            // Extraer los datos de cada columna de la tabla Reserva
            int idReserva = rs.getInt("IdReserva");
            Date fechaHoraReserva = rs.getTimestamp("FechaHoraReserva");
            String estado = rs.getString("Estado");
            String turno = rs.getString("Turno");
            String preferencia = rs.getString("Preferencia");
            String nombreCompletoCliente = rs.getString("ClienteNombreCompleto");
            String nombreCompletoMesero = rs.getString("MeseroNombreCompleto");
            int idMesa = rs.getInt("IdMesa");

            // Crear una nueva instancia de Reserva con los datos obtenidos
            Reserva reserva = new Reserva(idReserva, fechaHoraReserva, estado, turno, preferencia, nombreCompletoMesero, nombreCompletoCliente, idMesa);
            reservas.add(reserva);
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error al obtener la lista de reservas.");
    } catch (SQLException ex) {
        Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error en la consulta de la lista de reservas.");
    }

    return reservas;
}


    
    public void crearReserva(Timestamp fechaHoraReserva, String estado, String turno, String preferencia,int idMesero, int idCliente, int idMesa){
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlCrear = "INSERT INTO Reserva VALUES(?,?,?,?,?,?,?)";
        
        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlCrear);
            pst.setTimestamp(1, fechaHoraReserva);
            pst.setString(2, estado);
            pst.setString(3, turno);
            pst.setString(4, preferencia);
            pst.setInt(5, idMesero);
            pst.setInt(6, idCliente);
            pst.setInt(7, idMesa);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La reserva ha sido registrada");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente. Error en el query");
        }
    }
    
    public ArrayList<Cliente> obtenerListaClientePorString(String valor){
        ConexionSQLServer con = new ConexionSQLServer();
        
        // Generamos la consulta SQL con la concatenación de las columnas y el valor de búsqueda
        String sqlQuery = "SELECT * FROM Cliente " +
                      "WHERE CONCAT(IdCliente, ' ', Nombre, ' ', PrimerApellido, ' ', SegundoApellido, ' ', TipoCliente, ' ', telefono) " +
                      "LIKE ?";


        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, "%" + valor + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // Crear un nuevo objeto Cliente con los datos de la base de datos
                int idCliente = rs.getInt("IdCliente");
                String nombre = rs.getString("Nombre");
                String primerApellido = rs.getString("PrimerApellido");
                String segundoApellido = rs.getString("SegundoApellido");
                String tipoCliente = rs.getString("TipoCliente");
                String telefono = rs.getString("telefono");

                // Crear un nuevo cliente
                Cliente cliente = new Cliente(idCliente, nombre, primerApellido, segundoApellido, tipoCliente, telefono);
                clientes.add(cliente);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de clientes.");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta de la lista de clientes.");
        }
        System.out.println("Y");
        return clientes;
    }
    
    public ArrayList<Reserva> obtenerListaReservaPorStringYRangoFecha(String valor, Timestamp fechaInicial, Timestamp fechaFinal, String estatus) {
        ConexionSQLServer con = new ConexionSQLServer();

        // Generamos la consulta SQL con la concatenación de las columnas y el valor de búsqueda
        String sqlQuery = "SELECT * "
                + "FROM Reserva "
                + "INNER JOIN Cliente ON Reserva.IdCliente = Cliente.IdCliente "
                + "INNER JOIN Mesero ON Reserva.IdMesero = Mesero.IdMesero "
                + "WHERE CONCAT(Mesero.Nombre, ' ', Mesero.PrimerApellido, ' ', Mesero.SegundoApellido, ' ', Cliente.Nombre, ' ', Cliente.PrimerApellido, ' ', Cliente.SegundoApellido, ' ', Reserva.Turno) " 
                + "LIKE ? AND FechaHoraReserva <= ? AND FechaHoraReserva >= ? AND Estado = ?";
        
        
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlQuery);
            pst.setString(1, "%" + valor + "%");
            pst.setTimestamp(2, fechaFinal);
            pst.setTimestamp(3, fechaInicial);
            pst.setString(4, estatus);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // Extraer los datos de cada columna de la tabla Reserva
                int idReserva = rs.getInt("IdReserva");
                Date fechaHoraReserva = rs.getTimestamp("FechaHoraReserva");
                String estado = rs.getString("Estado");
                String turno = rs.getString("Turno");
                String preferencia = rs.getString("Preferencia");
                int idMesero = rs.getInt("IdMesero");
                int idCliente = rs.getInt("IdCliente");
                int idMesa = rs.getInt("IdMesa");

                // Crear una nueva instancia de Reserva con los datos obtenidos
                Reserva reserva = new Reserva(idReserva, fechaHoraReserva, estado, turno, preferencia, idMesero + "", idCliente + "", idMesa);
                reservas.add(reserva);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de reservas.");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta de la lista de reservas.");
        }

        return reservas;
    }
    
    public void crearMesero(String nombre, String primerApe, String turno, String segundoApe){
        ConexionSQLServer con= new ConexionSQLServer();
        String sqlCrear = "INSERT INTO Mesero VALUES(?,?,?,?)";
        
        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlCrear);
            pst.setString(1, nombre);
            pst.setString(2, primerApe);
            pst.setString(3, turno);
            pst.setString(4, segundoApe);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El mesero ha sido registado");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar al mesero");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar el mesero. Error en el query");
        }
    }
    
    public void eliminarCliente(int idCliente){
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlCrear = "DELETE FROM Cliente WHERE IdCliente =?";
        
        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlCrear);
            pst.setInt(1, idCliente);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el cliente");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar el cliente. Error en el query");
        }
    }
    
    public void eliminarReserva(int idReserva) {
    ConexionSQLServer con = new ConexionSQLServer();
        // Consulta SQL para eliminar una reserva por su ID
        String sqlEliminar = "DELETE FROM Reserva WHERE IdReserva = ?";

        try {
            // Conectar a la base de datos
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlEliminar);

            // Asignar el ID de la reserva al parámetro
            pst.setInt(1, idReserva);

            // Ejecutar la consulta
            int filasAfectadas = pst.executeUpdate();

            // Verificar si se eliminó algún registro
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "La reserva con ID " + idReserva + " ha sido eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una reserva con el ID proporcionado.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar la reserva. Verifique la conexión a la base de datos.");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta para eliminar la reserva.");
        }
    }

    
    public void eliminarMesero(int idMesero){
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlCrear = "DELETE FROM Mesero WHERE IdMesero =?";
        
        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlCrear);
            pst.setInt(1, idMesero);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El mesero ha sido eliminado");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar al mesero");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar al mesero. Error en el query");
        }
    }
    
    public void modificarCliente(int idCliente, String nombre, String primerApe, String segundoApe, String telefono) {
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlModificar = "UPDATE Cliente SET Nombre = ?, PrimerApellido = ?, SegundoApellido = ?, Telefono = ? WHERE IdCliente = ?";

        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlModificar);
            pst.setString(1, nombre);
            pst.setString(2, primerApe);
            pst.setString(3, segundoApe);
            pst.setString(4, telefono);
            pst.setInt(5, idCliente); // Vinculamos el ID del cliente a modificar

            int filasAfectadas = pst.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El cliente ha sido modificado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un cliente con el ID especificado");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al modificar el cliente");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al modificar el cliente. Verifica el query.");
        }
    }
    
    public void modificarMesero(int idMesero, String nombre, String primerApe, String segundoApe, String turno) {
        ConexionSQLServer con = new ConexionSQLServer();
        String sqlModificar = "UPDATE Mesero SET Nombre = ?, PrimerApellido = ?, SegundoApellido = ?, Turno = ? WHERE IdMesero = ?";

        try {
            Connection cn = con.Conectar();
            PreparedStatement pst = cn.prepareStatement(sqlModificar);
            pst.setString(1, nombre);
            pst.setString(2, primerApe);
            pst.setString(3, segundoApe);
            pst.setString(4, turno);
            pst.setInt(5, idMesero); // Vinculamos el ID del mesero a modificar

            int filasAfectadas = pst.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El mesero ha sido modificado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un mesero con el ID especificado");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al modificar el mesero");
        } catch (SQLException ex) {
            Logger.getLogger(SistemaReserva.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al modificar el mesero. Verifica el query.");
        }
    }


}

