/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import models.AppModel;
import Views.PantallaGenerarConstancia;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Alberto Jimenez
 */
public class ConstanciaController {

    public ConstanciaController(PantallaGenerarConstancia view, AppModel model) {

        view.addIdTecleadoListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                model.buscarAlumnos(view.getIdTecleado());
            }
        });

        view.addSeleccionAlumnoListener(e -> {
            if (!e.getValueIsAdjusting()) {
                model.seleccionarAlumno(view.getAlumnoSeleccionado());
            }
        });

        view.addGenerarConstanciaListener(e -> model.generarConstancia());
    }
}
