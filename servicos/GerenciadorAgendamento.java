package servicos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration; 
import entidades.Agendamento;
import entidades.espacosfisicos.EspacoFisico;
import entidades.usuarios.Usuario;
import excecoes.DiasExcedidosException;
import excecoes.HorarioIndisponivelException;

/**
 * Serviço de orquestração responsável por aplicar as regras de negócio
 * e efetivar a criação de um novo agendamento.
 */
public class GerenciadorAgendamento {

    private List<Agendamento> agendamentos;

    /**
     * Construtor do gerenciador. Inicializa uma nova lista para armazenar os agendamentos.
     */
    public GerenciadorAgendamento() {
        this.agendamentos = new ArrayList<>();
    }

    /**
     * Orquestra a criação de um novo agendamento, validando as regras de negócio.
     *
     * @param usuario O usuário que está fazendo a reserva.
     * @param espaco O espaço físico a ser reservado.
     * @param dataInicio A data e hora de início da reserva.
     * @param dataFim A data e hora de fim da reserva.
     * @throws HorarioIndisponivelException Se o espaço já estiver ocupado no período solicitado.
     * @throws DiasExcedidosException Se um aluno tentar reservar por mais de 24 horas.
     */
    public void agendar(Usuario usuario, EspacoFisico espaco, LocalDateTime dataInicio, LocalDateTime dataFim)
            throws HorarioIndisponivelException, DiasExcedidosException {

        if (usuario instanceof entidades.usuarios.Aluno) {
            Duration duracao = Duration.between(dataInicio, dataFim);

            if (duracao.toHours() > 24) {
                throw new DiasExcedidosException("Alunos podem reservar um espaço por no máximo 24 horas.");
            }
        }

        for (Agendamento ag : agendamentos) {
            if (ag.getEspaco().equals(espaco)) 
            {
                if (!(dataFim.isBefore(ag.getDataInicio()) || dataInicio.isAfter(ag.getDataFim()))) {
                    throw new HorarioIndisponivelException("O espaço já está reservado neste período");
                }
            }
        }
        
        Agendamento novoAgendamento = new Agendamento(usuario, espaco, dataInicio, dataFim);
        agendamentos.add(novoAgendamento);
    }

    /**
     * Retorna a lista de todos os agendamentos realizados.
     *
     * @return A lista de agendamentos.
     */
    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }
}