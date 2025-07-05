package Menus;

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
            String strOpcao = javax.swing.JOptionPane.showInputDialog(opcoes);
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
                    javax.swing.JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
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
        String nome = javax.swing.JOptionPane.showInputDialog("Informe seu nome completo:");
        String email = javax.swing.JOptionPane.showInputDialog("Informe seu email:");
        String telefone = javax.swing.JOptionPane.showInputDialog("Informe seu telefone:");
        String senha = javax.swing.JOptionPane.showInputDialog("Informe sua senha:");
        int matricula = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Informe sua matrícula institucional:"));
        String cargoAdministrativo = javax.swing.JOptionPane.showInputDialog("Informe seu cargo administrativo:");
        String departamento = javax.swing.JOptionPane.showInputDialog("Informe a departamento que leciona:");
        
        return new Administrativo(nome, email, telefone, senha, matricula, cargoAdministrativo, departamento);
    }
}
