package app_paciente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app_paciente.model.Configuracion;
import app_paciente.view.ConfiguracionesView;

public class ConfiguracionesController {
    private ConfiguracionesView view;
    private Configuracion model;

    public ConfiguracionesController(ConfiguracionesView view, Configuracion model) {
        this.view = view;
        this.model = model;

        view.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setCorreo(view.getCorreo());
                model.setTelefono(view.getTelefono());
                model.setDireccion(view.getDireccion());
                model.setContraseña(view.getContraseña());
            }
        });
    }
}