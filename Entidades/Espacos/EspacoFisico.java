package Entidades.Espacos;

public class EspacoFisico {
    private int idEspaco,
                capacidade;
    private String localizacao;
    private Equipamento []equipamentos;

    public EspacoFisico(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos) {
        this.idEspaco = idEspaco;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.equipamentos = equipamentos;
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

    public boolean estaDisponivel() {
        // Implementar lógica para verificar disponibilidade
        return true; // Placeholder, deve ser substituído pela lógica real
    }

}