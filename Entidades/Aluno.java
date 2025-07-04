package Entidades;
public class Aluno extends Usuario{
    String curso;
    int matricula;
    int semMatricula;

    public Aluno(String nome, String email, String telefone, String senha, String curso, int matricula, int semMatricula) {
        super(nome, email, telefone, senha);
        this.curso = curso;
        this.matricula = matricula;
        this.semMatricula = semMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getSemMatricula() {
        return semMatricula;
    }
}