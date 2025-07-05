package Entidades.Reservas;

import Entidades.Pessoas.Usuario;

public class Reserva {
    private int idReserva;
    private DataHora Inicio;
    private DataHora Fim;
    private String status;
    private Usuario solicitante;

    public Reserva(int idReserva, DataHora inicio, DataHora fim, String status, Usuario solicitante) {
        this.idReserva = idReserva;
        this.Inicio = inicio;
        this.Fim = fim;
        this.status = status;
        this.solicitante = solicitante;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public DataHora getInicio() {
        return Inicio;
    }

    public DataHora getFim() {
        return Fim;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }
}