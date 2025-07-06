package entidades.espacos;

import entidades.Agendamento;

public class Auditorio extends EspacoFisico {

    Auditorio(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Agendamento[] agendamentos) {
        super(idEspaco, capacidade, localizacao, equipamentos, agendamentos);
    }
    
}