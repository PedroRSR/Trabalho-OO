package entidades.usuarios;

public class Professor extends Usuario {
    private String cargo,
                   curso,
                   matriculaInstitucional;

    public Professor(String nome, String email, String telefone, String senha, String matriculaInstitucional, String cargo, String curso) 
    {
        super(nome, email, telefone, senha);
        this.cargo = cargo;
        this.curso = curso;
        this.matriculaInstitucional = matriculaInstitucional;
    }

    public String getMatriculaInstitucional()
    {
        return matriculaInstitucional;
    }
    
    public String getCargo() 
    {
        return cargo;
    }

    public String getCurso() 
    {
        return curso;
    }

    @Override
    public String getTipoUsuario() 
    {
        return "Professor";
    }
}