/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author ThinkPad
 */
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Reserva {
    private int idReserva;
    private Date fechaHoraReserva;
    private String estado;
    private String turno;
    private String preferencia;
    private String nombreCompletoMesero;
    private String nombreCompletoCliente;
    private int idMesa;

    // Constructor vacío
    public Reserva() {
    }

    // Constructor completo
    public Reserva(int idReserva, Date fechaHoraReserva, String estado, String turno, 
                   String preferencia, String nombreCompletoMesero, String nombreCompletoCliente, int idMesa) {
        this.idReserva = idReserva;
        this.fechaHoraReserva = fechaHoraReserva;
        this.estado = estado;
        this.turno = turno;
        this.preferencia = preferencia;
        this.nombreCompletoMesero = nombreCompletoMesero;
        this.nombreCompletoCliente = nombreCompletoCliente;
        this.idMesa = idMesa;
    }

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Date fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public String getNombreCompletoMesero() {
        return nombreCompletoMesero;
    }

    public void setNombreCompletoMesero(String nombreCompletoMesero) {
        this.nombreCompletoMesero = nombreCompletoMesero;
    }

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCOmpletoCliente) {
        this.nombreCompletoCliente = nombreCOmpletoCliente;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
    
    public String getFecha()
    {
        // Formatear para extraer solo la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formatoFecha.format(fechaHoraReserva);
        
        return fecha;
    }
    
    public String getHora(){
        // Formatear para extraer solo la hora
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String hora = formatoHora.format(fechaHoraReserva);
        
        return hora;
    }
    
    // Método toString (opcional)
    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", fechaHoraReserva=" + fechaHoraReserva +
                ", estado='" + estado + '\'' +
                ", turno='" + turno + '\'' +
                ", preferencia='" + preferencia + '\'' +
                ", idMesero=" + nombreCompletoMesero +
                ", idCliente=" + nombreCompletoCliente +
                ", idMesa=" + idMesa +
                '}';
    }
}

