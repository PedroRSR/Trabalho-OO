package Entidades.Reservas;

import java.time.LocalDateTime;

public class DataHora {
    private LocalDateTime dataHora;

    public DataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}