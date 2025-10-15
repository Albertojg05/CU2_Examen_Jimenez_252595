/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

/**
 *
 * @author Alberto Jimenez
 */
public class Materia {

    private final String nombre;
    private final String maestro;
    private final String aula;

    public Materia(String nombre, String maestro, String aula) {
        this.nombre = nombre;
        this.maestro = maestro;
        this.aula = aula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMaestro() {
        return maestro;
    }

    public String getAula() {
        return aula;
    }
}
