package app_paciente.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app_paciente.view.CalendarView;

public class CalendarController {
    private CalendarView view;

    public CalendarController(CalendarView view) {
        this.view = view;

        view.getBtnSolicitar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para solicitar una cita
            }
        });
    }
}