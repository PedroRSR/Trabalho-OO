package Entidades.pessoas;

public abstract class Usuario {
    protected String nomeCompleto,
                     email,
                     telefone,
                     senha;

    public Usuario(String nome, String email, String telefone, String senha) {
        this.nomeCompleto = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    
    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }
    
    public abstract String getTipoUsuario();
}