package entidades.usuarios;

public class ServidorAdministrativo extends Usuario {
    private String cargoAdministrativo,
                   departamento;

    public ServidorAdministrativo(String nome, String email, String telefone, String senha, String cargoAdministrativo, String departamento) 
    {
        super(nome, email, telefone, senha);
        this.cargoAdministrativo = cargoAdministrativo;
        this.departamento = departamento;
    }

    public String getCargoAdministrativo() 
    {
        return cargoAdministrativo;
    }

    public String getDepartamento() 
    {
        return departamento;
    }
    
    @Override
    public String getTipoUsuario() 
    {
        return "Servidor Administrativo";
    }
}