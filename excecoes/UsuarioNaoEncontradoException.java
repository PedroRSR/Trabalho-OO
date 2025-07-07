package excecoes;

/**
 * Exceção lançada quando uma busca por um usuário, utilizando um identificador
 * único como email ou matrícula, não retorna nenhum resultado.
 */
public class UsuarioNaoEncontradoException extends Exception 
{
    /**
     * Construtor da exceção.
     * * @param mensagem A mensagem de erro que informa qual identificador foi usado na busca sem sucesso.
     */
    public UsuarioNaoEncontradoException(String mensagem) 
    {
        super(mensagem);
    }
}