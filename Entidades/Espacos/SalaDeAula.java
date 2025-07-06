package entidades.espacos;

import entidades.Agendamento;

public class SalaDeAula extends EspacoFisico {

    SalaDeAula(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Agendamento[] reservas) {
        super(idEspaco, capacidade, localizacao, equipamentos, reservas);
    }
    
}