/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import dtos.AlumnoDTO;
import models.AppModel;
import patterns.observer.IObserver;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 *
 * @author Alberto Jimenez
 */
public class PantallaGenerarConstancia extends JFrame implements IObserver {

    private final AppModel model;
    private final JTextField campoId;
    private final JList<AlumnoDTO> listaAlumnos;
    private final DefaultListModel<AlumnoDTO> listModel;
    private final JTextArea areaDatos;
    private final JButton botonGenerar;

    public PantallaGenerarConstancia(AppModel model) {
        this.model = model;
        setTitle("Generación de Constancias de Alumno");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Buscar Alumno por ID"));
        panelBusqueda.add(new JLabel("ID del Alumno:"));
        campoId = new JTextField(20);
        panelBusqueda.add(campoId);
        add(panelBusqueda, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 10, 0));
        listModel = new DefaultListModel<>();
        listaAlumnos = new JList<>(listModel);
        JScrollPane scrollLista = new JScrollPane(listaAlumnos);
        scrollLista.setBorder(BorderFactory.createTitledBorder("Alumnos Encontrados"));
        panelCentral.add(scrollLista);

        areaDatos = new JTextArea();
        areaDatos.setEditable(false);
        areaDatos.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollArea = new JScrollPane(areaDatos);
        scrollArea.setBorder(BorderFactory.createTitledBorder("Detalles y Constancia"));
        panelCentral.add(scrollArea);
        add(panelCentral, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel();
        botonGenerar = new JButton("Generar Constancia");
        panelBoton.add(botonGenerar);
        add(panelBoton, BorderLayout.SOUTH);

        update(AppModel.UpdateType.DETALLES_CAMBIO);
    }

    @Override
    public void update(Object updateInfo) {
        if (updateInfo instanceof AppModel.UpdateType) {
            AppModel.UpdateType type = (AppModel.UpdateType) updateInfo;
            if (type == AppModel.UpdateType.LISTA_ALUMNOS_CAMBIO) {
                listModel.clear();
                model.getAlumnosEncontradosDTO().forEach(listModel::addElement);
            }
        }
        areaDatos.setText(model.getTextoMostrado());
        botonGenerar.setEnabled(model.getAlumnoSeleccionadoDTO() != null);
    }

    public String getIdTecleado() {
        return campoId.getText();
    }

    public AlumnoDTO getAlumnoSeleccionado() {
        return listaAlumnos.getSelectedValue();
    }

    public void addIdTecleadoListener(KeyListener l) {
        campoId.addKeyListener(l);
    }

    public void addSeleccionAlumnoListener(ListSelectionListener l) {
        listaAlumnos.addListSelectionListener(l);
    }

    public void addGenerarConstanciaListener(ActionListener l) {
        botonGenerar.addActionListener(l);
    }
}
