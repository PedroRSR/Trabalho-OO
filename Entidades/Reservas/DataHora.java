package Entidades.Reservas;

import java.time.LocalDate;
import java.time.LocalTime;

public class DataHora {
    private LocalDate data;
    private LocalTime hora;

    public DataHora(LocalDate data, LocalTime hora) {
        this.data = data;
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }
}
