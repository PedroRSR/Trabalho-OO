package excecoes;

/**
 * Exceção específica lançada quando o formato de um email é considerado inválido
 * durante uma validação. Herda de {@link CampoInvalidoException}.
 */
public class EmailInvalidoException extends CampoInvalidoException
{
    /**
     * Construtor da exceção.
     * * @param mensagem A mensagem de erro detalhando o problema com o formato do email.
     */
    public EmailInvalidoException(String mensagem) 
    {
        super(mensagem);
    }
}