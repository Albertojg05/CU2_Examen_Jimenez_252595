/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

import java.util.List;

/**
 *
 * @author Alberto Jimenez
 */
public class Constancia {

    public String generarConstancia(Alumno alumno) {
        if (alumno.getInscripcion() == null || alumno.getInscripcion().getCantidadMaterias() == 0) {
            return "No se puede generar la constancia. El alumno no está inscrito en ninguna materia.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("--- CONSTANCIA DE INSCRIPCIÓN ---\n\n");
        sb.append("DATOS DEL ALUMNO:\n");
        sb.append(String.format("  ID:     %s\n", alumno.getId()));
        sb.append(String.format("  Nombre: %s\n", alumno.getNombreCompleto()));
        sb.append(String.format("  Carrera: %s\n", alumno.getCarrera()));
        sb.append(String.format("  Semestre: %d\n\n", alumno.getSemestre()));
        sb.append("MATERIAS INSCRITAS:\n");

        List<Materia> materiasInscritas = alumno.getInscripcion().getMaterias();
        for (Materia materia : materiasInscritas) {
            sb.append(String.format("  - Materia: %s (Aula: %s)\n", materia.getNombre(), materia.getAula()));
        }
        return sb.toString();
    }
}
