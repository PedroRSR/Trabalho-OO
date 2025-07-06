package excecoes;

public class EmailInvalidoException extends CampoInvalidoException
{
    public EmailInvalidoException(String mensagem) 
    {
        super(mensagem);
    }
}
