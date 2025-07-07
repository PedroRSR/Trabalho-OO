package entidades.usuarios;

/**
 * Representa um Professor no sistema, um tipo específico de Usuário.
 * Contém informações adicionais como matrícula institucional, cargo e curso que ministra.
 */
public class Professor extends Usuario {
    private String cargo,
                   curso,
                   matriculaInstitucional;

    /**
     * Construtor para criar uma nova instância de Professor.
     *
     * @param nome O nome completo do professor.
     * @param email O endereço de email do professor.
     * @param telefone O número de telefone do professor.
     * @param senha A senha de acesso do professor.
     * @param matriculaInstitucional A matrícula institucional do professor.
     * @param cargo O cargo acadêmico do professor (ex: assistente, adjunto).
     * @param curso O principal curso ou disciplina que o professor ministra.
     */
    public Professor(String nome, String email, String telefone, String senha, String matriculaInstitucional, String cargo, String curso) 
    {
        super(nome, email, telefone, senha);
        this.cargo = cargo;
        this.curso = curso;
        this.matriculaInstitucional = matriculaInstitucional;
    }

    /**
     * Retorna a matrícula institucional do professor.
     *
     * @return A matrícula institucional.
     */
    public String getMatriculaInstitucional()
    {
        return matriculaInstitucional;
    }
    
    /**
     * Retorna o cargo acadêmico do professor.
     *
     * @return O cargo do professor.
     */
    public String getCargo() 
    {
        return cargo;
    }

    /**
     * Retorna o curso que o professor ministra.
     *
     * @return O nome do curso.
     */
    public String getCurso() 
    {
        return curso;
    }

    /**
     * Retorna o tipo específico deste usuário.
     *
     * @return A String "Professor".
     */
    @Override
    public String getTipoUsuario() 
    {
        return "Professor";
    }
}