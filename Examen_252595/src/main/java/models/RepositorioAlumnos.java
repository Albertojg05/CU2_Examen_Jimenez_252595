/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import models.entities.Materia;
import models.entities.Inscripcion;
import models.entities.Alumno;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Alberto Jimenez
 */
public class RepositorioAlumnos {

    private final List<Alumno> alumnos;

    public RepositorioAlumnos() {
        this.alumnos = new ArrayList<>();

        Materia m1 = new Materia("Álgebra Lineal", "Dr. Newton", "AV1311");
        Materia m2 = new Materia("Programación III", "Dra. Lovelace", "LV1824");
        Materia m3 = new Materia("Bases de Datos", "Ing. Codd", "LV1821");
        Materia m4 = new Materia("Métodos Numéricos", "Arq. Candela", "LV1823");

        Inscripcion inscripcionISW = new Inscripcion(Arrays.asList(m1, m2, m3));
        Inscripcion inscripcionIC = new Inscripcion(List.of(m4));

        alumnos.add(new Alumno("252241", "Ana Sofía García López", "Ing. en Software", 3, inscripcionISW));
        alumnos.add(new Alumno("251235", "Carlos Alberto Ruiz Sánchez", "Ing. en Software", 3, inscripcionISW));
        alumnos.add(new Alumno("252534", "Mariana Torres Herrera", "Ing. Civil", 5, inscripcionIC));
        alumnos.add(new Alumno("254215", "Javier Mendoza Cruz", "Ing. en Software", 1, null));
    }

    public List<Alumno> buscarPorIdParcial(String idParcial) {
        if (idParcial == null || idParcial.isBlank()) {
            return new ArrayList<>();
        }
        return alumnos.stream()
                .filter(a -> a.getId().startsWith(idParcial))
                .collect(Collectors.toList());
    }

    public Alumno buscarPorIdExacto(String id) {
        return alumnos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
