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
public class Mesa {
    private int idMesa;
    private int capacidadPersonas;
    private String descripcionZona;

    // Constructor
    public Mesa(int idMesa, int capacidadPersonas, String descripcionZona) {
        this.idMesa = idMesa;
        this.capacidadPersonas = capacidadPersonas;
        this.descripcionZona = descripcionZona;
    }

    // Getters y Setters
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public String getDescripcionZona() {
        return descripcionZona;
    }

    public void setDescripcionZona(String descripcionZona) {
        this.descripcionZona = descripcionZona;
    }

    // Sobrescribir el método toString para mostrar los datos de forma legible
    @Override
    public String toString() {
        return "Número: " + idMesa +
                ", Capacidad de personas = " + capacidadPersonas +
                ", Zona = " + descripcionZona;
    }
}

