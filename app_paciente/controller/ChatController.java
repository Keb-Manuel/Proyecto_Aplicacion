package app_paciente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app_paciente.model.Chat;
import app_paciente.view.ChatView;

public class ChatController {
    private ChatView view;
    private Chat model;

    public ChatController(ChatView view, Chat model) {
        this.view = view;
        this.model = model;

        view.getBtnEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = view.getMensaje();
                model.setMensaje(mensaje);
                view.agregarMensaje(mensaje);
            }
        });
    }
}