package Entidades.Espacos;

import Entidades.Reservas.Reserva;

public class Auditorio extends EspacoFisico {

    Auditorio(int idEspaco, int capacidade, String localizacao, Equipamento[] equipamentos, Reserva[] reservas) {
        super(idEspaco, capacidade, localizacao, equipamentos, reservas);
    }
    
}