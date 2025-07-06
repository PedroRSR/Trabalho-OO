package excecoes;

public class SenhaInvalidaException extends CampoInvalidoException 
{
    public SenhaInvalidaException(String mensagem) 
    {
        super(mensagem);
    }
}
