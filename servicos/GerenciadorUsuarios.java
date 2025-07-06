package servicos;

import java.util.Iterator;
import java.util.List;

import entidades.usuarios.Aluno;
import entidades.usuarios.Professor;
import entidades.usuarios.ServidorAdministrativo;
import entidades.usuarios.Usuario;
import excecoes.UsuarioNaoEncontradoException;

public class GerenciadorUsuarios {

    private List<Usuario> usuarios;

    public GerenciadorUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario buscarPorMatricula(String matricula) throws UsuarioNaoEncontradoException {

        for (Usuario usuario : this.usuarios) {
            if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                
                if (String.valueOf(aluno.getMatricula()).equals(matricula)) {
                    return aluno;
                }
            } 
           
            else if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
               
                if (professor.getMatriculaInstitucional().equals(matricula)) {
                    return professor;
                }
            }
        }
        // se o loop terminar, nenhum usuário com essa matrícula foi encontrado.
        throw new UsuarioNaoEncontradoException("Nenhum usuário encontrado com a matrícula: " + matricula);
    }

    public void deletarPorMatricula(String matricula) throws UsuarioNaoEncontradoException {
        Iterator<Usuario> iterador = this.usuarios.iterator();
        boolean encontrado = false;
        
        while (iterador.hasNext()) {
            Usuario usuario = iterador.next();
            String matriculaAtual = null;

            if (usuario instanceof Aluno) {
                // converte a matrícula do aluno (que pode ser int) para String para comparação
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

    public Usuario buscarPorEmail(String email) throws UsuarioNaoEncontradoException {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        throw new UsuarioNaoEncontradoException("Nenhum usuário encontrado com o email: " + email);
    }
}