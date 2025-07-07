package entidades;

import java.time.LocalDateTime;

import entidades.espacosfisicos.EspacoFisico;
import entidades.usuarios.Usuario;

/**
 * Representa a entidade central do sistema, um agendamento.
 * Esta classe vincula um {@link Usuario} a um {@link EspacoFisico} 
 * durante um período de tempo específico.
 */
public class Agendamento {
    private Usuario usuario;
    private EspacoFisico espaco;
    private LocalDateTime dataInicio,
                          dataFim;

    /**
     * Construtor para criar uma nova instância de Agendamento.
     *
     * @param usuario O usuário que está realizando o agendamento.
     * @param espaco O espaço físico que está sendo agendado.
     * @param dataInicio A data e hora exatas de início do agendamento.
     * @param dataFim A data e hora exatas de término do agendamento.
     */
    public Agendamento(Usuario usuario, EspacoFisico espaco, LocalDateTime dataInicio, LocalDateTime dataFim) 
    {
        this.usuario = usuario;
        this.espaco = espaco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    /**
     * Retorna o usuário associado a este agendamento.
     *
     * @return O objeto Usuario que fez a reserva.
     */
    public Usuario getUsuario() 
    {
        return usuario; 
    }

    /**
     * Retorna o espaço físico que foi agendado.
     *
     * @return O objeto EspacoFisico reservado.
     */
    public EspacoFisico getEspaco() 
    { 
        return espaco; 
    }

    /**
     * Retorna a data e hora de início do agendamento.
     *
     * @return Um objeto LocalDateTime representando o início da reserva.
     */
    public LocalDateTime getDataInicio() 
    { 
        return dataInicio; 
    }

    /**
     * Retorna a data e hora de fim do agendamento.
     *
     * @return Um objeto LocalDateTime representando o fim da reserva.
     */
    public LocalDateTime getDataFim() 
    { 
        return dataFim; 
    }
}