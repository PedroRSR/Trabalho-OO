package servicos;

import java.util.List;
import entidades.usuarios.Usuario;
import excecoes.CampoInvalidoException;
import excecoes.EmailInvalidoException;
import excecoes.SenhaInvalidaException;

public class CadastroUsuario {

    private List<Usuario> usuarios;

    public CadastroUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void cadastrarUsuario(Usuario usuario) throws CampoInvalidoException
    {
        validarUsuario(usuario);
        usuarios.add(usuario);
    }

    private void validarUsuario(Usuario usuario) throws CampoInvalidoException
    {
        if (usuario.getNome() == null || usuario.getNome().isEmpty())
        {
            throw new CampoInvalidoException("Nome não pode ser vazio.");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new CampoInvalidoException("Email não pode ser vazio");
        }

         if (!usuario.getEmail().matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$")) 
         {
            throw new EmailInvalidoException("Formato de email inválido.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new CampoInvalidoException("Senha não pode ser vazia");
        }

        if (usuario.getSenha().length() > 20) {
        throw new SenhaInvalidaException("Senha não pode ter mais que 20 caracteres.");
    }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
