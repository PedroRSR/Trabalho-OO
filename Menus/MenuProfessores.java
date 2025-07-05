package Menus;

import Entidades.Pessoas.Professor;
import Servicos.CadastroUsuario;

public class MenuProfessores {
    
    public static void exibir() {

        String opcoes = "Escolha uma opção:\n" +
                        "1 - Cadastrar professor\n" +
                        "2 - Reservar espaço físico\n" +
                        "0 - Voltar ao menu principal";
        
        int opcao = -1;
        
        do {
            String strOpcao = javax.swing.JOptionPane.showInputDialog(opcoes);
            opcao = Integer.parseInt(strOpcao);
        
            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    reservarEspacoFisico();
                    break;
                case 0:
                    break;
                default:
                    javax.swing.JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void reservarEspacoFisico() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservarEspacoFisico'");
    }

    private static void cadastrarProfessor() {
        Professor professor = criarProfessor();
        CadastroUsuario.cadastrar(professor);
    }

    public static Professor criarProfessor() {
        String nome = javax.swing.JOptionPane.showInputDialog("Informe seu nome completo:");
        String email = javax.swing.JOptionPane.showInputDialog("Informe seu email:");
        String telefone = javax.swing.JOptionPane.showInputDialog("Informe seu telefone:");
        String senha = javax.swing.JOptionPane.showInputDialog("Informe sua senha:");
        int matricula = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Informe sua matrícula institucional:"));
        String cargoAcademico = javax.swing.JOptionPane.showInputDialog("Informe seu cargo acadêmico:");
        String curso = javax.swing.JOptionPane.showInputDialog("Informe a curso que leciona:");
        
        return new Professor(nome, email, telefone, senha, matricula, cargoAcademico, curso);
    }
}
