package entidades.espacosfisicos;

import java.util.List;

/**
 * Representa um Auditório, um tipo específico de Espaço Físico.
 * Herda todos os atributos e métodos base de EspacoFisico.
 */
public class Auditorio extends EspacoFisico {

    /**
     * Construtor para criar uma instância de Auditorio.
     *
     * @param nome O nome identificador do auditório.
     * @param capacidade A capacidade máxima de pessoas do auditório.
     * @param localizacao A localização física do auditório.
     * @param equipamentos Uma lista de equipamentos disponíveis no auditório.
     */
    public Auditorio(String nome, int capacidade, String localizacao, List<String> equipamentos) 
    {
        super(nome, capacidade, localizacao, equipamentos);
    }
    
    /**
     * Retorna o tipo específico deste espaço.
     * Sobrescreve o método abstrato da classe pai.
     *
     * @return A String "Auditório".
     */
    @Override
    public String getTipoEspaco() 
    { 
        return "Auditório"; 
    }
}