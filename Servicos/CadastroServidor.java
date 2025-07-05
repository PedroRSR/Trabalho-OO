package Servicos;

import java.util.List;

import Entidades.Pessoas.Administrativo;
import Entidades.Pessoas.Usuario;

public class CadastroServidor extends Cadastro {

    public CadastroServidor(List<Usuario> usuarios) {
        super(usuarios);
    }

    public void cadastrar() {

        System.out.print("Informe seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Informe seu email: ");
        String email = sc.nextLine();
        System.out.print("Informe seu telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Informe sua senha: ");
        String senha = sc.nextLine();
        
        System.out.print("Informe sua matricula institucional: ");
        int matriculaInstitucional = sc.nextInt();
        System.out.print("Informe seu cargo administrativo: ");
        String cargoAdministrativo = sc.nextLine();
        System.out.print("Informe o departamento que voce trabalha: ");
        String departamento = sc.nextLine();

        usuarios.add(new Administrativo(nome, email, telefone, senha, matriculaInstitucional, cargoAdministrativo, departamento));

        System.out.println("Servidor administrativo cadastrado com sucesso!");

        System.out.println("------------------------------");

    }
    
}