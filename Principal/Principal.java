package Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entidades.Pessoas.Usuario;
import Servicos.Cadastro;
import Servicos.CadastroAluno;
import Servicos.CadastroProfessor;
import Servicos.CadastroServidor;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcao;

        List<Usuario> usuarios = new ArrayList<>();

        do {
            System.out.println("Informe o numero do seu perfil:");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.println("3 - Servidor Administrativo");
            int perfil = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente

            Cadastro cadastro = null;

            switch (perfil) {
                case 1:
                    cadastro = new CadastroAluno(usuarios);
                    break;
                case 2:
                    cadastro = new CadastroProfessor(usuarios);
                    break;
                case 3:
                    cadastro = new CadastroServidor(usuarios);
                    break;
                default:
                    System.out.println("Perfil inválido. Tente novamente.");
            }

            if (cadastro != null) {
                cadastro.cadastrar();
            }

            System.out.println("Deseja realizar outro cadastro? (s/n)");
            opcao = sc.nextLine().toLowerCase();

        } while (opcao.equals("s"));

        if (!usuarios.isEmpty()) {
            Cadastro.imprimirUsuarios(usuarios);
        } else {
            System.out.println("Nenhum usuário cadastrado.");
        }

        sc.close();
    }
}