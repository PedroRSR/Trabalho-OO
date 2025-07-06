package entidades.espacosfisicos;

import java.util.List;

public class Laboratorio extends EspacoFisico {
    public Laboratorio(String nome, int capacidade, String localizacao, List<String> equipamentos) {
        super(nome, capacidade, localizacao, equipamentos);
    }

    @Override
    public String getTipoEspaco() 
    { 
        return "Laboratório"; 
    }
}