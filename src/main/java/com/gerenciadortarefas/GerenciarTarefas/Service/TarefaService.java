package com.gerenciadortarefas.GerenciarTarefas.Service;

import com.gerenciadortarefas.GerenciarTarefas.Model.Tarefa;
import com.gerenciadortarefas.GerenciarTarefas.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void excluir(int id) {
        tarefaRepository.deleteById(id);
    }

    public Tarefa buscarPorId(int id) {
        return tarefaRepository.findById(id).orElse(null);
    }


    public List<Tarefa> listarPorUsuario(int usuarioId) {
        return tarefaRepository.findByUsuarioId(usuarioId);
    }
}