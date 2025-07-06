package Entidades.pessoas;

public class ServidorAdministrativo extends Servidor {
    private String cargoAdministrativo,
                   departamento;

    public ServidorAdministrativo(String nome, String email, String telefone, String senha, int matriculaInstitucional, String cargoAdministrativo, String departamento) {
        super(nome, email, telefone, senha, matriculaInstitucional);
        this.cargoAdministrativo = cargoAdministrativo;
        this.departamento = departamento;
    }

    public String getCargoAdministrativo() {
        return cargoAdministrativo;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    @Override
    public String getTipoUsuario() {
        return "Servidor Administrativo";
    }
}