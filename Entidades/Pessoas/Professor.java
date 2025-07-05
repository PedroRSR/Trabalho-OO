package Entidades.Pessoas;

public class Professor extends Servidor {
    private String cargoAcademico,
                   curso;

    public Professor(String nome, String email, String telefone, String senha, int matriculaInstitucional, String cargoAcademico, String curso) {
        super(nome, email, telefone, senha, matriculaInstitucional);
        this.cargoAcademico = cargoAcademico;
        this.curso = curso;
    }

    public int getMatriculaInstitucional() {
        return super.getMatriculaInstitucional();
    }

    public String getCargoAcademico() {
        return cargoAcademico;
    }

    public String getCurso() {
        return curso;
    }
    
}