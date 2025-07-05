package Menus;

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
            String strOpcao = javax.swing.JOptionPane.showInputDialog(opcoes);
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
                    javax.swing.JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
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
        String nome = javax.swing.JOptionPane.showInputDialog("Informe seu nome completo:");
        String email = javax.swing.JOptionPane.showInputDialog("Informe seu email:");
        String telefone = javax.swing.JOptionPane.showInputDialog("Informe seu telefone:");
        String senha = javax.swing.JOptionPane.showInputDialog("Informe sua senha:");
        String curso = javax.swing.JOptionPane.showInputDialog("Informe seu curso:");
        int matricula = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Informe sua matrícula:"));
        int semMatricula = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Informe seu semestre de matrícula:"));
        return new Aluno(nome, email, telefone, senha, curso, matricula, semMatricula);
    }
}