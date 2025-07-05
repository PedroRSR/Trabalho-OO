package Menus;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    
    public static int exibir() {
        String opcoes = "Escolha uma opção:\n" +
                        "1 - Abrir menu de alunos\n" +
                        "2 - Abrir menu de professores\n" +
                        "3 - Abrir menu de servidores administrativos\n" +
                        "4 - Abrir menu de espaços físicos\n" +
                        "0 - Sair";

        String strOpcao = JOptionPane.showInputDialog(opcoes);
        int opcao = Integer.parseInt(strOpcao);

        return opcao;
    }

}
