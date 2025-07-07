package servicos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entidades.Agendamento;
import entidades.usuarios.Usuario;
import entidades.espacosfisicos.EspacoFisico;

/**
 * Serviço responsável por consultar e filtrar a lista de agendamentos
 * para gerar relatórios específicos.
 */
public class GeradorRelatorios {

    private List<Agendamento> agendamentos;

    /**
     * Construtor do gerador de relatórios.
     *
     * @param agendamentos A lista principal de agendamentos da qual os relatórios serão gerados.
     */
    public GeradorRelatorios(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    /**
     * Filtra e retorna todos os agendamentos feitos por um usuário específico.
     *
     * @param usuario O usuário para o qual o relatório será gerado.
     * @return Uma nova lista contendo apenas os agendamentos do usuário especificado.
     */
    public List<Agendamento> relatorioPorUsuario(Usuario usuario) {
        List<Agendamento> resultado = new ArrayList<>();
        for (Agendamento ag : agendamentos) {
            if (ag.getUsuario().equals(usuario)) {
                resultado.add(ag);
            }
        }
        return resultado;
    }

    /**
     * Filtra e retorna todos os agendamentos de um espaço físico dentro de um determinado período de tempo.
     *
     * @param espaco O espaço físico a ser consultado.
     * @param inicio A data e hora de início do período de consulta.
     * @param fim A data e hora de fim do período de consulta.
     * @return Uma nova lista contendo os agendamentos que se sobrepõem ao período especificado.
     */
    public List<Agendamento> relatorioPorEspaco(EspacoFisico espaco, LocalDateTime inicio, LocalDateTime fim) {
        List<Agendamento> resultado = new ArrayList<>();
        for (Agendamento ag : agendamentos) {
            if (ag.getEspaco().equals(espaco)
                    && !ag.getDataFim().isBefore(inicio)
                    && !ag.getDataInicio().isAfter(fim)) {
                resultado.add(ag);
            }
        }
        return resultado;
    }
}