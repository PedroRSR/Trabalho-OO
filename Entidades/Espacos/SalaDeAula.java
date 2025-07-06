package entidades.espacos;

import java.util.List;

public class SalaDeAula extends EspacoFisico {

    SalaDeAula(int idEspaco, int capacidade, String localizacao, List<String> equipamentos) {
        super(idEspaco, capacidade, localizacao, equipamentos);
    }

    @Override
    public String getTipoEspaco() {
        return "Sala de Aula";
    }
}