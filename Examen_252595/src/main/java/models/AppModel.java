/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dtos.AlumnoDTO;
import models.entities.Alumno;
import models.entities.Constancia;
import patterns.observer.IObserver;
import patterns.observer.ISubject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mappers.AlumnoMapper;

/**
 *
 * @author Alberto Jimenez
 */
public class AppModel implements ISubject {

    public enum UpdateType {
        LISTA_ALUMNOS_CAMBIO, DETALLES_CAMBIO
    }

    private final List<IObserver> observers;
    private final RepositorioAlumnos repositorio;
    private final Constancia generadorConstancia;

    private List<AlumnoDTO> alumnosEncontrados;
    private AlumnoDTO alumnoSeleccionado;
    private String textoMostrado;

    public AppModel() {
        this.observers = new ArrayList<>();
        this.repositorio = new RepositorioAlumnos();
        this.generadorConstancia = new Constancia();
        this.alumnosEncontrados = new ArrayList<>();
        this.textoMostrado = "Sistema listo. Ingrese un ID para buscar.";
    }

    public void buscarAlumnos(String idParcial) {
        List<Alumno> entidades = repositorio.buscarPorIdParcial(idParcial);
        this.alumnosEncontrados = entidades.stream()
                .map(AlumnoMapper::toDTO)
                .collect(Collectors.toList());

        this.alumnoSeleccionado = null;
        this.textoMostrado = alumnosEncontrados.isEmpty() ? "No se encontraron resultados." : "Seleccione un alumno de la lista.";
        notifyObservers(UpdateType.LISTA_ALUMNOS_CAMBIO);
    }

    public void seleccionarAlumno(AlumnoDTO dto) {
        this.alumnoSeleccionado = dto;
        if (this.alumnoSeleccionado != null) {
            Alumno entidad = repositorio.buscarPorIdExacto(dto.getId());
            this.textoMostrado = entidad.getDatosInscripcion();
        } else {
            this.textoMostrado = "Selección cancelada.";
        }
        notifyObservers(UpdateType.DETALLES_CAMBIO);
    }

    public void generarConstancia() {
        if (alumnoSeleccionado == null) {
            this.textoMostrado = "Por favor, seleccione un alumno primero.";
        } else {
            Alumno entidad = repositorio.buscarPorIdExacto(alumnoSeleccionado.getId());
            this.textoMostrado = generadorConstancia.generarConstancia(entidad);
        }
        notifyObservers(UpdateType.DETALLES_CAMBIO);
    }

    public List<AlumnoDTO> getAlumnosEncontradosDTO() {
        return alumnosEncontrados;
    }

    public AlumnoDTO getAlumnoSeleccionadoDTO() {
        return alumnoSeleccionado;
    }

    public String getTextoMostrado() {
        return textoMostrado;
    }

    @Override
    public void addObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object info) {
        for (IObserver o : observers) {
            o.update(info);
        }
    }
}
