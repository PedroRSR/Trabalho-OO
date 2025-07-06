package entidades.espacosfisicos;

import java.util.List;

public class Auditorio extends EspacoFisico {

    public Auditorio(String nome, int capacidade, String localizacao, List<String> equipamentos) 
    {
        super(nome, capacidade, localizacao, equipamentos);
    }
    
    @Override
    public String getTipoEspaco() 
    { 
        return "Auditório"; 
    }
}