package Entidades;

import java.time.LocalDate;

import Entidades.espacos.EspacoFisico;
import Entidades.pessoas.Usuario;

public class Agendamento {
    private Usuario usuario;
    private EspacoFisico espaco;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Agendamento(Usuario usuario, EspacoFisico espaco, LocalDate dataInicio, LocalDate dataFim) {
        this.usuario = usuario;
        this.espaco = espaco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Usuario getUsuario() {
        return usuario; 
    }

    public EspacoFisico getEspaco() { 
        return espaco; 
    }

    public LocalDate getDataInicio() { 
        return dataInicio; 
    }

    public LocalDate getDataFim() { 
        return dataFim; 
    }
}