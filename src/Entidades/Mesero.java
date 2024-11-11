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
public class Mesero {
    private int idMesero;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String turno;

    // Constructor
    public Mesero(int idMesero, String nombre, String primerApellido, String segundoApellido, String turno) {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.turno = turno;
    }

    // Getters y Setters
    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // Sobrescribir el método toString para mostrar los datos de forma legible
    @Override
    public String toString() {
        return nombre + " " + primerApellido + " " + segundoApellido + " - " + turno;
    }
}
