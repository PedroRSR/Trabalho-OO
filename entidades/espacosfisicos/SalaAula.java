package entidades.espacosfisicos;

import java.util.List;

/**
 * Representa uma Sala de Aula, um tipo específico de Espaço Físico.
 * Herda todos os atributos e métodos base de EspacoFisico.
 */
public class SalaAula extends EspacoFisico {
    
    /**
     * Construtor para criar uma instância de Sala de Aula.
     *
     * @param nome O nome identificador da sala (ex: "Sala B203").
     * @param capacidade A capacidade máxima de pessoas da sala.
     * @param localizacao A localização física da sala.
     * @param equipamentos Uma lista de equipamentos disponíveis na sala.
     */
    public SalaAula(String nome, int capacidade, String localizacao, List<String> equipamentos) 
    {
        super(nome, capacidade, localizacao, equipamentos);
    }

    /**
     * Retorna o tipo específico deste espaço.
     * Sobrescreve o método abstrato da classe pai.
     *
     * @return A String "Sala de Aula".
     */
    @Override
    public String getTipoEspaco() 
    {
        return "Sala de Aula"; 
    }
}