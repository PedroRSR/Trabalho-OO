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

public class GerenciadorAgendamento {

    private List<Agendamento> agendamentos;

    public GerenciadorAgendamento() {
        this.agendamentos = new ArrayList<>();
    }

    public void agendar(Usuario usuario, EspacoFisico espaco, LocalDateTime dataInicio, LocalDateTime dataFim)
            throws HorarioIndisponivelException, DiasExcedidosException {

        if (usuario instanceof entidades.usuarios.Aluno) {
            Duration duracao = Duration.between(dataInicio, dataFim);

            if (duracao.toHours() > 24) {
                throw new DiasExcedidosException("Alunos podem reservar um espaço por no máximo 24 horas.");
            }
        }

        // verifica conflito de horário
        for (Agendamento ag : agendamentos) {
            if (ag.getEspaco().equals(espaco)) 
            {
                if (!(dataFim.isBefore(ag.getDataInicio()) || dataInicio.isAfter(ag.getDataFim()))) {
                    throw new HorarioIndisponivelException("O espaço já está reservado neste período");
                }
            }
        }

        // se passou nas validações, cria o agendamento
        Agendamento novoAgendamento = new Agendamento(usuario, espaco, dataInicio, dataFim);
        agendamentos.add(novoAgendamento);
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }
}
