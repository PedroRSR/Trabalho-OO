package entidades.usuarios;

public abstract class Usuario {
    protected String nome,
                     email,
                     telefone,
                     senha;

    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
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