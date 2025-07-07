package entidades.usuarios;

/**
 * Representa um Aluno no sistema, um tipo específico de Usuário.
 * Contém informações adicionais como curso, matrícula e semestre.
 */
public class Aluno extends Usuario
{
    private String curso;
    private String matricula;
    private String semestre; 

    /**
     * Construtor para criar uma nova instância de Aluno.
     *
     * @param nome O nome completo do aluno.
     * @param email O endereço de email do aluno.
     * @param telefone O número de telefone do aluno.
     * @param senha A senha de acesso do aluno.
     * @param curso O curso no qual o aluno está matriculado.
     * @param matricula O número de matrícula do aluno.
     * @param semestre O semestre atual do aluno.
     */
    public Aluno(String nome, String email, String telefone, String senha, String curso, String matricula, String semestre) 
    {
        super(nome, email, telefone, senha);
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
    }

    /**
     * Retorna o curso do aluno.
     *
     * @return O nome do curso.
     */
    public String getCurso() 
    {
        return curso;
    }

    /**
     * Retorna o número de matrícula do aluno.
     *
     * @return O número de matrícula.
     */
    public String getMatricula() 
    {
        return matricula;
    }

    /**
     * Retorna o semestre em que o aluno está.
     *
     * @return O semestre do aluno.
     */
    public String getSemestre() 
    {
        return semestre;
    }

    /**
     * Retorna o tipo específico deste usuário.
     *
     * @return A String "Aluno".
     */
    @Override
    public String getTipoUsuario() 
    {
        return "Aluno";
    }
}