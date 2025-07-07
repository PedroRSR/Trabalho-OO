package excecoes;

/**
 * Exceção genérica lançada quando um campo de um formulário ou entidade
 * falha em uma validação básica (ex: não pode ser nulo ou vazio).
 * Serve como base para exceções de validação de campo mais específicas.
 */
public class CampoInvalidoException extends Exception
{
    /**
     * Construtor da exceção.
     * * @param mensagem A mensagem de erro que descreve qual campo é inválido e por quê.
     */
    public CampoInvalidoException(String mensagem)
    {
        super(mensagem);
    }    
}