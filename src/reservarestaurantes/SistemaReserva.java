/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservarestaurantes;

import config.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
}

