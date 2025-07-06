package entidades.espacos;

import entidades.Agendamento;

public class Laboratorio extends EspacoFisico {

    Laboratorio(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Agendamento[] agendamentos) {
        super(idEspaco, capacidade, localizacao, equipamentos, agendamentos);
    }
    
}