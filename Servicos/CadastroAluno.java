package Servicos;

import java.util.List;

import Entidades.Pessoas.Aluno;
import Entidades.Pessoas.Usuario;

public class CadastroAluno extends Cadastro {
    
    public CadastroAluno(List<Usuario> usuarios) {
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
        
        System.out.print("Informe seu curso: ");
        String curso = sc.nextLine();
        System.out.print("Informe sua matricula: ");
        int matricula = sc.nextInt();
        System.out.print("Informe seu semestre de matricula: ");
        int semMatricula = sc.nextInt();

        usuarios.add(new Aluno(nome, email, telefone, senha, curso, matricula, semMatricula));

        System.out.println("Aluno cadastrado com sucesso!");

        System.out.println("------------------------------");

    }

}