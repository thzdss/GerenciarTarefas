package com.gerenciadortarefas.GerenciarTarefas.Repository;

import com.gerenciadortarefas.GerenciarTarefas.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findByUsuarioId(int usuarioId);
}