package Entidades.Espacos;

import Entidades.Reservas.Reserva;

public class EspacoFisico {
    private int idEspaco,
                capacidade;
    private String localizacao;
    private Equipamento[] equipamentos;
    private Reserva[] reservas;

    public EspacoFisico(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Reserva[] reservas) {
        this.idEspaco = idEspaco;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.equipamentos = equipamentos;
        this.reservas = reservas;
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

    public Reserva[] getReservas() {
        return reservas;
    }

    public boolean estaDisponivel() {
        // Implementar lógica para verificar disponibilidade
        return true; // Placeholder, deve ser substituído pela lógica real
    }

}