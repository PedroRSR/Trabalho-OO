package Entidades.Pessoas;

public class Administrativo extends Servidor {
    private String cargoAdministrativo;
    private String departamento;

    public Administrativo(String nome, String email, String telefone, String senha, int matriculaInstitucional, String cargoAdministrativo, String departamento) {
        super(nome, email, telefone, senha, matriculaInstitucional);
        this.cargoAdministrativo = cargoAdministrativo;
        this.departamento = departamento;
    }

    public int getMatriculaInstitucional() {
        return super.getMatriculaInstitucional();
    }

    public String getCargoAdministrativo() {
        return cargoAdministrativo;
    }

    public String getDepartamento() {
        return departamento;
    }
    
}