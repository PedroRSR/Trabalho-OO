package servicos;

import java.util.ArrayList;
import java.util.List;

import entidades.pessoas.Usuario;

public class CadastroUsuario {

    private static List<Usuario> usuarios;

    public CadastroUsuario() {
        CadastroUsuario.usuarios = new ArrayList<>();
    }

    public static void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
}
