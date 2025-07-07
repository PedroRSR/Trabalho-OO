package excecoes;

/**
 * Exceção de regra de negócio lançada quando uma operação excede o número
 * máximo de dias permitido. No contexto deste projeto, é usada quando um aluno
 * tenta agendar um espaço por um período maior que o limite.
 */
public class DiasExcedidosException extends Exception 
{
    /**
     * Construtor da exceção.
     * * @param mensagem A mensagem de erro que descreve a regra de dias que foi violada.
     */
    public DiasExcedidosException(String mensagem) 
    {
        super(mensagem);
    }
}