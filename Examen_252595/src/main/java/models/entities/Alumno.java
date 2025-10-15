/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

/**
 *
 * @author Alberto Jimenez
 */
public class Alumno {

    private final String id;
    private final String nombreCompleto;
    private final String carrera;
    private final int semestre;
    private final Inscripcion inscripcion;

    public Alumno(String id, String nombreCompleto, String carrera, int semestre, Inscripcion inscripcion) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.semestre = semestre;
        this.inscripcion = inscripcion;
    }

    public String getDatosInscripcion() {
        if (inscripcion == null) {
            return "El alumno no tiene una inscripcion activa.";
        }
        return String.format(
                "DATOS DE CONFIRMACION:\n\n"
                + "ID: %s\n"
                + "Nombre: %s\n"
                + "Carrera: %s\n"
                + "Semestre: %d\n"
                + "Materias Inscritas: %d",
                id, nombreCompleto, carrera, semestre, inscripcion.getCantidadMaterias()
        );
    }

    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }
}
