package Entidades.espacos;

import java.util.List;

public abstract class EspacoFisico {
    protected int idEspaco;
    protected int capacidade;
    protected String localizacao;
    protected List<String> equipamentos;

    public EspacoFisico(int idEspaco, int capacidade, String localizacao, List<String> equipamentos) {
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
    
    public List<String> getEquipamentos() {
        return equipamentos;
    }

    public abstract String getTipoEspaco();
}