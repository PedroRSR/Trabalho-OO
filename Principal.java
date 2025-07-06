import javax.swing.*;
import java.time.LocalDate;
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

public class Principal {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<EspacoFisico> espacos = new ArrayList<>();
    private static CadastroUsuario cadastroUsuario = new CadastroUsuario(usuarios);
    private static CadastroEspacoFisico cadastroEspaco = new CadastroEspacoFisico(espacos);
    private static GerenciadorAgendamento gerenciadorAgendamento = new GerenciadorAgendamento();
    private static GeradorRelatorios geradorRelatorios = new GeradorRelatorios(gerenciadorAgendamento.getAgendamentos());

    public static void main(String[] args) {
        while (true) {
            String[] opcoes = { "Cadastrar Usuário", "Cadastrar Espaço Físico", "Fazer Agendamento", "Gerar Relatórios", "Sair" };
            int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == 0) {
                cadastrarUsuario();
            } else if (escolha == 1) {
                cadastrarEspacoFisico();
            } else if (escolha == 2) {
                fazerAgendamento();
            } else if (escolha == 3) {
                gerarRelatorios();
            } else {
                break;
            }
        }
    }

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

            String nomeUsuario = JOptionPane.showInputDialog("Digite o nome completo do usuário que vai agendar:");
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

        } catch (DiasExcedidosException | HorarioIndisponivelException e) {
            JOptionPane.showMessageDialog(null, "Erro no agendamento: " + e.getMessage());
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida. Use o formato AAAA-MM-DD.");
        }
    }

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
                LocalDate dataInicio = LocalDate.parse(dataInicioStr);
                LocalDate dataFim = LocalDate.parse(dataFimStr);

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
                JOptionPane.showMessageDialog(null, "Data inválida. Use o formato AAAA-MM-DD.");
            }
        }
    }
}
