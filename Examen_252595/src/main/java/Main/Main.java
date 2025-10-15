/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controllers.ConstanciaController;
import models.AppModel;
import Views.PantallaGenerarConstancia;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alberto Jimenez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppModel model = new AppModel();
            PantallaGenerarConstancia view = new PantallaGenerarConstancia(model);
            model.addObserver(view);
            new ConstanciaController(view, model);
            view.setVisible(true);
        });
    }
}
