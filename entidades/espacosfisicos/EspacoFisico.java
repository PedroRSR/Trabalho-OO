package entidades.espacosfisicos;

import java.util.List;

public abstract class EspacoFisico {
    protected String nome;
    protected int capacidade;
    protected String localizacao;
    protected List<String> equipamentos;

    public EspacoFisico(String nome, int capacidade, String localizacao, List<String> equipamentos) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.equipamentos = equipamentos;
    }

    public String getNome() {
        return nome;
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