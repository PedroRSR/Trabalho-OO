package Menus;

import javax.swing.JOptionPane;

import Entidades.Pessoas.Aluno;
import Servicos.CadastroUsuario;

public class MenuAlunos {

    public static void exibir() {

        String opcoes = "Escolha uma opção:\n" +
                        "1 - Cadastrar aluno\n" +
                        "2 - Reservar espaço físico\n" +
                        "0 - Voltar ao menu principal";

        int opcao = -1;

        do {
            String strOpcao = JOptionPane.showInputDialog(opcoes);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    cadastrarAluno();

                    break;
                case 2:
                    reservarEspacoFisico();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while (opcao != 0); 
        
    }

    private static void cadastrarAluno() {
        Aluno aluno = criarAluno();
        CadastroUsuario.cadastrar(aluno);
    }

    private static void reservarEspacoFisico() {
        // Implementar lógica de reserva de espaço físico
    }

    private static Aluno criarAluno() {
        String nome = JOptionPane.showInputDialog("Informe seu nome completo:");
        String email = JOptionPane.showInputDialog("Informe seu email:");
        String telefone = JOptionPane.showInputDialog("Informe seu telefone:");
        String senha = JOptionPane.showInputDialog("Informe sua senha:");
        String curso = JOptionPane.showInputDialog("Informe seu curso:");
        int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe sua matrícula:"));
        int semMatricula = Integer.parseInt(JOptionPane.showInputDialog("Informe seu semestre de matrícula:"));
        return new Aluno(nome, email, telefone, senha, curso, matricula, semMatricula);
    }
}