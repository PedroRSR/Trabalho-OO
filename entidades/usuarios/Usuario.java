package entidades.usuarios;

/**
 * Classe abstrata que serve como base para todos os tipos de usuários do sistema.
 * Contém os atributos e métodos comuns a qualquer usuário, como nome, email, etc.
 */
public abstract class Usuario {
    protected String nome,
                     email,
                     telefone,
                     senha;

    /**
     * Construtor para a classe base Usuario.
     *
     * @param nome O nome completo do usuário.
     * @param email O endereço de email do usuário, usado para login e contato.
     * @param telefone O número de telefone de contato do usuário.
     * @param senha A senha de acesso do usuário ao sistema.
     */
    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    /**
     * Retorna o nome completo do usuário.
     *
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna o email do usuário.
     *
     * @return O email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retorna o telefone de contato do usuário.
     *
     * @return O telefone do usuário.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Método abstrato que força as subclasses a implementarem um método
     * que retorne seu tipo específico como uma String.
     *
     * @return O tipo do usuário (ex: "Aluno", "Professor").
     */
    public abstract String getTipoUsuario();
}