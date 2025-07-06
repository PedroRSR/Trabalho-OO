package entidades.pessoas;

public abstract class Servidor extends Usuario {
    private int matriculaInstitucional;

    public Servidor(String nome, String email, String telefone, String senha, int matriculaInstitucional) {
        super(nome, email, telefone, senha);
        this.matriculaInstitucional = matriculaInstitucional;
    }

    public int getMatriculaInstitucional() {
        return matriculaInstitucional;
    }
}