package servicos;

import java.util.Iterator;
import java.util.List;

import entidades.usuarios.Aluno;
import entidades.usuarios.Professor;
import entidades.usuarios.Usuario;
import excecoes.UsuarioNaoEncontradoException;

/**
 * Serviço que centraliza as operações de gerenciamento de usuários,
 * como busca e exclusão (operações de Leitura e Deleção do CRUD).
 */
public class GerenciadorUsuarios {

    private List<Usuario> usuarios;

    /**
     * Construtor do gerenciador de usuários.
     *
     * @param usuarios A lista principal de usuários do sistema.
     */
    public GerenciadorUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Busca um usuário (Aluno ou Professor) pela sua matrícula.
     *
     * @param matricula A matrícula a ser buscada.
     * @return O objeto Usuario correspondente.
     * @throws UsuarioNaoEncontradoException se nenhum usuário com a matrícula for encontrado.
     */
    public Usuario buscarPorMatricula(String matricula) throws UsuarioNaoEncontradoException {
        for (Usuario usuario : this.usuarios) {
            if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                if (String.valueOf(aluno.getMatricula()).equals(matricula)) {
                    return aluno;
                }
            } else if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
                if (professor.getMatriculaInstitucional().equals(matricula)) {
                    return professor;
                }
            }
        }
        throw new UsuarioNaoEncontradoException("Nenhum usuário encontrado com a matrícula: " + matricula);
    }

    /**
     * Deleta um usuário do sistema pela sua matrícula.
     *
     * @param matricula A matrícula do usuário a ser deletado.
     * @throws UsuarioNaoEncontradoException se o usuário não for encontrado para deleção.
     */
    public void deletarPorMatricula(String matricula) throws UsuarioNaoEncontradoException {
        Iterator<Usuario> iterador = this.usuarios.iterator();
        boolean encontrado = false;
        
        while (iterador.hasNext()) {
            Usuario usuario = iterador.next();
            String matriculaAtual = null;

            if (usuario instanceof Aluno) {
                matriculaAtual = String.valueOf(((Aluno) usuario).getMatricula());
            } else if (usuario instanceof Professor) {
                matriculaAtual = ((Professor) usuario).getMatriculaInstitucional();
            }

            if (matriculaAtual != null && matriculaAtual.equals(matricula)) {
                iterador.remove();
                encontrado = true;
                break; 
            }
        }

        if (!encontrado) {
            throw new UsuarioNaoEncontradoException("Não foi possível deletar. Nenhum usuário encontrado com a matrícula: " + matricula);
        }
    }

    /**
     * Busca um usuário de qualquer tipo pelo seu endereço de email.
     *
     * @param email O email a ser buscado (a comparação ignora maiúsculas/minúsculas).
     * @return O objeto Usuario correspondente.
     * @throws UsuarioNaoEncontradoException se nenhum usuário com o email for encontrado.
     */
    public Usuario buscarPorEmail(String email) throws UsuarioNaoEncontradoException {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        throw new UsuarioNaoEncontradoException("Nenhum usuário encontrado com o email: " + email);
    }
}