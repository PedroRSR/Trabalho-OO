package entidades.espacosfisicos;

import java.util.List;

public class SalaAula extends EspacoFisico {
    public SalaAula(String nome, int capacidade, String localizacao, List<String> equipamentos) 
    {
        super(nome, capacidade, localizacao, equipamentos);
    }

    @Override
    public String getTipoEspaco() 
    {
        return "Sala de Aula"; 
    }
}
