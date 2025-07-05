package Menus;

import javax.swing.JOptionPane;

import Entidades.Pessoas.Administrativo;
import Servicos.CadastroUsuario;

public class MenuServidoresAdm {

    public static void exibir() {

        String opcoes = "Escolha uma opção:\n" +
                        "1 - Cadastrar servidor administrativo\n" +
                        "2 - Reservar espaço físico\n" +
                        "0 - Voltar ao menu principal";
        
        int opcao = -1;
        
        do {
            String strOpcao = JOptionPane.showInputDialog(opcoes);
            opcao = Integer.parseInt(strOpcao);
        
            switch (opcao) {
                case 1:
                    cadastrarServidor();
                    break;
                case 2:
                    reservarEspacoFisico();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void reservarEspacoFisico() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservarEspacoFisico'");
    }

    private static void cadastrarServidor() {
        Administrativo servidor = criarServidor();
        CadastroUsuario.cadastrar(servidor);
    }

    public static Administrativo criarServidor() {
        String nome = JOptionPane.showInputDialog("Informe seu nome completo:");
        String email = JOptionPane.showInputDialog("Informe seu email:");
        String telefone = JOptionPane.showInputDialog("Informe seu telefone:");
        String senha = JOptionPane.showInputDialog("Informe sua senha:");
        int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe sua matrícula institucional:"));
        String cargoAdministrativo = JOptionPane.showInputDialog("Informe seu cargo administrativo:");
        String departamento = JOptionPane.showInputDialog("Informe a departamento que leciona:");
        
        return new Administrativo(nome, email, telefone, senha, matricula, cargoAdministrativo, departamento);
    }
}
