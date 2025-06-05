package com.gerenciadortarefas.GerenciarTarefas.Service;

import com.gerenciadortarefas.GerenciarTarefas.Model.Usuario;
import com.gerenciadortarefas.GerenciarTarefas.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluir(int id) {
        usuarioRepository.deleteById(id);
    }


    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}