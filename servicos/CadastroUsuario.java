package servicos;

import java.util.List;
import entidades.usuarios.Usuario;
import excecoes.CampoInvalidoException;
import excecoes.EmailInvalidoException;
import excecoes.SenhaInvalidaException;
import excecoes.UsuarioJaCadastradoException;

/**
 * Serviço responsável por gerenciar o cadastro de novos usuários no sistema.
 * Aplica regras de validação antes de permitir a criação de um usuário.
 */
public class CadastroUsuario {

    private List<Usuario> usuarios;

    /**
     * Construtor do serviço de cadastro de usuários.
     *
     * @param usuarios A lista principal de usuários do sistema, que será gerenciada por este serviço.
     */
    public CadastroUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Tenta cadastrar um novo usuário após passar por todas as validações.
     *
     * @param usuario O objeto Usuario a ser cadastrado.
     * @throws CampoInvalidoException Se algum campo obrigatório for inválido.
     * @throws UsuarioJaCadastradoException Se o email do usuário já existir no sistema.
     */
    public void cadastrarUsuario(Usuario usuario) throws CampoInvalidoException
    {
        validarUsuario(usuario);
        usuarios.add(usuario);
    }

     /**
     * Método privado que centraliza todas as regras de validação para um novo usuário.
     *
     * @param usuario O usuário a ser validado.
     * @throws CampoInvalidoException Se algum campo básico for inválido.
     * @throws EmailInvalidoException Se o formato do email for inválido.
     * @throws SenhaInvalidaException Se a senha não atender aos critérios.
     * @throws UsuarioJaCadastradoException Se o email já estiver em uso.
     */
    private void validarUsuario(Usuario usuario) throws CampoInvalidoException, UsuarioJaCadastradoException
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

        // Validação de duplicidade de email
        for (Usuario uExistente : this.usuarios) {
            if (uExistente.getEmail().equalsIgnoreCase(usuario.getEmail())) {
                throw new UsuarioJaCadastradoException("O email '" + usuario.getEmail() + "' já está em uso.");
            }
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new CampoInvalidoException("Senha não pode ser vazia");
        }

        if (usuario.getSenha().length() > 20) {
        throw new SenhaInvalidaException("Senha não pode ter mais que 20 caracteres.");
    }
    }

    /**
     * Retorna a lista de todos os usuários cadastrados.
     *
     * @return A lista de usuários.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
