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
public class Inscripcion {

    private final List<Materia> materias;

    public Inscripcion(List<Materia> materias) {
        this.materias = materias;
    }

    public int getCantidadMaterias() {
        return materias != null ? materias.size() : 0;
    }

    public List<Materia> getMaterias() {
        return materias;
    }
}
