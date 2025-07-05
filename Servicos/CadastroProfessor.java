package Servicos;

import java.util.List;

import Entidades.Pessoas.Professor;
import Entidades.Pessoas.Usuario;

public class CadastroProfessor extends Cadastro {
    
    public CadastroProfessor(List<Usuario> usuarios) {
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
        System.out.print("Informe seu cargo academico: ");
        String cargoAcademico = sc.nextLine();
        System.out.print("Informe o curso que voce ministra: ");
        String curso = sc.nextLine();

        usuarios.add(new Professor(nome, email, telefone, senha, matriculaInstitucional, cargoAcademico, curso));

        System.out.println("Professor cadastrado com sucesso!");

        System.out.println("------------------------------");

    }
    
}