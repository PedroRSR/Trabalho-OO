import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import entidades.usuarios.*;
import entidades.espacosfisicos.*;
import entidades.Agendamento;
import servicos.*;
import excecoes.*;

/**
 * Classe principal da aplicação, responsável por gerenciar o ciclo de vida do programa
 * e a interação com o usuário através de uma interface gráfica baseada em JOptionPane.
 * Orquestra as chamadas para as diferentes classes de serviço.
 */
public class Principal {

    /**
     * Listas estáticas que funcionam como o "banco de dados" em memória da aplicação.
     * Mantêm o estado do sistema durante a sua execução.
     */
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<EspacoFisico> espacos = new ArrayList<>();

     /**
     * Instâncias estáticas dos serviços para que possam ser acessadas por todos os
     * métodos da classe Principal. A lista de dependência é injetada no construtor.
     */
    private static CadastroUsuario cadastroUsuario = new CadastroUsuario(usuarios);
    private static CadastroEspacoFisico cadastroEspaco = new CadastroEspacoFisico(espacos);
    private static GerenciadorAgendamento gerenciadorAgendamento = new GerenciadorAgendamento();
    private static GeradorRelatorios geradorRelatorios = new GeradorRelatorios(gerenciadorAgendamento.getAgendamentos());

    /**
     * Ponto de entrada da aplicação. Inicia um loop infinito que exibe o menu
     * principal e direciona o fluxo para os métodos correspondentes.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        while (true) {
            String[] opcoes = { "Gerenciar Usuários", "Gerenciar Espaços Físicos", "Fazer Agendamento", "Gerar Relatórios", "Sair" };
            int escolha = JOptionPane.showOptionDialog(null, "Selecione uma área para gerenciar:", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    gerenciarUsuarios(); // chama o sub-menu de usuários
                    break;
                case 1:
                    cadastrarEspacoFisico();
                    break;
                case 2:
                    fazerAgendamento();
                    break;
                case 3:
                    gerarRelatorios();
                    break;
                default: // caso o usuário feche a janela ou clique em Sair
                    System.exit(0);
                    return;
            }
        }
    }

    /**
     * Exibe o sub-menu de gerenciamento de usuários, permitindo ao usuário
     * escolher entre cadastrar, buscar ou deletar um usuário.
     */
    private static void gerenciarUsuarios() {
        String[] opcoes = { "Cadastrar Novo Usuário", "Buscar Usuário", "Deletar Usuário", "Voltar" };
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Gerenciamento de Usuários",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                cadastrarUsuario();
                break;
            case 1:
                buscarUsuario();
                break;
            case 2:
                deletarUsuario();
                break;
            default:
                return;
        }
    }

    /**
     * Controla o fluxo da interface para a busca de um usuário, permitindo a escolha
     * entre buscar por matrícula ou por email e exibindo os detalhes do usuário encontrado.
     * Trata internamente a exceção de usuário não encontrado.
     */
    private static void buscarUsuario() {

        String[] opcoesBusca = { "Buscar por Matrícula", "Buscar por Email" };
        int escolha = JOptionPane.showOptionDialog(null, "Como você deseja buscar o usuário?", "Critério de Busca",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesBusca, opcoesBusca[0]);

        if (escolha == -1) return; // Usuário fechou a janela

        Usuario encontrado = null;
        GerenciadorUsuarios gerenciador = new GerenciadorUsuarios(usuarios);

        try {
            if (escolha == 0) { // Busca por Matrícula
                String matricula = JOptionPane.showInputDialog("Digite a matrícula do usuário:");
                if (matricula == null || matricula.trim().isEmpty()) return;
                
                // Chama o serviço para buscar pela matrícula
                encontrado = gerenciador.buscarPorMatricula(matricula);

            } else { // Busca por Email
                String email = JOptionPane.showInputDialog("Digite o email do usuário:");
                if (email == null || email.trim().isEmpty()) return;

                // Chama o serviço para buscar pelo email
                encontrado = gerenciador.buscarPorEmail(email);
            }

            // se o try foi bem sucedido
            StringBuilder info = new StringBuilder("--- Usuário Encontrado ---\n\n");
            info.append("Nome: ").append(encontrado.getNome()).append("\n");
            info.append("Email: ").append(encontrado.getEmail()).append("\n");
            info.append("Telefone: ").append(encontrado.getTelefone()).append("\n");
            info.append("Tipo: ").append(encontrado.getTipoUsuario()).append("\n");

            // informações especificas
            if (encontrado instanceof Aluno) {
                Aluno aluno = (Aluno) encontrado;
                info.append("Matrícula do Aluno: ").append(aluno.getMatricula()).append("\n");
                info.append("Curso: ").append(aluno.getCurso()).append("\n");
            } else if (encontrado instanceof Professor) {
                Professor prof = (Professor) encontrado;
                info.append("Matrícula Institucional: ").append(prof.getMatriculaInstitucional()).append("\n");
                info.append("Cargo: ").append(prof.getCargo()).append("\n");
            } else if (encontrado instanceof ServidorAdministrativo) {
                ServidorAdministrativo adm = (ServidorAdministrativo) encontrado;
                info.append("Cargo: ").append(adm.getCargoAdministrativo()).append("\n");
                info.append("Departamento: ").append(adm.getDepartamento()).append("\n");
            }

            JOptionPane.showMessageDialog(null, info.toString(), "Detalhes do Usuário", JOptionPane.INFORMATION_MESSAGE);

        } catch (UsuarioNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro na busca: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Guia o usuário através do processo de cadastro de um novo usuário (Aluno, Professor ou Servidor),
     * coletando os dados e chamando o serviço de cadastro.
     * Trata internamente exceções de validação.
     */
    private static void cadastrarUsuario() {
        try {
            String tipo = JOptionPane.showInputDialog("Tipo de usuário (Aluno, Professor, Servidor):");
            if (tipo == null) return;

            String nome = JOptionPane.showInputDialog("Nome completo:");
            String email = JOptionPane.showInputDialog("Email institucional:");
            String telefone = JOptionPane.showInputDialog("Telefone:");
            String senha = JOptionPane.showInputDialog("Senha:");

            Usuario usuario = null;

            switch (tipo.toLowerCase()) 
            {
                case "aluno":
                    String cursoAluno = JOptionPane.showInputDialog("Curso:");
                    String matricula = JOptionPane.showInputDialog("Matrícula:");
                    String semestre = JOptionPane.showInputDialog("Semestre:");
                    usuario = new Aluno(nome, email, telefone, senha, cursoAluno, matricula, semestre);
                    break;

                case "professor":
                    String cursoProf = JOptionPane.showInputDialog("Curso que ministra:");
                    String matriculaInstitucional = JOptionPane.showInputDialog("Matrícula:");
                    String cargo = JOptionPane.showInputDialog("Cargo acadêmico (auxiliar, assistente, adjunto, associado, titular):");
                    usuario = new Professor(nome, email, telefone, senha, matriculaInstitucional, cargo, cursoProf);
                    break;

                case "servidor":
                    String funcao = JOptionPane.showInputDialog("Função/cargo:");
                    String departamento = JOptionPane.showInputDialog("Departamento:");
                    usuario = new ServidorAdministrativo(nome, email, telefone, senha, funcao, departamento);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Tipo inválido!");
                    return;
            }

            cadastroUsuario.cadastrarUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

        } catch (CampoInvalidoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido para semestre.");
        }
    }

    /**
     * Guia o usuário através do processo de cadastro de um novo espaço físico,
     * coletando os dados e chamando o serviço de cadastro.
     */
    private static void cadastrarEspacoFisico() {
        try {
            String tipo = JOptionPane.showInputDialog("Tipo de espaço (SalaAula, Laboratorio, SalaEstudo):");
            if (tipo == null) return;

            String nome = JOptionPane.showInputDialog("Nome do espaço:");
            int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Capacidade:"));
            String localizacao = JOptionPane.showInputDialog("Localização:");
            String equipamentosStr = JOptionPane.showInputDialog("Equipamentos (separados por vírgula):");
            List<String> equipamentos = new ArrayList<>();
            if (equipamentosStr != null && !equipamentosStr.trim().isEmpty()) 
            {
                for (String eq : equipamentosStr.split(",")) {
                    equipamentos.add(eq.trim());
                }
            }

            EspacoFisico espaco = null;
            switch (tipo.toLowerCase()) 
            {
                case "salaaula":
                    espaco = new SalaAula(nome, capacidade, localizacao, equipamentos);
                    break;
                case "laboratorio":
                    espaco = new Laboratorio(nome, capacidade, localizacao, equipamentos);
                    break;
                case "auditorio":
                    espaco = new Auditorio(nome, capacidade, localizacao, equipamentos);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo de espaço inválido!");
                    return;
            }

            cadastroEspaco.cadastrarEspaco(espaco);
            JOptionPane.showMessageDialog(null, "Espaço cadastrado com sucesso!");

        } catch (CampoInvalidoException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido para capacidade.");
        }
    }

     /**
     * Controla o fluxo completo para que um usuário realize um agendamento.
     * Envolve a busca do usuário e do espaço, a coleta de datas e a chamada ao serviço de agendamento.
     * Trata internamente todas as exceções relacionadas ao processo.
     */
    private static void fazerAgendamento() {
        try {
            if (usuarios.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
                return;
            }
            if (espacos.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Nenhum espaço físico cadastrado.");
                return;
            }

            
            String emailUsuario = JOptionPane.showInputDialog("Digite o EMAIL do usuário que vai agendar:");
            if (emailUsuario == null) return;

            
            GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios(usuarios);
            Usuario usuario = gerenciadorUsuarios.buscarPorEmail(emailUsuario);

            String nomeEspaco = JOptionPane.showInputDialog("Digite o nome do espaço físico para agendar:");
            if (nomeEspaco == null) return;

            EspacoFisico espaco = null;
            for (EspacoFisico e : espacos) 
            {
                if (e.getNome().equalsIgnoreCase(nomeEspaco)) {
                    espaco = e;
                    break;
                }
            }

            if (espaco == null) 
            {
                JOptionPane.showMessageDialog(null, "Espaço físico não encontrado.");
                return;
            }

            String dataInicioStr = JOptionPane.showInputDialog("Data e HORA de início (AAAA-MM-DD HH:mm):");
            String dataFimStr = JOptionPane.showInputDialog("Data e HORA de fim (AAAA-MM-DD HH:mm):");
            if (dataInicioStr == null || dataFimStr == null) return;

            // formatador que entende a hora
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            LocalDateTime dataInicio = LocalDateTime.parse(dataInicioStr, formatter);
            LocalDateTime dataFim = LocalDateTime.parse(dataFimStr, formatter);

            gerenciadorAgendamento.agendar(usuario, espaco, dataInicio, dataFim);
            JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");

        } catch (UsuarioNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuário: " + e.getMessage());
        } catch (DiasExcedidosException | HorarioIndisponivelException e) {
            JOptionPane.showMessageDialog(null, "Erro no agendamento: " + e.getMessage());
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida. Use o formato AAAA-MM-DD HH:mm.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    /**
     * Controla o fluxo de deleção de um usuário, pedindo a matrícula e uma confirmação
     * antes de chamar o serviço de exclusão.
     * Trata internamente a exceção de usuário não encontrado.
     */
    private static void deletarUsuario() {
        try {
            String matricula = JOptionPane.showInputDialog("Digite a matrícula do usuário a ser DELETADO:");
            if (matricula == null || matricula.trim().isEmpty()) {
                return;
            }

            GerenciadorUsuarios gerenciador = new GerenciadorUsuarios(usuarios);

            int confirmacao = JOptionPane.showConfirmDialog(null, 
                "Tem certeza que deseja deletar o usuário com matrícula " + matricula + "?\nEsta ação não pode ser desfeita.", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);

            if (confirmacao == JOptionPane.YES_OPTION) {
                gerenciador.deletarPorMatricula(matricula);
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
            }

        } catch (UsuarioNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        }
    }

    /**
     * Exibe o sub-menu de relatórios, permitindo ao usuário gerar relatórios
     * por usuário ou por espaço em um determinado período.
     */
    private static void gerarRelatorios() {
        String[] opcoes = { "Por Usuário", "Por Espaço", "Voltar" };
        int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de relatório:", "Relatórios",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do usuário:");
            if (nomeUsuario == null) return;

            Usuario usuario = null;
            for (Usuario u : usuarios) 
            {
                if (u.getNome().equalsIgnoreCase(nomeUsuario)) {
                    usuario = u;
                    break;
                }
            }

            if (usuario == null) 
            {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                return;
            }

            List<Agendamento> lista = geradorRelatorios.relatorioPorUsuario(usuario);
            if (lista.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Nenhum agendamento encontrado para esse usuário.");
            } else 
            {
                StringBuilder sb = new StringBuilder("Agendamentos do usuário " + usuario.getNome() + ":\n");
                for (Agendamento ag : lista) 
                {
                    sb.append(ag.getEspaco().getNome())
                      .append(" de ")
                      .append(ag.getDataInicio())
                      .append(" até ")
                      .append(ag.getDataFim())
                      .append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }

        } else if (escolha == 1) 
        {
            String nomeEspaco = JOptionPane.showInputDialog("Digite o nome do espaço físico:");
            if (nomeEspaco == null) return;

            EspacoFisico espaco = null;
            for (EspacoFisico e : espacos) 
            {
                if (e.getNome().equalsIgnoreCase(nomeEspaco)) {
                    espaco = e;
                    break;
                }
            }

            if (espaco == null) 
            {
                JOptionPane.showMessageDialog(null, "Espaço físico não encontrado.");
                return;
            }

            String dataInicioStr = JOptionPane.showInputDialog("Data início do período (AAAA-MM-DD):");
            String dataFimStr = JOptionPane.showInputDialog("Data fim do período (AAAA-MM-DD):");
            if (dataInicioStr == null || dataFimStr == null) return;

            try {
                LocalDateTime dataInicio = LocalDateTime.parse(dataInicioStr);
                LocalDateTime dataFim = LocalDateTime.parse(dataFimStr);

                List<Agendamento> lista = geradorRelatorios.relatorioPorEspaco(espaco, dataInicio, dataFim);
                if (lista.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "Nenhum agendamento encontrado para esse espaço nesse período.");
                } else 
                {
                    StringBuilder sb = new StringBuilder("Agendamentos do espaço " + espaco.getNome() + ":\n");
                    for (Agendamento ag : lista) 
                    {
                        sb.append(ag.getUsuario().getNome())
                          .append(" de ")
                          .append(ag.getDataInicio())
                          .append(" até ")
                          .append(ag.getDataFim())
                          .append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data inválida. Use o formato AAAA-MM-DD HH:mm.");
            }
        }
    }
}
