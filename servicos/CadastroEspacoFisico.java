package servicos;

import java.util.List;
import entidades.espacosfisicos.EspacoFisico;
import excecoes.CampoInvalidoException;

public class CadastroEspacoFisico {

    private List<EspacoFisico> espacos;

    public CadastroEspacoFisico(List<EspacoFisico> espacos) 
    {
        this.espacos = espacos;
    }

    public void cadastrarEspaco(EspacoFisico espaco) throws CampoInvalidoException 
    {
        validarEspaco(espaco);
        espacos.add(espaco);
    }

    private void validarEspaco(EspacoFisico espaco) throws CampoInvalidoException 
    {
        if (espaco.getNome() == null || espaco.getNome().isEmpty()) 
        {
            throw new CampoInvalidoException("Nome do espaço não pode ser vazio");
        }

        if (espaco.getCapacidade() <= 0) 
        {
            throw new CampoInvalidoException("Capacidade deve ser maior que zero");
        }
        // Adicione outras validações que fizer sentido
    }

    public List<EspacoFisico> getEspacos() 
    {
        return espacos;
    }
}
