package Entidades.Espacos;

import Entidades.Reservas.Reserva;

public class Laboratorio extends EspacoFisico {

    Laboratorio(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Reserva[] reservas) {
        super(idEspaco, capacidade, localizacao, equipamentos, reservas);
    }
    
}