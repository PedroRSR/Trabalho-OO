package Principal;

import Menus.MenuAlunos;
import Menus.MenuPrincipal;
import Menus.MenuProfessores;
import Menus.MenuServidoresAdm;

public class Principal {
    public static void main(String[] args) {

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
                    break;
            }
        } while (opcao != 0);
    }
}