package Principal;

import Menus.MenuAlunos;
import Menus.MenuPrincipal;
import Menus.MenuProfessores;
import Menus.MenuServidoresAdm;
import Servicos.CadastroUsuario;

public class Principal {
    static CadastroUsuario cadastroUsuario;
    public static void main(String[] args) {
        cadastroUsuario = new CadastroUsuario();

        int opcao = 0;

        do {
            opcao = MenuPrincipal.exibir();
            switch (opcao) {
                case 1:
                    MenuAlunos.exibir();
                    break;
                case 2:
                    MenuProfessores.exibir();
                    break;
                case 3:
                    MenuServidoresAdm.exibir();
                    break;
                case 4:
                    // MenuEspacosFisicos.exibir(); // Implementar MenuEspacosFisicos
                    break;
                case 0:
                    javax.swing.JOptionPane.showMessageDialog(null, "Saindo do sistema. Até logo!");
                    break;
                default:
                    javax.swing.JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
    }
}