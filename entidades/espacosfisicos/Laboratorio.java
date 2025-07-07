package entidades.espacosfisicos;

import java.util.List;

/**
 * Representa um Laboratório, um tipo específico de Espaço Físico.
 * Herda todos os atributos e métodos base de EspacoFisico.
 */
public class Laboratorio extends EspacoFisico {
    
    /**
     * Construtor para criar uma instância de Laboratorio.
     *
     * @param nome O nome identificador do laboratório.
     * @param capacidade A capacidade máxima de pessoas do laboratório.
     * @param localizacao A localização física do laboratório.
     * @param equipamentos Uma lista de equipamentos disponíveis no laboratório.
     */
    public Laboratorio(String nome, int capacidade, String localizacao, List<String> equipamentos) {
        super(nome, capacidade, localizacao, equipamentos);
    }

    /**
     * Retorna o tipo específico deste espaço.
     * Sobrescreve o método abstrato da classe pai.
     *
     * @return A String "Laboratório".
     */
    @Override
    public String getTipoEspaco() 
    { 
        return "Laboratório"; 
    }
}