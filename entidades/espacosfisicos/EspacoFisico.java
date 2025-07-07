package entidades.espacosfisicos;

import java.util.List;

/**
 * Representa uma entidade abstrata para qualquer espaço físico que pode ser agendado no sistema.
 * Esta classe serve como base para tipos de espaços mais específicos como salas, laboratórios e auditórios.
 */
public abstract class EspacoFisico {
    protected String nome;
    protected int capacidade;
    protected String localizacao;
    protected List<String> equipamentos;

    /**
     * Construtor para a classe abstrata EspacoFisico.
     *
     * @param nome O nome identificador do espaço (ex: "Laboratório de Redes").
     * @param capacidade A quantidade máxima de pessoas que o espaço comporta.
     * @param localizacao A localização física do espaço (ex: "Bloco A, Sala 101").
     * @param equipamentos Uma lista de nomes dos equipamentos disponíveis no espaço.
     */
    public EspacoFisico(String nome, int capacidade, String localizacao, List<String> equipamentos) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.equipamentos = equipamentos;
    }

    /**
     * Retorna o nome do espaço físico.
     *
     * @return O nome do espaço.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a capacidade máxima de pessoas do espaço.
     *
     * @return A capacidade do espaço.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Retorna a localização física do espaço.
     *
     * @return A localização do espaço.
     */
    public String getLocalizacao() {
        return localizacao;
    }
    
    /**
     * Retorna a lista de equipamentos disponíveis no espaço.
     *
     * @return Uma lista de Strings contendo os nomes dos equipamentos.
     */
    public List<String> getEquipamentos() {
        return equipamentos;
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses para retornar
     * o nome específico do tipo de espaço (ex: "Laboratório", "Auditório").
     *
     * @return Uma String representando o tipo do espaço.
     */
    public abstract String getTipoEspaco();
}