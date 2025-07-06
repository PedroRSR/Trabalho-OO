package servicos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entidades.Agendamento;
import entidades.usuarios.Usuario;
import entidades.espacosfisicos.EspacoFisico;

public class GeradorRelatorios {

    private List<Agendamento> agendamentos;

    public GeradorRelatorios(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<Agendamento> relatorioPorUsuario(Usuario usuario) {
        List<Agendamento> resultado = new ArrayList<>();
        for (Agendamento ag : agendamentos) {
            if (ag.getUsuario().equals(usuario)) {
                resultado.add(ag);
            }
        }
        return resultado;
    }

    public List<Agendamento> relatorioPorEspaco(EspacoFisico espaco, LocalDate inicio, LocalDate fim) {
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