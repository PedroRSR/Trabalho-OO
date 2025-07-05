package Entidades.Espacos;

import Entidades.Reservas.Reserva;

public class SalaDeAula extends EspacoFisico {

    SalaDeAula(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Reserva[] reservas) {
        super(idEspaco, capacidade, localizacao, equipamentos, reservas);
    }
    
}