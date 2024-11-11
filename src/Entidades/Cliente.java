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
public class Cliente {
    private int idCliente;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String tipoCliente;
    private String telefono;

    // Constructor vacío (si es necesario)
    public Cliente() {}

    // Constructor con todos los parámetros
    public Cliente(int idCliente, String nombre, String primerApellido, String segundoApellido, String tipoCliente, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tipoCliente = tipoCliente;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString() para mostrar el nombre completo en el JComboBox
    @Override
    public String toString() {
        return nombre + " " + primerApellido + " " + segundoApellido;
    }
}


