package excecoes;

/**
 * Exceção de regra de negócio lançada ao tentar realizar um agendamento
 * para um espaço físico em um período de tempo que já está ocupado por outra reserva.
 */
public class HorarioIndisponivelException extends Exception 
{
    /**
     * Construtor da exceção.
     * * @param mensagem A mensagem de erro que informa sobre o conflito de horário.
     */
    public HorarioIndisponivelException(String mensagem) 
    {
        super(mensagem);
    }
}