package app_paciente.controller;

import app_paciente.model.Recomendacion;
import app_paciente.view.RecomendacionesView;

public class RecomendacionesController {
    private RecomendacionesView view;
    private Recomendacion[] recomendaciones;

    public RecomendacionesController(RecomendacionesView view, Recomendacion[] recomendaciones) {
        this.view = view;
        this.recomendaciones = recomendaciones;

        for (Recomendacion recomendacion : recomendaciones) {
            view.agregarRecomendacion(recomendacion.getTitulo(), recomendacion.getDescripcion());
        }
    }
}