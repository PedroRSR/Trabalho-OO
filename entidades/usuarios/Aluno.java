package entidades.usuarios;

public class Aluno extends Usuario
{
    private String curso;
    private String matricula;
    private String semestre; 

    public Aluno(String nome, String email, String telefone, String senha, String curso, String matricula, String semestre) 
    {
        super(nome, email, telefone, senha);
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
    }

    public String getCurso() 
    {
        return curso;
    }

    public String getMatricula() 
    {
        return matricula;
    }

    public String getSemestre() 
    {
        return semestre;
    }

    @Override
    public String getTipoUsuario() 
    {
        return "Aluno";
    }
}