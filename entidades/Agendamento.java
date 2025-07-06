package entidades;

import java.time.LocalDateTime;

import entidades.espacosfisicos.EspacoFisico;
import entidades.usuarios.Usuario;

public class Agendamento {
    private Usuario usuario;
    private EspacoFisico espaco;
    private LocalDateTime dataInicio,
                          dataFim;

    public Agendamento(Usuario usuario, EspacoFisico espaco, LocalDateTime dataInicio, LocalDateTime dataFim) 
    {
        this.usuario = usuario;
        this.espaco = espaco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Usuario getUsuario() 
    {
        return usuario; 
    }

    public EspacoFisico getEspaco() 
    { 
        return espaco; 
    }

    public LocalDateTime getDataInicio() 
    { 
        return dataInicio; 
    }

    public LocalDateTime getDataFim() 
    { 
        return dataFim; 
    }
}