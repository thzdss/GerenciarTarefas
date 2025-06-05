package com.gerenciadortarefas.GerenciarTarefas.Repository;


import com.gerenciadortarefas.GerenciarTarefas.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}