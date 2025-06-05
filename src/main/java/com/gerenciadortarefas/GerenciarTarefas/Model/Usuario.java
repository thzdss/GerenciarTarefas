package com.gerenciadortarefas.GerenciarTarefas.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "usuario") 
@Component
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;


    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Tarefa> tarefas = new ArrayList<>();


    public void adicionarTarefa(Tarefa tarefa) {
        tarefa.setUsuario(this);
        this.tarefas.add(tarefa);
    }
}