/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dtos.AlumnoDTO;
import models.entities.Alumno;

/**
 *
 * @author Alberto Jimenez
 */
public class AlumnoMapper {

    public static AlumnoDTO toDTO(Alumno alumno) {
        return new AlumnoDTO(alumno.getId(), alumno.getNombreCompleto());
    }
}
