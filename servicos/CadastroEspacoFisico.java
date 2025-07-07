package servicos;

import java.util.List;
import entidades.espacosfisicos.EspacoFisico;
import excecoes.CampoInvalidoException;

/**
 * Serviço responsável por gerenciar o cadastro de novos espaços físicos no sistema.
 */
public class CadastroEspacoFisico {

    private List<EspacoFisico> espacos;

    /**
     * Construtor do serviço de cadastro de espaços.
     *
     * @param espacos A lista principal de espaços físicos do sistema.
     */
    public CadastroEspacoFisico(List<EspacoFisico> espacos) 
    {
        this.espacos = espacos;
    }

    /**
     * Tenta cadastrar um novo espaço físico após validação.
     *
     * @param espaco O objeto EspacoFisico a ser cadastrado.
     * @throws CampoInvalidoException se algum campo obrigatório for inválido.
     */
    public void cadastrarEspaco(EspacoFisico espaco) throws CampoInvalidoException 
    {
        validarEspaco(espaco);
        espacos.add(espaco);
    }

    /**
     * Método de validação privado para os atributos de um EspacoFisico.
     *
     * @param espaco O espaço a ser validado.
     * @throws CampoInvalidoException se o nome for vazio ou a capacidade for inválida.
     */
    private void validarEspaco(EspacoFisico espaco) throws CampoInvalidoException 
    {
        if (espaco.getNome() == null || espaco.getNome().trim().isEmpty()) {
            throw new CampoInvalidoException("Nome do espaço não pode ser vazio");
        }

        if (espaco.getCapacidade() <= 0) {
            throw new CampoInvalidoException("Capacidade deve ser maior que zero");
        }
    }

    /**
     * Retorna a lista de todos os espaços físicos cadastrados.
     *
     * @return A lista de espaços.
     */
    public List<EspacoFisico> getEspacos() 
    {
        return espacos;
    }
}