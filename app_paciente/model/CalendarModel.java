package app_paciente.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarModel {
    private Map<String, String> citasConfirmadas;
    private ArrayList<String> citasSolicitadas;

    public CalendarModel() {
        this.citasConfirmadas = new HashMap<>();
        this.citasSolicitadas = new ArrayList<>();
        llenarEjemploCitas();
    }

    public Map<String, String> getCitasConfirmadas() {
        return citasConfirmadas;
    }

    public ArrayList<String> getCitasSolicitadas() {
        return citasSolicitadas;
    }

    private void llenarEjemploCitas() {
        citasConfirmadas.put("1,1", "Consulta con Dr. Pérez a las 10:00 AM");
        citasConfirmadas.put("2,2", "Consulta con Dra. Gómez a las 12:00 PM");
        citasConfirmadas.put("3,3", "Chequeo general 3:00 PM");
    }

    public String[][] generarCalendario() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = cal.get(GregorianCalendar.DAY_OF_WEEK) - 2;
        if (firstDayOfWeek < 0) {
            firstDayOfWeek += 7;
        }

        int daysInMonth = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        String[][] calendario = new String[6][7];
        int day = 1;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < firstDayOfWeek) {
                    calendario[i][j] = "";
                } else if (day > daysInMonth) {
                    calendario[i][j] = "";
                } else {
                    calendario[i][j] = String.valueOf(day);
                    day++;
                }
            }
        }

        return calendario;
    }
}