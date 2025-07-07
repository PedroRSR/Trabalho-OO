package entidades.usuarios;

/**
 * Representa um Servidor Administrativo no sistema, um tipo específico de Usuário.
 * Contém informações adicionais como o cargo e o departamento.
 */
public class ServidorAdministrativo extends Usuario {
    private String cargoAdministrativo,
                   departamento;

    /**
     * Construtor para criar uma nova instância de ServidorAdministrativo.
     *
     * @param nome O nome completo do servidor.
     * @param email O endereço de email do servidor.
     * @param telefone O número de telefone do servidor.
     * @param senha A senha de acesso do servidor.
     * @param cargoAdministrativo O cargo específico do servidor (ex: "Secretário", "Técnico").
     * @param departamento O departamento no qual o servidor trabalha.
     */
    public ServidorAdministrativo(String nome, String email, String telefone, String senha, String cargoAdministrativo, String departamento) 
    {
        super(nome, email, telefone, senha);
        this.cargoAdministrativo = cargoAdministrativo;
        this.departamento = departamento;
    }

    /**
     * Retorna o cargo administrativo do servidor.
     *
     * @return O cargo do servidor.
     */
    public String getCargoAdministrativo() 
    {
        return cargoAdministrativo;
    }

    /**
     * Retorna o departamento do servidor.
     *
     * @return O departamento do servidor.
     */
    public String getDepartamento() 
    {
        return departamento;
    }
    
    /**
     * Retorna o tipo específico deste usuário.
     *
     * @return A String "Servidor Administrativo".
     */
    @Override
    public String getTipoUsuario() 
    {
        return "Servidor Administrativo";
    }
}