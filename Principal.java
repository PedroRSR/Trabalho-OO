import javax.swing.JOptionPane;

import servicos.CadastroUsuario;

public class Principal {
    static CadastroUsuario cadastroUsuario;
    public static void main(String[] args) {
        cadastroUsuario = new CadastroUsuario();

        int opcao = 0;

        do {
            
            switch (opcao) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    // MenuEspacosFisicos.exibir(); // Implementar MenuEspacosFisicos
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema. Até logo!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
    }
}