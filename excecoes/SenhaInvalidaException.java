package excecoes;

/**
 * Exceção específica lançada quando uma senha não atende aos critérios
 * de validação definidos (ex: comprimento, caracteres especiais, etc.).
 * Herda de {@link CampoInvalidoException}.
 */
public class SenhaInvalidaException extends CampoInvalidoException 
{
    /**
     * Construtor da exceção.
     * * @param mensagem A mensagem de erro que descreve por que a senha é inválida.
     */
    public SenhaInvalidaException(String mensagem) 
    {
        super(mensagem);
    }
}