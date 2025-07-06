package entidades.espacos;

import java.util.List;

public class Laboratorio extends EspacoFisico {

    Laboratorio(int idEspaco, int capacidade, String localizacao, List<String> equipamentos) {
        super(idEspaco, capacidade, localizacao, equipamentos);
    }
    
    @Override
    public String getTipoEspaco() {
        return "Laboratório";
    }
}