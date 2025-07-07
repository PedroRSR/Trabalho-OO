package excecoes;

/**
 * Exceção específica lançada quando um email já está sendo utilizado em um cadastro.
 * Herda de {@link CampoInvalidoException}.
 */
public class UsuarioJaCadastradoException extends CampoInvalidoException 
{
    /**
     * Construtor da exceção.
     * * @param mensagem A mensagem de erro que descreve que o e-mail já está senso utilizado.
     */
    public UsuarioJaCadastradoException(String mensagem) 
    {
        super(mensagem);
    }
}