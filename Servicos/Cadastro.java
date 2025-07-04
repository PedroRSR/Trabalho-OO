package Servicos;

import java.util.List;
import java.util.Scanner;

import Entidades.Usuario;

public abstract class Cadastro {
    static Scanner sc = new Scanner(System.in);

    protected List<Usuario> usuarios;

    public Cadastro(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public abstract void cadastrar();
    
    public static void imprimirUsuarios(List<Usuario> usuarios) {
        System.out.println("\n=== Usuários Cadastrados ===");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
        System.out.println("");
    }

}