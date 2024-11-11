/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservarestaurantes;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Mesero;
import config.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        System.out.println("holooooooooooooo");
        ConexionSQLServer con = new ConexionSQLServer();
        
        // Generamos la consulta SQL con la concatenación de las columnas y el valor de búsqueda
        String sqlQuery = "SELECT * FROM Cliente " +
                      "WHERE CONCAT(IdCliente, ' ', Nombre, ' ', PrimerApellido, ' ', SegundoApellido, ' ', TipoCliente, ' ', telefono) " +
                      "LIKE '%" + valor + "%'";


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
        System.out.println("Y");
        return clientes;
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
}

