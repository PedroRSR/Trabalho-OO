package Entidades.espacos;

import java.util.List;

public class Auditorio extends EspacoFisico {

    Auditorio(int idEspaco, int capacidade, String localizacao, List<String> equipamentos) {
        super(idEspaco, capacidade, localizacao, equipamentos);
    }
    
    @Override
    public String getTipoEspaco() { return "Auditório"; }
}