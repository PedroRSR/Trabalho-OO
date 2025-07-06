package entidades.espacos;

import entidades.Agendamento;

public class EspacoFisico {
    private int idEspaco,
                capacidade;
    private String localizacao;
    private Equipamento[] equipamentos;
    private Agendamento[] agendamentos;

    public EspacoFisico(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Agendamento[] agendamentos) {
        this.idEspaco = idEspaco;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.equipamentos = equipamentos;
        this.agendamentos = agendamentos;
    }

    public int getIdEspaco() {
        return idEspaco;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    
    public Equipamento[] getEquipamentos() {
        return equipamentos;
    }

    public Agendamento[] getAgendamentos() {
        return agendamentos;
    }

    public boolean estaDisponivel() {
        // Implementar lógica para verificar disponibilidade
        return true; // Placeholder, deve ser substituído pela lógica real
    }

}